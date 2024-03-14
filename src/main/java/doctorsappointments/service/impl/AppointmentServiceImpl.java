package doctorsappointments.service.impl;

import doctorsappointments.dto.AppointmentDTO;
import doctorsappointments.dto.AppointmentRequest;
import doctorsappointments.dto.AppointmentResponse;
import doctorsappointments.entity.Appointment;
import doctorsappointments.repository.AppointmentRepository;
import doctorsappointments.service.AppointmentService;
import doctorsappointments.util.DateUtility;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;


    @Override
    public AppointmentResponse appointments(ObjectId userId) {
        var appointments = listMedicalAppointments(userId);
        List<AppointmentDTO> myappointments = new ArrayList<>();
        for (Appointment actual : appointments){
            var actualAppointment = AppointmentDTO.builder()
                    .nameMedicalAppontment(actual.getNameMedicalAppontment())
                    .medicalProcedure(actual.getMedicalProcedure())
                    .status(actual.getStatus())
                    .dateMedicalAppontment(DateUtility.convertFormat(actual.getDateMedicalAppontment()))
                    .billingDate(DateUtility.convertFormat(actual.getBillingDate()))
                    .build();
            myappointments.add(actualAppointment);
        }

        return AppointmentResponse.builder()
                .appointments(myappointments)
                .build();
    }

    @Override
    public void newMedicalAppointment(AppointmentRequest appointmentRequest) {

        var appointment = Appointment.builder()
                .userId(appointmentRequest.getUserId())
                .nameMedicalAppontment(appointmentRequest.getNameMedicalAppontment())
                .medicalProcedure(appointmentRequest.getMedicalProcedure())
                .status(appointmentRequest.getStatus())
                .dateMedicalAppontment(LocalDate.now())
                .billingDate(LocalDate.now().plusMonths(3))
                .build();
        appointmentRepository.save(appointment);
    }

    private List<Appointment> listMedicalAppointments (ObjectId userId){
        return appointmentRepository.findByUserId(userId);
    }

}
