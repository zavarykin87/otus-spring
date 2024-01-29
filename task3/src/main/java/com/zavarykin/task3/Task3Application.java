package com.zavarykin.task3;

import com.zavarykin.task3.service.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Task3Application {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = SpringApplication.run(Task3Application.class, args);

		GameService gameService = context.getBean(GameService.class);

		gameService.startGame();

	}

}
