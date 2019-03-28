package com.zdl.code.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Created by ZDLegend on 2016/12/21.
 */
public class HttpUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private HttpUtils() {
    }

    private static final int CONNECTION_TIME_OUT = 30000;

    public static void sendAlarm(String url, String data) {

        var client = HttpClient.newHttpClient();

        var r = HttpRequest.newBuilder(URI.create(url))
                .timeout(Duration.ofMillis(CONNECTION_TIME_OUT))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .build();

        client.sendAsync(r, HttpResponse.BodyHandlers.ofString())
                .whenComplete((request, throwable) -> {
                    if (throwable != null) {
                        logger.error(throwable.getMessage(), throwable);
                        return;
                    }

                    var code = request.statusCode();
                    if (code == HttpStatus.OK.value()) {
                        logger.info("http send success");
                    } else {
                        logger.error("http send fail, code:{}, body;{}", request.statusCode(), request.body());
                    }
                });
    }
}
