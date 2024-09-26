package at.fhtw.swen1.demo;

import at.fhtw.swen1.demo.model.User;
import at.fhtw.swen1.demo.service.Userservice;
import at.fhtw.swen1.demo.service.UserserviceImpl;

public class Main {
    public static void main(String[] args) {
        client1();
        client2();
    }

    public static void client1() {
        User user = new User("email", "password");
        Userservice service = UserserviceImpl.getInstance();
        boolean successful = service.login(user);
    }

    public static void client2() {
        User user = new User("email", "password");
        Userservice service = UserserviceImpl.getInstance();
        boolean successful = service.login(user);
    }
}
