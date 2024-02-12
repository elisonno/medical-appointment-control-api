package doctorsappointments.controller;

import doctorsappointments.dto.LoginRequest;
import doctorsappointments.dto.LoginResponse;
import doctorsappointments.dto.SigInRequest;
import doctorsappointments.exception.BadRequestException;
import doctorsappointments.exception.NotFoundException;
import doctorsappointments.exception.UnauthorizatedException;
import doctorsappointments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/sigin")
    @ResponseStatus(HttpStatus.CREATED)
    public void sigIn(@RequestBody SigInRequest request) throws BadRequestException {
        service.sigIn(request);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws NotFoundException, UnauthorizatedException {
        return ResponseEntity.ok(service.login(loginRequest));
    }
}
