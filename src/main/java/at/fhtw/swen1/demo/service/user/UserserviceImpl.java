package at.fhtw.swen1.demo.service.user;

import at.fhtw.swen1.demo.exception.MailExistsException;
import at.fhtw.swen1.demo.exception.NotFoundException;
import at.fhtw.swen1.demo.model.CreateUser;
import at.fhtw.swen1.demo.model.User;
import at.fhtw.swen1.demo.persistence.user.UserRepository;
import at.fhtw.swen1.demo.persistence.user.UserRepositoryImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserserviceImpl implements Userservice {
    private static UserserviceImpl instance = null;
    private final UserRepository userRepository;

    private final Map<String, User> sessionMap = new HashMap<>();


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
    public String login(User user) {

        if (userRepository.emailExists(user.getEmail())) {
            try {
                User saved = userRepository.findByEmail(user.getEmail());
                boolean validPass = saved.getPassword().equals(user.getPassword());
                if (validPass) {
                    String token = UUID.randomUUID().toString();
                    sessionMap.put(token, user);
                    return token;
                }
            } catch (NotFoundException e) {
                System.out.println(e.getMessage()); //TODO handle this better
            }
        }

        return "";
    }

    @Override
    public String register(CreateUser user) throws MailExistsException {

        User created = userRepository.create(user);

        String token = UUID.randomUUID().toString();
        sessionMap.put(token, created);

        return token;
    }

    @Override
    public boolean userIsLoggedIn(String token) {
        //Optional: NotAuthorizedException -> muss von Router/Handler
        // abgefangen und auf Response gemappt werden
        return sessionMap.containsKey(token);
    }
}
