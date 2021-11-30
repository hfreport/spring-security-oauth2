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
@TableName("oauth_user")
public class OauthUser implements Serializable {
    private static final long serialVersionUID = -1392710756482213136L;

    private String userId;
    private String userPassword;
    private String authorities;
    private Integer validity;
    private Instant createTime;
}
