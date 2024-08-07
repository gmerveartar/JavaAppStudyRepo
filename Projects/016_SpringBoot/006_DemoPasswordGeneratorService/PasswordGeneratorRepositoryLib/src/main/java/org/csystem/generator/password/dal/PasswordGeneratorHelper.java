package org.csystem.generator.password.dal;

import lombok.extern.slf4j.Slf4j;
import org.csystem.generator.password.entity.UserInfo;
import org.csystem.generator.password.repository.IUserInfoRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
@Slf4j
public class PasswordGeneratorHelper {
    private final IUserInfoRepository m_userInfoRepository;
    //Other Repositories...

    public PasswordGeneratorHelper(IUserInfoRepository userInfoRepository)
    {
        m_userInfoRepository = userInfoRepository;
    }
    public Optional<UserInfo> saveUserIfNotExist(UserInfo userInfo)
    {
        //...
        log.info("PasswordGeneratorHelper.saveUserInfoIfNotExists: {}", userInfo.toString());
        return m_userInfoRepository.saveIfNotExist(userInfo);
    }

    public List<String> findAlLUserNames()
    {
        log.info("PasswordGeneratorHelper.findAllUserNames: ");

        return StreamSupport.stream(m_userInfoRepository.findAll().spliterator(), false)
                .map(UserInfo::getUsername).toList();
    }

    public List<UserInfo> findAlLUsers()
    {
        log.info("PasswordGeneratorHelper.findAllUsers: ");

        return StreamSupport.stream(m_userInfoRepository.findAll().spliterator(), false).toList();
    }
    //... Facade Pattern

}
