package escuelaing.ieti.lab2p1.service.impl;

import escuelaing.ieti.lab2p1.entities.User;
import escuelaing.ieti.lab2p1.repository.UserRepository;
import escuelaing.ieti.lab2p1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        userRepository.save(user);
        return null;
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        for (User s:userRepository.findAll()) {
            users.add(s);
        }
        return users;
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user, int id) {
        return null;
    }
}