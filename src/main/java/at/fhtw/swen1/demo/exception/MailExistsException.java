package at.fhtw.swen1.demo.exception;

public class MailExistsException extends Exception {
    public MailExistsException(String message) {
        super(message);
    }
}