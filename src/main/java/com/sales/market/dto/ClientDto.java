package com.sales.market.dto;

import com.sales.market.model.Client;

import java.time.LocalDate;

public class ClientDto extends DtoBase<Client>{
    private String name;
    private LocalDate birthday;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
