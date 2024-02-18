package com.hiasia.peopleflowstatistics.pojo;

import lombok.Data;

@Data
public class BaiduApiToken {
    private String access_token;
    private Long expires_in;
    private String refresh_token;
    private String scope;
    private String session_key;
    private String session_secret;
}
