/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author pupil
 */
public class Deal implements Serializable{
    private Customer customer;
    private Clothes clothes;
    private Date purchaseDate;

    public Deal() {
    }

    public Deal(Customer customer, Clothes clothes, Date purchaseDate) {
        this.customer = customer;
        this.clothes = clothes;
        this.purchaseDate = purchaseDate;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return
                "Покупатель: " + customer + 
                "\n   Товар: " + clothes + 
                "\n   Дата покупки: " + purchaseDate + 
                "\n   ----------------------- ";
    }
    
}
