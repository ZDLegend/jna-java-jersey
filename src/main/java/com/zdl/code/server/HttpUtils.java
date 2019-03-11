package com.zdl.code.server;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ZDLegend on 2016/12/21.
 */
public class HttpUtils {

    private static final int CONNECTION_TIME_OUT = 30000;

    public static int sendAlarm(String url, String data) {

        HttpConnectionManager connectionManager = new SimpleHttpConnectionManager(false);
        HttpConnectionManagerParams connectionParams = new HttpConnectionManagerParams();
        connectionParams.setConnectionTimeout(CONNECTION_TIME_OUT);

        connectionManager.setParams(connectionParams);
        HttpClient client = new HttpClient(connectionManager);
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());

        PostMethod httpMethod = new PostMethod(url);

        int status = 200;
        try {
            InputStreamRequestEntity inputStreamEntity = new InputStreamRequestEntity(inputStream);

            httpMethod.setRequestEntity(inputStreamEntity);
            httpMethod.setRequestHeader("Connection", "Keep-Alive");
            httpMethod.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

            client.executeMethod(httpMethod);
            status = httpMethod.getStatusLine().getStatusCode();
            httpMethod.releaseConnection();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int action(String s1, String s2) throws IOException {

        int ret = sendAlarm(s1, s2);
        if (ret == 200) {
            return 0;
        }

        throw new IOException("url:" + s1 + " connected error, status:" + ret);
    }
}
