package com.example.security.mapstruct;

import com.example.security.bo.OauthClientInfoBO;
import com.example.security.dao.model.OauthClientInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author hf
 * date   2021/11/30 18:09
 * description
 */
@Mapper
public interface ClientInfoConvertMapper {

    ClientInfoConvertMapper INSTANCE = Mappers.getMapper(ClientInfoConvertMapper.class);

    OauthClientInfoBO converOauthClientInfoBO(OauthClientInfo oauthClientInfo);

    List<OauthClientInfoBO> converOauthClientInfoBOList(List<OauthClientInfo> oauthClientInfos);

    OauthClientInfo converOauthClientInfo(OauthClientInfoBO param);
}
