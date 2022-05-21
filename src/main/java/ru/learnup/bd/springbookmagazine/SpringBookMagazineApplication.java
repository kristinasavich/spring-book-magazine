package ru.learnup.bd.springbookmagazine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringBookMagazineApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBookMagazineApplication.class, args);

    }
}
