package com.example.assignment2;

import java.io.Serializable;

public class Item implements Serializable {

    private String description;
    private String quantity;
    private String price;
    private String id;

    public Item (String id, String description, String quantity, String price){
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId(){
        return "" + id;
    }

    public String getDescription(){
        return description;
    }

    public String getQuantity(){
        return quantity;
    }

    public String getPrice(){
        return price;
    }

    public void setId(String newId){
        this.id = newId;
    }

    public void setDescription(String newDesc){
        this.description = newDesc;
    }

    public void setQuantity(String newQnty){
        this.quantity = newQnty;
    }

    public void setPrice(String newPrice) {
        this.price = newPrice;
    }

    public String toString() {
        return this.getDescription();
    }
}