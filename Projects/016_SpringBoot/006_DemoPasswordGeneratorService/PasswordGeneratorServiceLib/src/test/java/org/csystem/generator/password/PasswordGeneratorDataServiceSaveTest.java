package org.csystem.generator.password;

import org.csystem.generator.password.dal.PasswordGeneratorHelper;
import org.csystem.generator.password.data.service.PasswordGeneratorDataService;
import org.csystem.generator.password.data.service.dto.UserInfoSaveDTO;
import org.csystem.generator.password.data.service.mapper.UserInfoMapper;
import org.csystem.generator.password.repository.UserInfoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

/*That test class cannot know the file. We will change it later */

public class PasswordGeneratorDataServiceSaveTest {
    @BeforeEach
    public void setUp() throws IOException
    {
        var path = Files.createDirectories(Path.of("passwords"));
        Files.delete(path.resolve("merve"));
    }

    @Test
    public void test()
    {
        var service = new PasswordGeneratorDataService(new PasswordGeneratorHelper(new UserInfoRepository(new File("Passwords"), new Random())), new UserInfoMapper());
        var userInfoDTO = new UserInfoSaveDTO("merve", "1234", 20, 5);

        Assertions.assertTrue(service.saveUserInfo(userInfoDTO));
    }
}
