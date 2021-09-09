package com.sales.market.service;

import com.sales.market.model.Promotion;
import com.sales.market.repository.GenericRepository;
import com.sales.market.repository.PromotionRepository;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl extends GenericServiceImpl<Promotion> implements PromotionService {

    private final PromotionRepository repository;

    public PromotionServiceImpl(PromotionRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<Promotion> getRepository() {
        return repository;
    }
}
