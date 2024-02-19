package com.hiasia.peopleflowstatistics.service;


import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiasia.peopleflowstatistics.dao.PersonFlowRepository;
import com.hiasia.peopleflowstatistics.pojo.PersonFlow;
import com.hiasia.peopleflowstatistics.utils.BaiduTokenUtil;
import com.hiasia.peopleflowstatistics.utils.Base64Util;
import jakarta.annotation.Resource;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.hiasia.peopleflowstatistics.utils.BaiduTokenUtil.HTTP_CLIENT;

@Service
public class MainService {
    @Value("${baidu.api.token}")
    private String accessToken;
    @Value("${baidu.api.client_id}")
    private String clientId;
    @Value("${baidu.api.client_secret}")
    private String clientSecret;
    private @Resource PersonFlowRepository personFlowRepository;

    public PersonFlow httpGet(String imageUrl, String show, Integer deviation) {
        try {
            String httpAccessToken = BaiduTokenUtil.getAccessToken(clientId, clientSecret);
            String apiUrl = "https://aip.baidubce.com/rest/2.0/image-classify/v1/body_num?access_token=" + httpAccessToken;
            // 设置请求头
            String imageBase64 = Base64Util.image2Base64(imageUrl);
            String requestBody = "image=" + URLEncoder.encode(imageBase64, StandardCharsets.UTF_8) + "&show="+show;
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, requestBody);
            Request request = new Request.Builder()
                    .url(apiUrl)
                    .method("POST", body)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("Accept", "application/json")
                    .build();

            Response response = HTTP_CLIENT.newCall(request).execute();
            String responseString = response.body().string();
            // json转换为对象
            ObjectMapper objectMapper = new ObjectMapper();
            PersonFlow personFlow = objectMapper.readValue(responseString, PersonFlow.class);
            // 减去偏差值
            personFlow.setPerson_num(personFlow.getPerson_num() - deviation);
            personFlowRepository.save(personFlow);
            return personFlow;
        } catch (Exception e) {
            e.printStackTrace();
        }
        PersonFlow personFlow = new PersonFlow();
        personFlow.setPerson_num(-1);
        personFlow.setLog_id("fail");
        personFlowRepository.save(personFlow);
        return personFlow;
    }

    public Integer lastDayPersonNumber() {
        List<PersonFlow> personFlows = personFlowRepository.findDataBetweenDates();
        return personFlows.stream().mapToInt(PersonFlow::getPerson_num).sum();
    }
}
