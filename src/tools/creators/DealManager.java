/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.creators;

import entity.Clothes;
import entity.Customer;
import entity.Deal;
import entity.User;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class DealManager {
    Scanner scanner = new Scanner(System.in);
    
    ClothesManager clothesManager = new ClothesManager();
    CustomerManager customerManager = new CustomerManager();
    Calendar calendar = new GregorianCalendar();
    
    public Deal buyClothes(List<Clothes> listClothes, List<User> listUsers, User user){  
        System.out.println("------- Покупка товара -------");
        int idClothes = -1;
        int idCustomers = -1;
        while(true){
            System.out.println("--- Список товаров ---");
            clothesManager.printList(listClothes);
            System.out.print("Выберите ИД товара из списка: ");
            try{
                idClothes = scanner.nextInt();
                if (listClothes.get(idClothes).getQuantity() > 0) {
                    break;
                }
            } catch(Exception e) {
                
            }   
            System.out.println("--- Ещё раз ---");
        }
        if(user.getRole().equals("CUSTOMER")) {
            Clothes clothes = listClothes.get(idClothes);
            Customer customer = user.getCustomer();
            
            clothes.setQuantity(clothes.getQuantity()-1);
            customer.setMoney(customer.getMoney() - clothes.getPrice());

            Deal deal = new Deal();
            deal.setCustomer(customer);
            deal.setClothes(clothes);
            deal.setPurchaseDate(calendar.getTime());
            System.out.println(deal.toString());
            System.out.println("---- Куплено ----");
            return deal;
        }
        while(true){
            System.out.println("--- Список покупателей ---");
            customerManager.printList(listUsers);
            System.out.print("Выберите ИД пользователя из списка: ");
            try{
                idCustomers = scanner.nextInt();
                if (listUsers.get(idCustomers).getCustomer().getMoney() > 0) {
                    break;
                } else {
                    System.out.println("Недостаточно денег");
                }
            } catch(Exception e) {
                
            } 
            System.out.println("--- Ещё раз ---");
        }
        Clothes clothes = listClothes.get(idClothes);
        Customer customer = listUsers.get(idCustomers).getCustomer();
        
        clothes.setQuantity(clothes.getQuantity()-1);
        customer.setMoney(customer.getMoney() - clothes.getPrice());
        
        Deal deal = new Deal();
        deal.setCustomer(customer);
        deal.setClothes(clothes);
        deal.setPurchaseDate(calendar.getTime());
        System.out.println(deal.toString());
        System.out.println("---- Куплено ----");
        return deal;
    }
    
    public void printList(List<Deal> listDeals, User user){
        System.out.println("------- Список покупок -------");
        if(user.getRole().equals("CUSTOMER")){
            for (int i = 0; i < listDeals.size(); i++) {
                if(listDeals.get(i).getCustomer().getFirstName().equals(user.getCustomer().getFirstName())){
                    System.out.println(i + ". " + listDeals.get(i).toString());
                }
            }
        } else {
            for (int i = 0; i < listDeals.size(); i++) {
                System.out.println(i + ". " + listDeals.get(i).toString());
            }
        }
    }   
}
