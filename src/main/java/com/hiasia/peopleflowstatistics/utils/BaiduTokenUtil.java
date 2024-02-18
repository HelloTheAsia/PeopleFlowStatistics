package com.hiasia.peopleflowstatistics.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiasia.peopleflowstatistics.pojo.BaiduApiToken;
import okhttp3.*;

public class BaiduTokenUtil {
    public static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    public static String getAccessToken(String id, String secret) throws Exception {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token?client_id=" + id + "&client_secret=" + secret + "&grant_type=client_credentials")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        String string = response.body().string();
        ObjectMapper objectMapper = new ObjectMapper();
        BaiduApiToken baiduApiToken = objectMapper.readValue(string, BaiduApiToken.class);
        return baiduApiToken.getAccess_token();
    }
}
