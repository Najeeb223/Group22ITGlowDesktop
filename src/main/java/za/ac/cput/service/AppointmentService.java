package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Appointment;
import za.ac.cput.repository.AppointmentRepository;


import java.util.List;
@Service
public class AppointmentService implements IAppointmentService{

    private final AppointmentRepository repository;

    @Autowired
    AppointmentService(AppointmentRepository repository){
        this.repository= repository;
    }


    @Override
    public Appointment create(Appointment appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public Appointment read(String appointmentID) {
        return this.repository.findById(appointmentID).orElse(null);
    }

    @Override
    public Appointment update(Appointment appointment) {
        if( this.repository.existsById(appointment.getAppointmentID()))
            return this.repository.save(appointment);
        return null;
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

   /* @Override
    public boolean delete(String appointmentID) {
        if (this.repository.existsById(appointmentID)){
            this.repository.deleteById(appointmentID);
            return true;
        }
        return false;
    }*/


    @Override
    public List<Appointment> getAll() {
        return this.repository.findAll();
    }

}



