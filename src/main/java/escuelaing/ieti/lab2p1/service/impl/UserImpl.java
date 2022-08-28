package escuelaing.ieti.lab2p1.service.impl;

import escuelaing.ieti.lab2p1.entities.User;
import escuelaing.ieti.lab2p1.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserImpl implements UserService {

    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    @Override
    public User create(User user) {
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
    public void deleteById(int id) {

    }

    @Override
    public User update(User user, int id) {
        return null;
    }
}
