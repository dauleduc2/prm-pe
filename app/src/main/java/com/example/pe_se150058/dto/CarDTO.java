package com.example.pe_se150058.dto;

public class CarDTO {

    private int id;
    private String model;
    private int price;

    public CarDTO(int id, String model, int price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    public CarDTO(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
