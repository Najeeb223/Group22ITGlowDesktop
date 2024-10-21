


package za.ac.cput.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Schedule;
import za.ac.cput.service.ScheduleService;

import java.util.List;

/*OkuhleVellem*/
@RestController
@CrossOrigin(value = "http://localhost/3004")
@RequestMapping("/schedule")


public class ScheduleController {

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }
    @Autowired
    private ScheduleService scheduleService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public Schedule create(@RequestBody Schedule schedule){
        return scheduleService.create(schedule);
    }

    @GetMapping("/read/{scheduleid}")
    public Schedule read(@PathVariable String scheduleid){
        return scheduleService.read(scheduleid);
    }

    @PostMapping("/update")
    public Schedule update(@RequestBody Schedule schedule){
        return scheduleService.update(schedule);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        scheduleService.delete(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/getall")
    public List<Schedule> getall(){
        return scheduleService.getAll();
    }

}

