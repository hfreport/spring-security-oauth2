package com.example.security.service;

import com.example.security.bo.OauthClientInfoBO;

import java.util.List;

/**
 * @author hf
 * date   2021/11/30 18:03
 * description
 */
public interface ManagerService {

    /**
     * 根据客户端id 查询数据
     * @param clientId
     * @return
     */
    OauthClientInfoBO queryClientInfoByClientId(String clientId);

    /**
     * 查询所有客户端信息
     * @return
     */
    List<OauthClientInfoBO> queryClientInfoList();

    /**
     * 添加客户端西信息
     * @param param
     * @return
     */
    boolean addClient(OauthClientInfoBO param);

    /**
     * 更新客户端信息
     * @param param
     * @return
     */
    boolean updateClientInfo(OauthClientInfoBO param);

}
