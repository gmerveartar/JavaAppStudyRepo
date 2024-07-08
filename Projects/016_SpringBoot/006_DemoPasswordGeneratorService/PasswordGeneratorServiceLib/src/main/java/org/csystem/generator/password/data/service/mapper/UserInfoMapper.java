package org.csystem.generator.password.data.service.mapper;

import org.csystem.generator.password.data.service.dto.UserInfoSaveDTO;
import org.csystem.generator.password.entity.UserInfo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserInfoMapper implements IUserInfoMapper{
    @Override
    public UserInfo toUserInfo(UserInfoSaveDTO userInfoSaveDTO)
    {
        return new UserInfo(userInfoSaveDTO.getUsername(),
                userInfoSaveDTO.getPassword(),
                userInfoSaveDTO.getTextCount(),
                userInfoSaveDTO.getTextLength(),
                LocalDateTime.now());
    }
}
