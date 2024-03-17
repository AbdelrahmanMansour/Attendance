package ea544.group6.ea544.group6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.miu.common, ea544.group6.ea544.group6")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
