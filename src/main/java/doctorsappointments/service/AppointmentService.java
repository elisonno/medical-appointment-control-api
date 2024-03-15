package doctorsappointments.service;

import doctorsappointments.dto.AppointmentRequest;
import doctorsappointments.dto.AppointmentResponse;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

public interface AppointmentService {

    AppointmentResponse appointments(ObjectId userId);

    AppointmentResponse myAppointments(ObjectId userId, int month, int year);

    void newMedicalAppointment(AppointmentRequest appointmentRequest);
}
