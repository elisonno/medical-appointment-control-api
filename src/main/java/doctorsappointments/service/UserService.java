package doctorsappointments.service;

import doctorsappointments.dto.LoginRequest;
import doctorsappointments.dto.LoginResponse;
import doctorsappointments.dto.SignInRequest;
import doctorsappointments.exception.BadRequestException;
import doctorsappointments.exception.NotFoundException;
import doctorsappointments.exception.UnauthorizatedException;


public interface UserService {

    void signIn(SignInRequest request) throws BadRequestException;

    LoginResponse login(LoginRequest loginRequest) throws NotFoundException, UnauthorizatedException;
}
