package escuelaing.ieti.lab2p1.service.impl;

import escuelaing.ieti.lab2p1.entities.User;
import escuelaing.ieti.lab2p1.repository.UserRepository;
import escuelaing.ieti.lab2p1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserserviceMongoDB implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        userRepository.save(user);
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {}

    @Override
    public User update(User user, int id) {
        return null;
    }
}
