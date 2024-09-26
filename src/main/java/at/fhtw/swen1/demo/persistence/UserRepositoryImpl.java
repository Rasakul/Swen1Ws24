package at.fhtw.swen1.demo.persistence;

import at.fhtw.swen1.demo.exception.NotFoundException;
import at.fhtw.swen1.demo.model.User;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepositoryImpl instance;

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

        return new User(email, "password"); //TODO load from database
    }

    private boolean checkDatabase(String email) {
        //TODO check database
        return true;
    }
}
