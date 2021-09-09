package com.sales.market.repository;

import com.sales.market.model.Client;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends GenericRepository<Client>{
    List<Client> getAllByBirthday(LocalDate birthday);
}
