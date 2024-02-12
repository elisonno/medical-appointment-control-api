package doctorsappointments.enums;


public enum ErrorEnum {
    USER_ALREADY_EXIST("001", "Usuário já existe"),
    USER_DOES_NOT_EXIST("002", "Usuário inexistente"),
    INVALID_PASSWORD("003", "Senha inválida"),
    GENERIC_ERROR("004","Erro ao processar sua requisição");


    private final String code;
    private final String message;

    ErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return code + " - " + message;
    }
}
