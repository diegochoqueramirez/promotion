package com.sales.market.service;

import com.sales.market.model.Client;
import com.sales.market.repository.ClientRepository;
import com.sales.market.repository.GenericRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl extends GenericServiceImpl<Client> implements ClientService{
    LocalDate currentdate = LocalDate.now();
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getByBirthday() {
//        return clientRepository.getAllByBirthday();
        List<Client> result = new ArrayList<>();
        List<Client> clients = clientRepository.findAll();
        for (Client client: clients) {
            if (client.getBirthday().getMonth() == currentdate.getMonth()
                    && client.getBirthday().getDayOfMonth() == currentdate.getDayOfMonth()) {
                result.add(client);
            }
        }

        return result;
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    protected GenericRepository<Client> getRepository() {
        return clientRepository;
    }
}
