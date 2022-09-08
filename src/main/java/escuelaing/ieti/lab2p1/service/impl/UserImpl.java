package escuelaing.ieti.lab2p1.service.impl;

import escuelaing.ieti.lab2p1.entities.User;
import escuelaing.ieti.lab2p1.repository.UserRepository;
import escuelaing.ieti.lab2p1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        userRepository.save(user);
        return findById(user.getId());
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        users.addAll(userRepository.findAll());
        return users;
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user, String id) throws Exception {
        if(findById(id) == null) {
            throw new Exception("El usuario no existe");
        }
        deleteById(id);
        user.setId(id);
        return create(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}