package doctorsappointments.service;

import doctorsappointments.dto.LoginRequest;
import doctorsappointments.dto.LoginResponse;
import doctorsappointments.dto.SignInRequest;
import doctorsappointments.entity.User;
import doctorsappointments.exception.*;
import doctorsappointments.repository.UserRepository;
import doctorsappointments.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    private final static String name = "João";
    private final static String email = "joao@gmail.com";
    private final static String cpf = "01236575845";
    private final static LocalDate dateOfBirth = LocalDate.now();
    private final static String password = "123456789";

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository repository;

    @Test
    void signInSucees() throws BadRequestException {
        when(repository.findByEmail(any())).thenReturn(null);
        assertDoesNotThrow(() -> userService.signIn(new SignInRequest()));
    }

    @Test
    void signInFail() throws BadRequestException {
        var user = User.builder()
                .name(name)
                .email(email)
                .cpf(cpf)
                .dateOfBirth(dateOfBirth)
                .password(password)
                .build();
        when(repository.findByEmail(any())).thenReturn(user);
        assertThrows(UserAlreadyExist.class, () -> userService.signIn(new SignInRequest()));
    }


    @Test
    void loginSuccess() throws UnauthorizatedException, NotFoundException {
        var loginResponse = LoginResponse.builder()
                .name(name)
                .email(email)
                .cpf(cpf)
                .dateOfBirth(dateOfBirth)
                .build();
        var actual = new LoginRequest(email, password);
        when(repository.findByEmail(any())).thenReturn(User.builder()
                .name(name)
                .email(email)
                .cpf(cpf)
                .dateOfBirth(dateOfBirth)
                .password(password)
                .build());
        assertEquals(loginResponse, userService.login(actual));
    }

    @Test
    void loginFailUserDoesNotExist() throws UnauthorizatedException, NotFoundException {
        var actual = new LoginRequest(email, password);
        when(repository.findByEmail(any())).thenReturn(null);
        assertThrows(UserDoesNotExist.class, () -> userService.login(actual));
    }

    @Test
    void loginFailInvalidPassword() throws UnauthorizatedException, NotFoundException {
        var actual = new LoginRequest(email, "password");
        when(repository.findByEmail(any())).thenReturn(User.builder()
                .name(name)
                .email(email)
                .cpf(cpf)
                .dateOfBirth(dateOfBirth)
                .password(password)
                .build());
        assertThrows(InvalidPassword.class, () -> userService.login(actual));
    }

}