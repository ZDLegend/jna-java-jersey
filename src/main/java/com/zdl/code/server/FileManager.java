package com.zdl.code.server;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.eclipse.persistence.tools.file.FileUtil;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by ZDLegend on 2016/8/18.
 * <p>
 * 关于文件操作相关的函数写在这里
 */
public class FileManager {

    private static Logger logger = Logger.getLogger(FileManager.class.getName());

    /**
     * 文件中有内容转化成字符串
     */
    public static String ReadFile(String name) {

        File file = new File(name);
        BufferedReader reader = null;
        String laststr = "";
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file), Charset.forName("UTF-8")));

            String tempString;

            while ((tempString = reader.readLine()) != null) {
                laststr = laststr + tempString.trim();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {

                }
            }
        }
        return laststr;
    }

    /**
     * 上传图片
     */
    public static void uploadImage(FormDataMultiPart form) {

        FormDataBodyPart part = form.getField("file");
        String strfilename = part.getContentDisposition().getFileName();
        String newFilename = form.getField("filename").getValue();
        InputStream inputStream = part.getValueAs(InputStream.class);

        File file = new File(ConfigFileMng.getImagePath());
        if (!file.exists()) {
            file.mkdirs();
        }

        try {
            OutputStream outputStream = new FileOutputStream(new File(
                    ConfigFileMng.getImagePath(),
                    newFilename + strfilename.substring(strfilename.indexOf("."), strfilename.length())));

            FileUtil.copy(inputStream, outputStream);

            inputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            logger.error("文件不存在", e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error("图片文件处理失败", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 把json格式存储的文件转化成json格式数据
     */
    public static JSONObject file2Json(String filename) {

        String str = ReadFile(filename);

        String f = str.substring(0, 2);
        if (f.equals("\uFEFF{")) {
            str = str.replace(f, "{");
        }

        return JSONObject.parseObject(str);
    }
}
