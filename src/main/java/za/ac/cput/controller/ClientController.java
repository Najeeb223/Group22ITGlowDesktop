package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Client;
import za.ac.cput.service.ClientService;

import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public Client create(@RequestBody Client client) {
        return clientService.create(client);
    }

    @GetMapping("/read/{id}")
    public Client read(@PathVariable String id){
        return clientService.read(id);
    }

    @PostMapping("/update")
    public Client update(@RequestBody Client client) {
        return clientService.update(client);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        clientService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Client> getall(){
        return clientService.getAll();
    }


}
