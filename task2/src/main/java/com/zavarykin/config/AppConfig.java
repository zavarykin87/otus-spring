package com.zavarykin.config;

import com.zavarykin.dao.QuestionDao;
import com.zavarykin.dao.QuestionDaoImpl;
import com.zavarykin.service.GameService;
import com.zavarykin.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public QuestionDao questionDao() {
        return new QuestionDaoImpl();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public GameService gameService(UserService userService, QuestionDao questionDao,
                                   @Value("${fileName}") String fileName) {

        return new GameService(userService, questionDao, fileName);
    }
}
