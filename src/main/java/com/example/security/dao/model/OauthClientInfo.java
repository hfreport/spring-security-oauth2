package com.example.security.dao.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author hf
 * date   2021/11/29 17:10
 * description
 */
@Data
@TableName("oauth_client_details")
public class OauthClientInfo implements Serializable {
    private static final long serialVersionUID = -3211630943761927822L;

    private String clientId;
    private String resourceIds;
    private String clientSecret;
    private String scope;
    private String authorizedGrantTypes;
    private String webServerRedirectUri;
    private String authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String additionalInformation;
    private String autoapprove;

}
