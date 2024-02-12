package doctorsappointments.service;

import doctorsappointments.dto.LoginRequest;
import doctorsappointments.dto.LoginResponse;
import doctorsappointments.dto.SigInRequest;
import doctorsappointments.exception.BadRequestException;
import doctorsappointments.exception.NotFoundException;
import doctorsappointments.exception.UnauthorizatedException;
import org.springframework.http.ResponseEntity;


public interface UserService {

    void sigIn(SigInRequest request) throws BadRequestException;

    LoginResponse login(LoginRequest loginRequest) throws NotFoundException, UnauthorizatedException;
}
