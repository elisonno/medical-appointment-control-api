package doctorsappointments.exception;

import doctorsappointments.enums.ErrorEnum;

public class UserDoesNotExist extends NotFoundException{
    public UserDoesNotExist() {
        super(ErrorEnum.USER_DOES_NOT_EXIST);
    }
}
