package com.zdl.code.server;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.jna.Structure;
import com.zdl.code.exception.StructException;
import org.apache.log4j.Logger;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by ZDLegend on 2016/8/16.
 * <p>
 * 关于json的特殊操作函数写在这里
 * 提供json与结构体间相互转换方法
 */
public class StructUtils {

    private static Logger logger = Logger.getLogger(StructUtils.class.getName());

    private Structure stru;

    public StructUtils(Structure stru) {
        this.stru = stru;
    }

    /**
     * Json转结构体
     */
    public static Structure Json2Struct(JSONObject jsonObject, Structure structure) throws StructException {

        //获取结构体字段
        Field[] fields = structure.getClass().getDeclaredFields();
        String strName = structure.getClass().getName();

        int e = 0;
        //遍历赋值
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {

            int find = 0;

            for (Field field : fields) {

                // 对于每个属性，获取属性名
                String varName = field.getName();
                //过滤掉结构体属性名中的前缀
                varName = StringUtils.removLowerHaed(varName);

                field.setAccessible(true);

                if (varName.equals(entry.getKey())) {
                    try {
                        Object object = field.get(structure);
                        String typeName = object.getClass().getTypeName();
                        if ("byte[]".equals(typeName) || object instanceof byte[]) {
                            StringUtils.setSdkBytes((byte[]) object, entry.getValue().toString());
                        } else if (object.getClass().getName().contains("Structure")) {
                            if (object.getClass().isArray()) {
                                JSONArray array = (JSONArray) entry.getValue();
                                int length = array.size();
                                for (int i = 0; i < length; i++) {
                                    Json2Struct((JSONObject) array.get(i), (Structure) Array.get(object, i));
                                }
                            } else {
                                Json2Struct((JSONObject) entry.getValue(), (Structure) object);
                            }
                        } else {
                            if (entry.getValue() instanceof String) {
                                String msg = "Type of " + varName + " should be " + typeName + " in json";
                                throw new StructException(msg);
                            }
                            field.set(structure, entry.getValue());
                        }
                    } catch (IllegalAccessException ex) {
                        throw new StructException(ex.getMessage());
                    }

                    find = 1;
                    e++;
                }

            }

            if (1 != find) {
                logger.debug(strName + "该结构体类型中没有Json中的" + entry.getKey() + "变量");
            }

        }

        if (0 == e) {
            logger.error(strName + "结构体类型与Json不匹配");
        }

        return structure;

    }

    /**
     * 结构体转Json
     */
    public static JSONObject Struct2Json(Structure structure) {

        JSONObject jsonObject = new JSONObject();

        // 获取对象obj的所有属性域
        Field[] fields = structure.getClass().getDeclaredFields();

        for (Field field : fields) {
            // 对于每个属性，获取属性名
            String varName = field.getName();
            //过滤掉属性名中的前缀
            varName = StringUtils.removLowerHaed(varName);

            try {
                //打开修改权限
                field.setAccessible(true);

                //从obj中获取field变量
                Object obj = field.get(structure);
                if ("byte[]".equals(obj.getClass().getTypeName())) {
                    String str = StringUtils.bytesToString((byte[]) obj);

                    jsonObject.put(varName, str);
                } else if (obj.getClass().getName().contains("Structure")) {
                    if (obj.getClass().isArray()) {
                        JSONArray array = new JSONArray();
                        int length = Array.getLength(obj);
                        for (int i = 0; i < length; i++) {
                            array.add(i, Struct2Json((Structure) Array.get(obj, i)));
                        }
                        jsonObject.put(varName, array);
                    } else {
                        jsonObject.put(varName, Struct2Json((Structure) obj));
                    }
                } else {
                    jsonObject.put(varName, obj);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return jsonObject;
    }

    public JSONObject Struct2Json() {


        JSONObject jsonObject = new JSONObject();

        // 获取对象obj的所有属性域
        Field[] fields = stru.getClass().getDeclaredFields();

        for (Field field : fields) {
            // 对于每个属性，获取属性名
            String varName = field.getName();
            //过滤掉属性名中的前缀
            varName = StringUtils.removLowerHaed(varName);

            try {
                //打开修改权限
                boolean access = field.isAccessible();
                if (!access) field.setAccessible(true);

                //从obj中获取field变量
                Object obj = field.get(stru);
                if ("byte[]".equals(obj.getClass().getTypeName())) {
                    String str = StringUtils.bytesToString((byte[]) obj);
                    jsonObject.put(varName, str);
                } else {
                    jsonObject.put(varName, obj);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return jsonObject;
    }


    /**
     * 把源结构体和目的结构体相同的属性的值付给目的结构体
     * 不考虑结构体内含结构体状况
     */
    public static StructUtils filterStruct(Structure dst, Structure src) {

        /* 获取对象obj的所有属性域 */
        Field[] fields = dst.getClass().getDeclaredFields();

        for (Field field : fields) {

            /* 对于每个属性，获取属性名 */
            String varName = field.getName();

            try {
                /* 打开修改权限 */
                boolean access = field.isAccessible();
                if (!access) field.setAccessible(true);

                /* 获取源field的变量 */
                Object objSrc = src.getClass().getDeclaredField(varName).get(src);

                /* 获取目的field的变量 */
                Object objDst = field.get(dst);

                if (objDst.getClass().isAssignableFrom(byte[].class)) {
                    StringUtils.ArrayCopy((byte[]) objDst, (byte[]) objSrc);
                } else {
                    field.set(dst, objSrc);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return new StructUtils(dst);
    }
}
