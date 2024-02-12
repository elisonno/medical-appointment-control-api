package doctorsappointments.exception;

import doctorsappointments.enums.ErrorEnum;

public class NotFoundException extends Exception{

    private final ErrorEnum error;

    public NotFoundException(ErrorEnum error) {
        this.error = error;
    }

    public ErrorEnum getError() {
        return error;
    }
}
