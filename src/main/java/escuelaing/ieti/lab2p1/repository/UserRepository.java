package escuelaing.ieti.lab2p1.repository;

import escuelaing.ieti.lab2p1.entities.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

@Document
public interface UserRepository extends MongoRepository<User, String> {

}
