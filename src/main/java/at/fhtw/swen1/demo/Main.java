package at.fhtw.swen1.demo;

import at.fhtw.swen1.demo.controller.user.UserController;
import at.fhtw.swen1.demo.httpserver.server.Server;
import at.fhtw.swen1.demo.httpserver.utils.Router;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(10001, configureRouter());
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Router configureRouter() {
        Router router = new Router();
        //TODO: handle subroutes, e.g. /users/{username}
        router.addController("/session", new UserController());

        return router;
    }


}
