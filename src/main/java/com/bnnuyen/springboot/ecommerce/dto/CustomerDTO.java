package com.bnnuyen.springboot.ecommerce.dto;

import java.util.HashSet;
import java.util.Set;

public class CustomerDTO {
    private Long id;

    private String fullName;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
