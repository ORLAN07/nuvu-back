package com.project.nuvu.controller;

import com.project.nuvu.model.Client;
import com.project.nuvu.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    @Autowired
    public ClientService clientService;

    @RequestMapping(method = RequestMethod.POST)
    public Client create(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id-client}")
    public Client get(@PathVariable("id-client") Integer idClient) {
        return clientService.getClientById(idClient);
    }

}
