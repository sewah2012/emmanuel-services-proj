package io.sewah.customer.exceptions.errors;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(String msg){
        super(msg);
    }
}
