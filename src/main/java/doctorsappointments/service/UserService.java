package doctorsappointments.service;

import doctorsappointments.dto.LoginRequest;
import doctorsappointments.dto.LoginResponse;
import doctorsappointments.dto.SigInRequest;
import org.springframework.http.ResponseEntity;


public interface UserService {

    void sigIn(SigInRequest request) throws Exception;

    LoginResponse login(LoginRequest loginRequest) throws Exception;
}
