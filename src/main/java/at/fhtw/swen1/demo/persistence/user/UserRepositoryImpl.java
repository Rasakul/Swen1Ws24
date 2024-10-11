package at.fhtw.swen1.demo.persistence.user;

import at.fhtw.swen1.demo.exception.MailExistsException;
import at.fhtw.swen1.demo.exception.NotFoundException;
import at.fhtw.swen1.demo.model.CreateUser;
import at.fhtw.swen1.demo.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepositoryImpl instance;
    private final Map<String, User> users = new HashMap<>();

    private UserRepositoryImpl() {
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }


    @Override
    public boolean emailExists(String email) {
        return true; //TODO check database
    }

    @Override
    public User findByEmail(String email) throws NotFoundException {

        if (!checkDatabase(email)) {
            throw new NotFoundException("User doesn't exists");
        }
        //TODO load from database
        return users.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("User doesn't exists"));
    }

    private boolean checkDatabase(String email) {
        //TODO check database
        return true;
    }

    @Override
    public User create(CreateUser user) throws MailExistsException {
        String id = UUID.randomUUID().toString();

        if (!emailExists(user.getEmail())) {
            User newUser = new User(id, user.getEmail(), user.getPassword());
            users.put(newUser.getId(), newUser);
            return newUser;
        } else {
            throw new MailExistsException("User mail already exists");
        }
    }
}
