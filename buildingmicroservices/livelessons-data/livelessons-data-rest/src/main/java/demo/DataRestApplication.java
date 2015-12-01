package demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataRestApplication {

	@Bean
	InitializingBean seedDatabase(CarRepository repository) {
		return () -> {
			repository.save(new Car("Honda", "Aviator", 1997));
			repository.save(new Car("Honda", "According", 2003));
			repository.save(new Car("Ford", "Escorts", 1985));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DataRestApplication.class, args);
	}

}
