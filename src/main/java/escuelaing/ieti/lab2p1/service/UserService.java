package escuelaing.ieti.lab2p1.service;

import escuelaing.ieti.lab2p1.entities.User;

import java.util.List;

public interface UserService {

    User create(User user);
    User findById(String id);
    List<User> getAll();
    void deleteById(String id);
    User update(User user, String id) throws Exception;
    User findByEmail(String email);

}
