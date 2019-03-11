package com.zdl.code.server;

import net.sf.json.JSONArray;

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

/**
 * Created by ZDLegend on 2016/8/16.
 * <p>
 * 字符转相关操作的函数在这里
 */
public class StringUtils {

    /**
     * @apiNote sdk结构体中的字符串转换为byte[]
     */
    public static byte[] ArrayCopy(byte[] dst, byte[] src) {
        int minlen = dst.length < src.length ? dst.length : src.length;
        System.arraycopy(src, 0, dst, 0, minlen);
        return dst;
    }

    /**
     * @apiNote 给结构体中的字符串赋值
     */
    public static void setSdkBytes(byte[] dst, String content) {
        byte[] srcBytes = new byte[0];
        try {
            srcBytes = content.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int size = Math.min(srcBytes.length, dst.length);
        System.arraycopy(srcBytes, 0, dst, 0, size == dst.length ? dst.length - 1 : size);
    }

    /**
     * @apiNote JSONArray转byte[]
     * <p>
     * JSONArray转换为C代码中Char[x][y]
     * 既JSONArray -> byte[x*y] -> Char[x][y]
     */
    public static void byte2Copy(byte[] dst, JSONArray array, int x, int y) {

        if (array.size() < x) {
            x = array.size();
        }

        int length = x * y;
        int f = 0;
        StringBuilder sb = new StringBuilder();
        sb.setLength(length);
        for (int i = 0; i < x; i++) {
            sb.insert(f, array.getString(i));
            f = f + y;
        }
        StringUtils.setSdkBytes(dst, sb.toString());
    }

    /**
     * @apiNote 生成随机字符串
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * @apiNote 生成MD5摘要值
     */
    public static String MD5Util(String ps) {

        if (null != ps) {

            String md5str = "";
            try {

                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(ps.getBytes());
                byte[] results = md.digest();

                md5str = bytesToHex(results);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return md5str;
        }
        return null;
    }

    /**
     * @apiNote二进制转十六进制
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();

        /** 把数组每一字节换成16进制连成md5字符串 */
        int digital;
        for (byte aByte : bytes) {
            digital = aByte;

            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toLowerCase();
    }

    /**
     * @apiNote byte[]转String
     */
    public static String bytesToString(byte[] obj) {

        /** trim()去掉末尾的 \u0020 也就是空格 */
        String str = new String(obj, Charset.forName("UTF-8")).trim();

        /** 去掉末尾的0 */
        if (str.indexOf('\u0000') > 0) {
            str = str.substring(0, str.indexOf('\u0000'));
        }

        return str;
    }


    /**
     * @apiNote 去除结构体成员名中的前缀
     */
    public static String removLowerHaed(String word) {

        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                index = i;
                break;
            }
        }

        word = word.replace(word.substring(0, index), "");
        return word;
    }

    /**
     * @apiNote 把URL中的空格（%20）转化成普通的字符串空格
     */
    public static String spaceString(String url) {
        if (url.contains("%20")) {
            url = url.replace("%20", " ");
        }
        return url;
    }

    /**
     * @apiNote 将字符串进行BASE64编码
     */
    public static String getBASE64(String s) {
        if (s == null) return null;
        return Arrays.toString(Base64.getEncoder().encode(s.getBytes()));
    }

    /**
     * @apiNote 将字符串进行BASE64解码
     */
    public static String getFromBASE64(String s) {
        if (s == null) return null;
        try {
            byte[] b = Base64.getDecoder().decode(s);
            return new String(b, Charset.forName("UTF-8")).trim();
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }

        return swapStream.toByteArray();
    }

    public static void byte2image(byte[] data, String path) {

        if (data.length < 3 || path.equals("")) return;
        try {
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
            System.out.println("Make Picture success,Please find image in " + path);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
    }

    /**
     * 根据byte数组，生成文件
     */
    public static void getFile(byte[] bfile, String path) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file;
        try {
//            File dir = new File(filePath);
//            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
//                dir.mkdirs();
//            }
            file = new File(path);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * int 转 byte[] 数组
     */
    public static byte[] intToByteArray(int i) throws IOException {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(buf);
        dos.writeInt(i);
        byte[] b = buf.toByteArray();
        dos.close();
        buf.close();
        return b;
    }

}
