package doctorsappointments.exception;

import doctorsappointments.enums.ErrorEnum;

public class BadRequestException extends Exception{

    private final ErrorEnum error;

    public BadRequestException(ErrorEnum error) {
        this.error = error;
    }

    public ErrorEnum getError() {
        return error;
    }
}
