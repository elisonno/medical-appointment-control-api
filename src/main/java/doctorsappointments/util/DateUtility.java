package doctorsappointments.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtility {

    public static String convertFormat(LocalDate date){
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(dateTimeFormat);
    }
}
