package com.zavarykin;


import com.zavarykin.service.GameService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@ComponentScan
public class App
{
    public static void main( String[] args ) throws IOException {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);

        GameService gameService = applicationContext.getBean(GameService.class);

        gameService.startGame();
    }
}
