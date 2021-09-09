package com.sales.market.service;

import com.sales.market.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.testng.Assert.*;
@SpringBootTest
public class ClientServiceImplTest {
    @Autowired
    private ClientServiceImpl clientService;

    @Test
    void test() {
        List<Client> result = clientService.getByBirthday();
        System.out.println(result.size() + " este es el result");
        assertEquals(3, result.size());
    }

}