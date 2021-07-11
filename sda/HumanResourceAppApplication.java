package pl.sda;

import pl.sda.humanresource.config.WorkTypeConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {WorkTypeConfig.class})
public class HumanResourceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumanResourceAppApplication.class, args);
    }
}

