package doctorsappointments.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorEnum {
    USER_ALREADY_EXIST("001", "Usuário já existe"),
    USER_DOES_NOT_EXIST("002", "Usuário inexistente"),
    INVALID_PASSWORD("003", "Senha inválida"),
    GENERIC_ERROR("004","Erro ao processar sua requisição");


    private final String code;
    private final String message;

}
