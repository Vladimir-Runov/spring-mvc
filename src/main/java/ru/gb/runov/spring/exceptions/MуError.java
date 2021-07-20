package ru.gb.runov.spring.exceptions;

import lombok.Data;
import java.util.Date;

@Data
public class MуError {
    private int status;
    private String message;
    private Date timestamp;

    public MуError(int value, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}

