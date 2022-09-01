package escuelaing.ieti.lab2p1;

import escuelaing.ieti.lab2p1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Lab2p1Application {

	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(Lab2p1Application.class, args);
	}

}
