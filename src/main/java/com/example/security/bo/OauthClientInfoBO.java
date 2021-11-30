package com.example.security.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hf
 * date   2021/11/30 18:04
 * description
 */
@Data
public class OauthClientInfoBO implements Serializable {

    private static final long serialVersionUID = -8342560791006402426L;
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
