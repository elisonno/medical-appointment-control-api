package doctorsappointments.exception;

import doctorsappointments.enums.ErrorEnum;

public class UserAlreadyExist extends BadRequestException{

    public UserAlreadyExist() {
    super(ErrorEnum.USER_ALREADY_EXIST);
    }
}
