package doctorsappointments.controller;

import doctorsappointments.dto.AppointmentRequest;
import doctorsappointments.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/new")
    public void newMedicalAppointment(@RequestBody AppointmentRequest appointmentRequest){
        appointmentService.newMedicalAppointment(appointmentRequest);
    }
}
