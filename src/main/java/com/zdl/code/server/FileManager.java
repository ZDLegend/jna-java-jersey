package com.zdl.code.server;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by ZDLegend on 2016/8/18.
 * <p>
 * 关于文件操作相关的函数写在这里
 */
public final class FileManager {

    private static Logger logger = LoggerFactory.getLogger(FileManager.class);

    private FileManager() {
    }

    /**
     * 文件中所有内容转化成字符串
     */
    public static String readFile(String name) {
        File file = new File(name);
        StringBuilder lastStr = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), Charset.forName("UTF-8")))) {
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                lastStr.append(tempString.trim());
            }
        } catch (Exception e) {
            logger.error("readFile error", e);
        }

        return lastStr.toString();
    }


    /**
     * 把json格式存储的文件转化成json格式数据
     */
    public static JSONObject file2Json(String filename) {
        String str = readFile(filename);
        String f = str.substring(0, 2);
        if (f.equals("\uFEFF{")) {
            str = str.replace(f, "{");
        }
        return JSONObject.parseObject(str);
    }
}
