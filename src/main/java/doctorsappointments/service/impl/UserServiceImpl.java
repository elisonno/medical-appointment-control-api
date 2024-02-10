package doctorsappointments.service.impl;


import doctorsappointments.dto.LoginRequest;
import doctorsappointments.dto.LoginResponse;
import doctorsappointments.dto.SigInRequest;
import doctorsappointments.entity.User;
import doctorsappointments.repository.UserRepository;
import doctorsappointments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void sigIn(SigInRequest request) throws Exception {
        User user = findByUser(request.getEmail());
        user = new User(request.getName(),request.getEmail(),request.getCpf(),request.getDateOfBirth(), request.getPassword());
        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws Exception {
        LoginResponse loginResponse;
        User user = findByUser(loginRequest.getEmail(), loginRequest.getPassword());
        loginResponse = new LoginResponse(user);
        return loginResponse;
    }

    private User findByUser(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user != null){
            throw new Exception();
        }
        return user;
    }

    private User findByUser(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new Exception();
        }
        if (!user.getPassword().equals(password)){
            throw new Exception();
        }
        return user;
    }
}
