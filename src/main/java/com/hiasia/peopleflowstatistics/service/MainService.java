package com.hiasia.peopleflowstatistics.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiasia.peopleflowstatistics.pojo.PersonFlow;
import com.hiasia.peopleflowstatistics.utils.Base64Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    @Value("${baidu.api.token}")
    private String accessToken;

    public PersonFlow httpGet(String imageUrl) throws Exception {

        // API请求URL
        String apiUrl = "https://aip.baidubce.com/rest/2.0/image-classify/v1/body_num?access_token=" + accessToken;

        // 读取图片文件

        // 设置请求头
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);
        connection.connect();
        // 设置请求体
        String imageBase64 = Base64Util.image2Base64(imageUrl);
        String requestBody = "image=" + URLEncoder.encode(imageBase64, StandardCharsets.UTF_8);
        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            wr.writeBytes(requestBody);
            wr.flush();
        }

        // 获取响应
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // 读取响应内容
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // 处理响应内容
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(response.toString(), PersonFlow.class);
            }
        } else {
            System.out.println("Error in API request");
        }
        return null;
    }
}
