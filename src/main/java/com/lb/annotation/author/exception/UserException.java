package com.lb.annotation.author.exception;

/**
 * @author : lb
 * @date : 2020/9/4 11:02
 * @description :
 */
public class UserException extends RuntimeException {

    private String message;

    public UserException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
