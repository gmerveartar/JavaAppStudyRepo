package org.csystem.generator.password;

import org.csystem.generator.password.entity.UserInfo;
import org.csystem.generator.password.repository.IUserInfoRepository;
import org.csystem.generator.password.repository.UserInfoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Random;

public class UserInfoRepositorySaveTest {
    private IUserInfoRepository m_userInfoRepository;
    private File m_file;


    @BeforeEach
    public void setUp() throws IOException
    {
        var path = Files.createDirectories(Path.of("passwords"));
        m_file = new File(path.toFile(), "merve");
        m_file.delete();
        m_userInfoRepository = new UserInfoRepository(new File("passwords"), new Random());
    }

    @Test
    public void test()
    {
        var userInfo = new UserInfo("merve", "1234", 10, 5, LocalDateTime.now());
        m_userInfoRepository.save(userInfo);

        Assertions.assertTrue(m_file.exists());
        Assertions.assertTrue(m_file.length() > 0);
    }
}
