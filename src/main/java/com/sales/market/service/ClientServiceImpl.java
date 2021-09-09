package com.sales.market.service;

import com.sales.market.model.Client;
import com.sales.market.repository.ClientRepository;
import com.sales.market.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends GenericServiceImpl<Client> implements ClientService{
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    protected GenericRepository<Client> getRepository() {
        return clientRepository;
    }
}
