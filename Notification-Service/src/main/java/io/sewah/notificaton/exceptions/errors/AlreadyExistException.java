package io.sewah.notificaton.exceptions.errors;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(String msg){
        super(msg);
    }
}
