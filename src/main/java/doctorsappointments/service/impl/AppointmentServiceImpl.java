package doctorsappointments.service.impl;

import doctorsappointments.dto.AppointmentRequest;
import doctorsappointments.entity.Appointment;
import doctorsappointments.repository.AppointmentRepository;
import doctorsappointments.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;


    @Override
    public List<Appointment> appontmests(ObjectId userId) {
        return null;
    }

    @Override
    public void newMedicalAppointment(AppointmentRequest appointmentRequest) {

        var appointment = Appointment.builder()
                .userId(appointmentRequest.getUserId())
                .nameMedicalAppontment(appointmentRequest.getNameMedicalAppontment())
                //.medicalProcedure(appointmentRequest.getMedicalProcedure())
                .status(appointmentRequest.getStatus())
                .dateMedicalAppontment(appointmentRequest.getDateMedicalAppontment())
                .build();
        appointmentRepository.save(appointment);
    }
}
