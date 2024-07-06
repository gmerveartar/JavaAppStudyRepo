package org.csystem.generator.password.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.File;

@Configuration
public class FileConfig {
    @Bean
    @Scope("prototype")
    public File files()
    {
        return new File("passwords");
    }

}
