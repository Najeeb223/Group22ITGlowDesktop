package za.ac.cput.controller;
/*Sinentlahla Pindani 219081328
        26 May 2024
        */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Appointment;
import za.ac.cput.service.AppointmentService;


import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentservice;

    @PostMapping("/create")
    public Appointment create(@RequestBody Appointment appointment){

        return appointmentservice.create(appointment);
    }
    @GetMapping("/read/{id}")
    public Appointment read(@PathVariable String id){
        return appointmentservice.read(id);
    }

    @PostMapping("/update")
    public Appointment update(@RequestBody Appointment appointment){

        return appointmentservice.update(appointment);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        appointmentservice.delete(id);
    }


    @GetMapping("/getAll")
    public List<Appointment> getAll() {
        return  appointmentservice.getAll();
    }

}
