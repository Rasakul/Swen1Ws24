package at.fhtw.swen1.demo.controller;

import at.fhtw.swen1.demo.httpserver.server.Request;
import at.fhtw.swen1.demo.httpserver.server.Response;

public interface Controller {
    Response handleRequest(Request request);
}
