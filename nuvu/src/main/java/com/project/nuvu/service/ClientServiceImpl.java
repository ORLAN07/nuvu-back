package com.project.nuvu.service;

import com.project.nuvu.model.Client;
import com.project.nuvu.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

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

    @Override
    public Client updateClient(Client client) {
        Client clientId = clientRepository.findById(client.getIdClient()).orElse(null);
        if (clientId != null) {
            Client clientSave = clientId.builder()
                    .idClient(client.getIdClient())
                    .name1(client.getName1())
                    .name2(client.getName2())
                    .surname1(client.getSurname1())
                    .surname2(client.getSurname2())
                    .year(client.getYear())
                    .surname1(client.getSurname1())
                    .surname2(client.getSurname2())
                    .year(client.getYear())
                    .phone(client.getPhone())
                    .email(client.getEmail())
                    .cards(client.getCards()).build();
            return clientRepository.save(clientSave);
        }
        return null;
    }

    @Override
    public boolean deleteClient(Integer idClient) {
        Client clientId = clientRepository.findById(idClient).orElse(null);
        if (clientId != null) {
            clientRepository.delete(clientId);
            return true;
        }
        return false;
    }
}
