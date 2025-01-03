package com.homeopathyforall.dto;

import com.homeopathyforall.model.Appointment;
import lombok.*;

@Data
public class AppointmentDTO { private String id;
    private String patientId;
    private String doctorId;
    private String appointmentTime;
    private String status;

}
