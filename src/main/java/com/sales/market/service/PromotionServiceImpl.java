package com.sales.market.service;

import com.sales.market.model.Client;
import com.sales.market.model.Promotion;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PromotionServiceImpl extends GenericServiceImpl<Promotion> implements PromotionService {
    @Value("${discountValue}")
    private BigDecimal discountValue;
    private String base = "%n Hoy es su cumpleaños y usted es importante para nosotros, queremos celebralo ofreciendo un %d % de descuento y delivery gratuito. Valido por 24 hrs";

    private final PromotionRepository repository;
    private ClientServiceImpl clientService;

    public PromotionServiceImpl(PromotionRepository repository, ClientServiceImpl clientService) {
        this.repository = repository;
        this.clientService = clientService;
    }

    public void sendEmail() {
        List<Client> clients = clientService.getByBirthday();
        for (Client client : clients) {
            Promotion promotion = new Promotion();
            String description = format(client);
            promotion.setDescription(description);
            System.out.println(promotion.getDescription());
            repository.save(promotion);
        }
    }

    public String format(Client client) {
        return String.format(base, client.getName(), discountValue);
//        StringBuilder message = new StringBuilder();
//        message.append(client.getName()+" Hoy es su cumpleaños y usted es importante para nosotros, " +
//                " queremos celebralo ofreciendo un "+ discountValue + " de descuento y delivery gratuito. Valido por 24 hrs");
//        return message.toString();
    }

    @Override
    protected GenericRepository<Promotion> getRepository() {
        return repository;
    }
}
