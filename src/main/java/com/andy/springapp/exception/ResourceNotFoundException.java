package com.andy.springapp.exception;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException (String message){
        super(message);
    }

}
