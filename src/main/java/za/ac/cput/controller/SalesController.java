package za.ac.cput.controller;
/*
Sinentlahla Pindani 219081328
26 May 2024
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Sales;
import za.ac.cput.service.SalesService;

import java.util.List;


@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired

    private SalesService salesService;

    @PostMapping("/create")
    public Sales create(@RequestBody Sales sales) {
        return salesService.create(sales);
    }

    @GetMapping("/read/{salesid}")
    public Sales read(@PathVariable String salesid) {
        return salesService.read(salesid);
    }

    @PostMapping("/update")
    public Sales update(@RequestBody Sales sales) {
        return salesService.update(sales);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        salesService.delete(id);
    }

    @GetMapping("/getAll/")
    public List<Sales> getAll() {
        return salesService.getAll();
    }
}


