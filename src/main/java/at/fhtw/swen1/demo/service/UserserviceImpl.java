package at.fhtw.swen1.demo.service;

import at.fhtw.swen1.demo.exception.NotFoundException;
import at.fhtw.swen1.demo.model.User;
import at.fhtw.swen1.demo.persistence.UserRepository;
import at.fhtw.swen1.demo.persistence.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class UserserviceImpl implements Userservice {
    private static UserserviceImpl instance = null;
    private final UserRepository userRepository;
    private final List<User> loggedIn = new ArrayList<>();

    private UserserviceImpl() {
        userRepository = UserRepositoryImpl.getInstance();
    }

    public static UserserviceImpl getInstance() {
        if (instance == null) {
            instance = new UserserviceImpl();
        }
        return instance;
    }

    @Override
    public boolean login(User user) {

        if (userRepository.emailExists(user.getEmail())) {
            try {
                User saved = userRepository.findByEmail(user.getEmail());
                boolean validPass = saved.getPassword().equals(user.getPassword());
                if (validPass) {
                    loggedIn.add(user);
                    return true;
                }
            } catch (NotFoundException e) {
                System.out.println(e.getMessage()); //TODO handle this better
            }
        }

        return false;
    }
}
