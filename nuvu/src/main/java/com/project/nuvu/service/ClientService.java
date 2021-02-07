package com.project.nuvu.service;

import com.project.nuvu.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {

    public List<Client> listAllClient();
    public Client getClientById(Integer idClient);
    public Client saveClient(Client client);
    public Client updateClient(Client client);
    public boolean deleteClient(Integer idClient);
}
