package doctorsappointments.exception;

import doctorsappointments.enums.ErrorEnum;

public class UnauthorizatedException extends Exception{

    private final ErrorEnum error;

    public UnauthorizatedException(ErrorEnum error) {
        this.error = error;
    }

    public ErrorEnum getError() {
        return error;
    }
}
