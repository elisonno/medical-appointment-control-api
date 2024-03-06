package doctorsappointments.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusEnum {
    CHARGED("001","paga"),
    NOT_CHARGED("002","Pagamento pendente");

    private final String code;
    private final String message;
}
