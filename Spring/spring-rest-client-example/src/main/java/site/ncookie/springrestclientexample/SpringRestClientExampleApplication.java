package site.ncookie.springrestclientexample;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRestClientExampleApplication {
    @Bean
    ApplicationRunner init() {
        return  args -> {
            System.out.println("Hello World");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRestClientExampleApplication.class, args);
    }

}
