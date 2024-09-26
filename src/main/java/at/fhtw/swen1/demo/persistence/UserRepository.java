package at.fhtw.swen1.demo.persistence;

import at.fhtw.swen1.demo.exception.NotFoundException;
import at.fhtw.swen1.demo.model.User;

public interface UserRepository {

    /**
     * Checks if users exists by mail
     *
     * @param email
     * @return true, if exists
     */
    boolean emailExists(String email);

    /**
     * finds a user by its mail
     *
     * @param email
     * @return User, if found.
     * @throws NotFoundException if not found
     */
    User findByEmail(String email) throws NotFoundException;

}
