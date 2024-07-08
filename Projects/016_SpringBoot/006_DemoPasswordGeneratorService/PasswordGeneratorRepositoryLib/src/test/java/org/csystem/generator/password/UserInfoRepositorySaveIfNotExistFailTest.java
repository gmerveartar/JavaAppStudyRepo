package org.csystem.generator.password;

import org.csystem.generator.password.entity.UserInfo;
import org.csystem.generator.password.repository.IUserInfoRepository;
import org.csystem.generator.password.repository.UserInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserInfoRepositorySaveIfNotExistFailTest {
    private IUserInfoRepository m_userInfoRepository;

    @BeforeEach
    public void setUp() throws IOException
    {
        var path = Files.createDirectories(Path.of("passwords"));

        Files.delete(path.resolve("merve"));
        Files.createFile(path.resolve("merve"));

        m_userInfoRepository = new UserInfoRepository(new File("passwords"), new Random());
    }

    @Test
    public void test()
    {
        var userInfo = new UserInfo("merve", "1234", 10, 5, LocalDateTime.now());
        var result = m_userInfoRepository.saveIfNotExist(userInfo);

        assertTrue(result.isEmpty());
    }
}
