package com.sales.market.model;

import com.sales.market.dto.ClientDto;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Client extends ModelBase<ClientDto> {
    private String name;
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
