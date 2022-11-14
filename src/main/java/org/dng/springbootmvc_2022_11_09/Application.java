package org.dng.springbootmvc_2022_11_09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

//@SpringBootApplication(exclude = { ErrorMvcAutoConfiguration.class })
@SpringBootApplication()
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
