-- auto-generated definition
create table oauth_client_details
(
    client_id               varchar(48)   not null comment '客户端id'
        primary key,
    resource_ids            varchar(256)  null comment '资源id集合, 多个用逗号隔开',
    client_secret           varchar(256)  null comment '客户端访问密钥',
    scope                   varchar(256)  null comment '权限访问范围 read, write, all',
    authorized_grant_types  varchar(256)  null comment '客户端支持的grant_type,支持 authorization_code,password,refresh_token,implicit,client_credentials.  多个用逗号隔开',
    web_server_redirect_uri varchar(256)  null comment '客户端的重定向URI',
    authorities             varchar(256)  null comment '权限值， 多个用逗号隔开',
    access_token_validity   int           null comment '设定客户端的access_token的有效时间值(单位:秒),可选, 若不设定值则使用默认的有效时间值(60 * 60 * 12, 12小时)',
    refresh_token_validity  int           null comment '设定客户端的refresh_token的有效时间值(单位:秒),可选, 若不设定值则使用默认的有效时间值(60 * 60 * 24 * 30, 30天)',
    additional_information  varchar(4096) null,
    autoapprove             varchar(256)  null
);


-- auto-generated definition
create table oauth_user
(
    user_id       varchar(32)                         not null comment '用户id'
        primary key,
    user_password varchar(256)                        not null comment '用户密码， 明文',
    authorities   varchar(256)                        null comment '权限值， 多个用逗号隔开',
    create_time   timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    validity      int                                 null comment '账户有效期'
);



