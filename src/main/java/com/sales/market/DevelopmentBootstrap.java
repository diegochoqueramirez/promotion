/**
 * @author: Edson A. Terceros T.
 */

package com.sales.market;

import com.sales.market.model.Buy;
import com.sales.market.model.Client;
import com.sales.market.repository.BuyRepository;
import com.sales.market.repository.ClientRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DevelopmentBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private BuyRepository buyRepository;
    private ClientRepository clientRepository;

    // injeccion evita hacer instancia   = new Clase();
    // bean pueden tener muchos campos y otros beans asociados

    public DevelopmentBootstrap(BuyRepository buyRepository, ClientRepository clientRepository) {
        this.buyRepository = buyRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("evento de spring");
        /*   duplicacion de codigo
        Buy buy = new Buy();
        buy.setValue(BigDecimal.TEN);
        buyRespository.save(buy);
        Buy buy2 = new Buy();
        buy2.setValue(BigDecimal.ONE);
        buyRespository.save(buy);*/

        persistBuy(BigDecimal.TEN);
        persistBuy(BigDecimal.ONE);
        persistClient();
    }

    private void persistBuy(BigDecimal value) {
        Buy buy = new Buy();
        buy.setValue(value);
        buyRepository.save(buy);
    }

    private void persistClient() {
        Client client = new Client();
        client.setName("Diego");
        client.setEmail("diego@gmail.com");
        client.setBirthday(LocalDate.of(2014, 9, 9));
        clientRepository.save(client);

        Client client1 = new Client();
        client1.setName("Marcelo");
        client1.setEmail("marcelo@gmail.com");
        client1.setBirthday(LocalDate.of(2014, 9, 9));
        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setName("Luis");
        client2.setEmail("luis@gmail.com");
        client2.setBirthday(LocalDate.of(2014, 9, 9));
        clientRepository.save(client2);
    }
}
