/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.creators;

import entity.Customer;
import entity.User;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class CustomerManager {
    Scanner scanner = new Scanner(System.in);
    public Customer createCustomer() {
        Customer customer = new Customer();
        System.out.println("--- Добавление покупателя ---");
        System.out.print("Введите имя: ");
        customer.setFirstName(scanner.nextLine());
        
        System.out.print("Введите фамилию: ");
        customer.setLastName(scanner.nextLine());
        
        System.out.print("Введите количество денег: ");
        customer.setMoney(scanner.nextDouble());
        

        return customer; 
    }
     
    public void printList(List<User> listUsers){
        for (int i = 0; i < listUsers.size(); i++) {
            if(listUsers.get(i).getCustomer() != null){
                System.out.println(i + ". " + listUsers.get(i).getCustomer().toString());
            }
        }
    }
}
