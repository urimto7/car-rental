package org.sda.RentCar.advice;

import java.time.LocalDateTime;

public class ErrorFormat {
    private String message;
    private LocalDateTime timestap;
    private String path;

    public String getMessage() {
        return message;
    }

    public ErrorFormat(String message, LocalDateTime timestap, String path) {
        this.message = message;
        this.timestap = timestap;
        this.path = path;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestap() {
        return timestap;
    }

    public void setTimestap(LocalDateTime timestap) {
        this.timestap = timestap;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
