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
import tools.Saver;

/**
 *
 * @author pupil
 */
public class UserManager {
    Scanner scanner = new Scanner(System.in);
    Saver saver = new Saver();
    public User createUser() {
        User user = new User();
        System.out.println("--- Добавление Пользователя ---");
        System.out.print("Введите логин: ");
        user.setName(scanner.nextLine());
        
        System.out.print("Введите пароль: ");
        user.setPassword(scanner.nextLine());
        
        System.out.println("Выберите роль:");
        System.out.println("1. MANAGER");
        System.out.println("2. CUSTOMER");
        
        int num = scanner.nextInt();
        
        if(num == 1){ 
            user.setRole("MANAGER"); 
        }
        else { 
            user.setRole("CUSTOMER"); 
            CustomerManager customerManager = new CustomerManager();
            user.setCustomer(customerManager.createCustomer());
        }

        return user; 
    }
    
    public User login(List<User> listUsers){
        System.out.println("--- Вход ---");
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        for (int i = 0; i < listUsers.size(); i++) {
            if(login.equals(listUsers.get(i).getName())){
                for (int j = 0; j < 3; j++) {
                    System.out.print("Введите пароль: ");
                    String password = scanner.nextLine();
                    if(password.equals(listUsers.get(i).getPassword())){
                        System.out.println("Вход успешен");
                        return listUsers.get(i);
                    } else {
                        System.out.println("Неверный пароль");
                    }
                }
                System.out.println("Превышен лимит ввода пароля");
                return null;
            } 
        }
        
        return null;
    }
     
}
