package doctorsappointments.controller;

import doctorsappointments.dto.LoginRequest;
import doctorsappointments.dto.LoginResponse;
import doctorsappointments.dto.SignInRequest;
import doctorsappointments.exception.BadRequestException;
import doctorsappointments.exception.NotFoundException;
import doctorsappointments.exception.UnauthorizatedException;
import doctorsappointments.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.CREATED)
    public void signIn(@RequestBody SignInRequest request) throws BadRequestException {
        service.signIn(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws NotFoundException, UnauthorizatedException {
        return service.login(loginRequest);
    }

}
