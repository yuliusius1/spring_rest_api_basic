package com.belajarspring.dto;

import jakarta.validation.constraints.NotEmpty;

public class CategoryData {
    @NotEmpty(message = "Category name is required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
