package pl.sda.humanresource.exception;

public class WorkerAlreadyHasWorkException extends RuntimeException{
    public WorkerAlreadyHasWorkException(String message) {
        super(message);
    }
}
