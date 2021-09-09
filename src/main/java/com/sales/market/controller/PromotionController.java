package com.sales.market.controller;

import com.sales.market.dto.PromotionDto;
import com.sales.market.model.Promotion;
import com.sales.market.service.GenericService;
import com.sales.market.service.PromotionService;
import controller.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promotion/birthday")
public class PromotionController extends GenericController<Promotion, PromotionDto> {
    private PromotionService service;

    public PromotionController(PromotionService service) {
        this.service = service;
    }



    @Override
    protected GenericService getService() {
        return service;
    }
}
