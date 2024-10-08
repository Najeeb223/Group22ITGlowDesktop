


package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Schedule;
import za.ac.cput.service.ScheduleService;

import java.util.List;

/*OkuhleVellem*/
@RestController
@CrossOrigin(value = "http://localhost/3004")
@RequestMapping("/schedule")


public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

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
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        scheduleService.delete(id);
    }
    @GetMapping("/getall/")
    public List<Schedule> getall(){
        return scheduleService.getAll();
    }
}

