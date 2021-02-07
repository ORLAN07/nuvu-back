package com.project.nuvu.service;

import com.project.nuvu.model.Client;
import com.project.nuvu.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> listAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Integer idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
}
