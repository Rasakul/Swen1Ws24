package at.fhtw.swen1.demo.controller.user;

import at.fhtw.swen1.demo.controller.Controller;
import at.fhtw.swen1.demo.httpserver.http.Method;
import at.fhtw.swen1.demo.httpserver.server.Request;
import at.fhtw.swen1.demo.httpserver.server.Response;
import at.fhtw.swen1.demo.service.user.Userservice;
import at.fhtw.swen1.demo.service.user.UserserviceImpl;

public class UserController implements Controller {

    private Userservice userservice = UserserviceImpl.getInstance();

    @Override
    public Response handleRequest(Request request) {
        //TODO: make sure user-create is only called with /user/register
        if (request.getMethod() == Method.POST) {
            String body = request.getBody();
            // TODO: use objectmapper to parse body to User class
            // userservice.register(user);
        }
        //TODO: add /login
        return null;
    }
}
