package doctorsappointments.service.impl;


import doctorsappointments.dto.LoginRequest;
import doctorsappointments.dto.LoginResponse;
import doctorsappointments.dto.SigInRequest;
import doctorsappointments.entity.User;
import doctorsappointments.exception.*;
import doctorsappointments.repository.UserRepository;
import doctorsappointments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void sigIn(SigInRequest request) throws BadRequestException {
        User user = findByUser(request.getEmail());
        user = new User(request.getName(),request.getEmail(),request.getCpf(),request.getDateOfBirth(), request.getPassword());
        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws NotFoundException, UnauthorizatedException {
        LoginResponse loginResponse;
        User user = findByUser(loginRequest.getEmail(), loginRequest.getPassword());
        loginResponse = new LoginResponse(user);
        return loginResponse;
    }

    private User findByUser(String email) throws BadRequestException {
        User user = userRepository.findByEmail(email);
        if(user != null){
            throw new UserAlreadyExist();
        }
        return user;
    }

    private User findByUser(String email, String password) throws NotFoundException, UnauthorizatedException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UserDoesNotExist();
        }
        if (!user.getPassword().equals(password)){
            throw new InvalidPassword();
        }
        return user;
    }
}
