package doctorsappointments.service;

import doctorsappointments.dto.AppointmentRequest;
import doctorsappointments.dto.AppointmentResponse;
import doctorsappointments.dto.UpdateRequest;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;

public interface AppointmentService {

    void deleteAppointment(ObjectId appointmentId);

    AppointmentResponse appointments(ObjectId userId);

    AppointmentResponse myAppointments(ObjectId userId, int month, int year);

    void changingMedicalAppointmentStatus(UpdateRequest updateRequest);

    void newMedicalAppointment(AppointmentRequest appointmentRequest);
}
