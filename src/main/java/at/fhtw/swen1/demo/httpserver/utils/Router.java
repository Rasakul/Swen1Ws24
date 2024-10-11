package at.fhtw.swen1.demo.httpserver.utils;

import at.fhtw.swen1.demo.controller.Controller;

import java.util.HashMap;
import java.util.Map;

public class Router {
    private Map<String, Controller> controllerRegistry = new HashMap<>();

    public void addController(String route, Controller controller) {
        this.controllerRegistry.put(route, controller);
    }

    public void removeController(String route) {
        this.controllerRegistry.remove(route);
    }

    public Controller resolve(String route) {
        //TODO: handle subroutes, e.g. /user/register
        return this.controllerRegistry.get(route);
    }
}
