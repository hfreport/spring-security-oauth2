package com.example.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.security.bo.OauthClientInfoBO;
import com.example.security.dao.mapper.OauthClientInfoMapper;
import com.example.security.dao.model.OauthClientInfo;
import com.example.security.mapstruct.ClientInfoConvertMapper;
import com.example.security.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hf
 * date   2021/11/30 18:06
 * description
 */
@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private OauthClientInfoMapper oauthClientInfoMapper;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public OauthClientInfoBO queryClientInfoByClientId(String clientId) {
        if (StringUtils.isEmpty(clientId)) {
            throw new RuntimeException("客户端id 为空");
        }
        LambdaQueryWrapper<OauthClientInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OauthClientInfo::getClientId, clientId);
        OauthClientInfo oauthClientInfo = oauthClientInfoMapper.selectOne(queryWrapper);
        return ClientInfoConvertMapper.INSTANCE.converOauthClientInfoBO(oauthClientInfo);
    }

    @Override
    public List<OauthClientInfoBO> queryClientInfoList() {
        LambdaQueryWrapper<OauthClientInfo> queryWrapper = new LambdaQueryWrapper<>();
        List<OauthClientInfo> oauthClientInfos = oauthClientInfoMapper.selectList(queryWrapper);
        return ClientInfoConvertMapper.INSTANCE.converOauthClientInfoBOList(oauthClientInfos);
    }

    @Override
    public boolean addClient(OauthClientInfoBO param) {
        OauthClientInfo entity = ClientInfoConvertMapper.INSTANCE.converOauthClientInfo(param);
        int insert = oauthClientInfoMapper.insert(entity);
        return insert == 1;
    }

    @Override
    public boolean updateClientInfo(OauthClientInfoBO param) {
        if (StringUtils.isEmpty(param.getClientId())) {
            throw new RuntimeException("客户端id 为空");
        }

        LambdaQueryWrapper<OauthClientInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OauthClientInfo::getClientId, param.getClientId());
        OauthClientInfo entity = oauthClientInfoMapper.selectOne(queryWrapper);

        LambdaUpdateWrapper<OauthClientInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(OauthClientInfo::getClientId, param.getClientId());

        String sec = null;
        if (StringUtils.isNotBlank(param.getClientId())) {
            sec = passwordEncoder.encode(param.getClientSecret());
        }
        updateWrapper.set(!entity.getClientSecret().equals(sec), OauthClientInfo::getClientSecret, passwordEncoder.encode(param.getClientSecret()));
        updateWrapper.set(!entity.getScope().equals(param.getScope()), OauthClientInfo::getScope, param.getScope());
        updateWrapper.set(!entity.getAuthorizedGrantTypes().equals(param.getAuthorizedGrantTypes()), OauthClientInfo::getAuthorizedGrantTypes,
                param.getAuthorizedGrantTypes());
        updateWrapper.set(!entity.getWebServerRedirectUri().equals(param.getWebServerRedirectUri()), OauthClientInfo::getWebServerRedirectUri
                , param.getWebServerRedirectUri());
        updateWrapper.set(!entity.getAuthorities().equals(param.getAuthorities()), OauthClientInfo::getAuthorities
                , param.getAuthorities());
        updateWrapper.set(!entity.getAccessTokenValidity().equals(param.getAccessTokenValidity()), OauthClientInfo::getAccessTokenValidity
                , param.getAccessTokenValidity());
        updateWrapper.set(!entity.getRefreshTokenValidity().equals(param.getRefreshTokenValidity()), OauthClientInfo::getRefreshTokenValidity
                , param.getRefreshTokenValidity());
        updateWrapper.set(!entity.getAdditionalInformation().equals(param.getAdditionalInformation()), OauthClientInfo::getAdditionalInformation
                , param.getAdditionalInformation());
        updateWrapper.set(!entity.getAutoapprove().equals(param.getAutoapprove()), OauthClientInfo::getAutoapprove
                , param.getAutoapprove());
        int insert = oauthClientInfoMapper.update(entity, updateWrapper);
        return insert == 1;
    }

}
