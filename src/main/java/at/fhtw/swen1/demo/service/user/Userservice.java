package at.fhtw.swen1.demo.service.user;

import at.fhtw.swen1.demo.exception.MailExistsException;
import at.fhtw.swen1.demo.model.CreateUser;
import at.fhtw.swen1.demo.model.User;

public interface Userservice {

    /**
     * Logs in a user, checks first if exists
     *
     * @param user must be valid
     * @return true, if success
     */
    String login(User user);

    String register(CreateUser user) throws MailExistsException;

    boolean userIsLoggedIn(String token);
}
