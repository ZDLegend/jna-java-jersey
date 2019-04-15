package com.zdl.code.server;

/**
 * Created by ZDLegend on 2019/4/15 20:15
 */
public class ClassUtils {

    public static boolean instanceOf(Class clazz, Class target) {
        if (clazz == null) return false;
        if (clazz == target) return true;
        if (target.isInterface()) {
            for (Class aClass : clazz.getInterfaces()) {
                if (aClass == target) return true;
            }
        }
        if (clazz.getSuperclass() == target) return true;
        else {
            if (clazz.isInterface()) {
                for (Class aClass : clazz.getInterfaces()) {
                    if (instanceOf(aClass, target)) return true;
                }
            }
            return instanceOf(clazz.getSuperclass(), target);
        }
    }

    /**
     * 将对象转为指定的类型
     * <br/>
     * 支持日期，数字，boolean类型转换
     *
     * @param value 需要转换的值
     * @param type  目标类型
     * @return 转换后的值
     */
    public static <T> T cast(Object value, Class<T> type) {
        if (value == null) return null;
        Object newVal = null;
        if (ClassUtils.instanceOf(value.getClass(), type)) {
            newVal = value;
        } else if (type == Integer.class || type == int.class) {
            newVal = StringUtils.toInt(value);
        } else if (type == Double.class || type == double.class || type == Float.class || type == float.class) {
            newVal = StringUtils.toDouble(value);
        } else if (type == Long.class || type == long.class) {
            newVal = StringUtils.toLong(value);
        } else if (type == Boolean.class || type == boolean.class) {
            newVal = StringUtils.isTrue(value);
        } else if (type == String.class) {
            newVal = String.valueOf(value);
        }

        return (T) newVal;
    }
}
