package doctorsappointments.service.impl;


import doctorsappointments.dto.LoginRequest;
import doctorsappointments.dto.LoginResponse;
import doctorsappointments.dto.SignInRequest;
import doctorsappointments.entity.User;
import doctorsappointments.exception.*;
import doctorsappointments.repository.UserRepository;
import doctorsappointments.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public void signIn(SignInRequest request) throws BadRequestException {
        verificationUserAlreadyExist(request.getEmail());
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .cpf(request.getCpf())
                .dateOfBirth(request.getDateOfBirth())
                .password(request.getPassword())
                .build();
        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws NotFoundException, UnauthorizatedException {
        var user = verificationUserExistAndPasswordIsCorrect(loginRequest.getEmail(), loginRequest.getPassword());
        return LoginResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .cpf(user.getCpf())
                .dateOfBirth(user.getDateOfBirth())
                .build();
    }

    private void verificationUserAlreadyExist(String email) throws BadRequestException {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            throw new UserAlreadyExist();
        }
    }

    private User verificationUserExistAndPasswordIsCorrect(String email, String password) throws NotFoundException, UnauthorizatedException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserDoesNotExist();
        }
        if (!user.getPassword().equals(password)) {
            throw new InvalidPassword();
        }
        return user;
    }
}
