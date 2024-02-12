package doctorsappointments.exception;

import doctorsappointments.enums.ErrorEnum;

public class InvalidPassword extends UnauthorizatedException{

    public InvalidPassword() {
        super(ErrorEnum.INVALID_PASSWORD);
    }
}
