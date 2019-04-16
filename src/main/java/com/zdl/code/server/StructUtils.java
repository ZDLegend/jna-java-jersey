package com.zdl.code.server;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.jna.Structure;
import com.zdl.code.exception.StructException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ZDLegend on 2016/8/16.
 * <p>
 * 关于json的特殊操作函数写在这里
 * 提供json与结构体间相互转换方法
 */
public final class StructUtils {

    private static Logger logger = LoggerFactory.getLogger(StructUtils.class);

    private Structure stru;

    public StructUtils(Structure stru) {
        this.stru = stru;
    }

    /**
     * Json转结构体
     */
    public static void json2Struct(JSONObject jsonObject, Structure structure) throws StructException {
        Field[] fields = structure.getClass().getDeclaredFields();
        Map<String, Field> fieldMap = Stream.of(fields).collect(Collectors.toMap(Field::getName, f -> f));
        jsonObject.forEach((k, v) -> {
            if (fieldMap.containsKey(k)) {
                Field field = fieldMap.get(k);
                field.setAccessible(true);
                try {
                    Object object = field.get(structure);
                    if (object instanceof byte[]) {
                        StringUtils.setSdkBytes((byte[]) object, v.toString());
                    } else if (object.getClass().getName().contains("Structure")) {
                        if (object.getClass().isArray()) {
                            JSONArray array = jsonObject.getJSONArray(k);
                            int length = array.size();
                            for (int i = 0; i < length; i++) {
                                json2Struct(array.getJSONObject(i), (Structure) Array.get(object, i));
                            }
                        } else {
                            json2Struct(jsonObject.getJSONObject(k), (Structure) object);
                        }
                    } else {
                        field.set(structure, ClassUtils.cast(v, object.getClass()));
                    }
                } catch (IllegalAccessException ex) {
                    throw new StructException(ex.getMessage());
                }
            } else {
                logger.debug("{}该结构体类型中没有Json中的{}字段", structure.getClass().getName(), k);
            }
        });
    }

    /**
     * 结构体转Json
     */
    public static JSONObject struct2Json(Structure structure) {
        JSONObject jsonObject = new JSONObject();
        Field[] fields = structure.getClass().getDeclaredFields();
        Stream.of(fields).forEach(field -> {
            String varName = field.getName();
            varName = StringUtils.removLowerHaed(varName);
            try {
                field.setAccessible(true);
                Object obj = field.get(structure);
                if ("byte[]".equals(obj.getClass().getTypeName())) {
                    String str = StringUtils.bytesToString((byte[]) obj);
                    jsonObject.put(varName, str);
                } else if (obj.getClass().getName().contains("Structure")) {
                    if (obj.getClass().isArray()) {
                        JSONArray array = new JSONArray();
                        int length = Array.getLength(obj);
                        for (int i = 0; i < length; i++) {
                            array.add(i, struct2Json((Structure) Array.get(obj, i)));
                        }
                        jsonObject.put(varName, array);
                    } else {
                        jsonObject.put(varName, struct2Json((Structure) obj));
                    }
                } else {
                    jsonObject.put(varName, obj);
                }
            } catch (Exception ex) {
                logger.error(ex.getMessage(), ex);
            }
        });
        return jsonObject;
    }

    public JSONObject struct2Json() {
        return struct2Json(stru);
    }

    /**
     * 把源结构体和目的结构体相同的属性的值付给目的结构体
     * 不考虑结构体内含结构体状况
     */
    public static StructUtils copyStruct(Structure dst, Structure src) {
        Field[] fields = dst.getClass().getDeclaredFields();
        Stream.of(fields).forEach(field -> {
            try {
                field.setAccessible(true);
                // 获取源field的变量
                Object objSrc = src.getClass().getDeclaredField(field.getName()).get(src);
                // 获取目的field的变量
                Object objDst = field.get(dst);
                if (objDst.getClass().isAssignableFrom(byte[].class)) {
                    StringUtils.arrayCopy((byte[]) objDst, (byte[]) objSrc);
                } else {
                    field.set(dst, objSrc);
                }
            } catch (Exception ex) {
                logger.error(ex.getMessage(), ex);
            }
        });
        return new StructUtils(dst);
    }
}
