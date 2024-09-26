package at.fhtw.swen1.demo.service;

import at.fhtw.swen1.demo.model.User;

public interface Userservice {

    /**
     * Logs in a user, checks first if exists
     *
     * @param user must be valid
     * @return true, if success
     */
    boolean login(User user);

}
