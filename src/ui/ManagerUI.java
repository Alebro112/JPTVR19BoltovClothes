/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Clothes;
import entity.Customer;
import entity.Deal;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tools.Saver;
import tools.creators.ClothesManager;
import tools.creators.CustomerManager;
import tools.creators.DealManager;
import tools.creators.UserManager;

/**
 *
 * @author pupil
 */
public class ManagerUI {
    private List<Clothes> listClothes = new ArrayList<>();
    private List<Deal> listDeals = new ArrayList<>();
    private List<User> listUsers = new ArrayList<>();
    
    private ClothesManager clothesManager = new ClothesManager();
    private CustomerManager customerManager = new CustomerManager();
    private DealManager dealManager = new DealManager();
    private UserManager userManager = new UserManager();
    
    private Saver saver = new Saver();
    
    Scanner scanner = new Scanner(System.in);

    public ManagerUI(){
        listClothes = saver.load("clothes");
        listDeals = saver.load("deals");
        listUsers = saver.load("users");
    }
    public void run(User user){
        boolean repeat = true;
        while(repeat){
            int numTask = 0;
            while(true){          
                System.out.println("1. Добавить товар");
                System.out.println("2. Список товаров");
                System.out.println("3. Добавить пользователя");
                System.out.println("4. Список покупателей");
                System.out.println("5. Купить товар");
                System.out.println("6. Список покупок");
                System.out.println("0. Выйти");
                System.out.print("Выберите задачу: ");
                numTask = scanner.nextInt();
                if(numTask > -1 && numTask <7){
                    break;
                } 
            }
            switch(numTask){
                case(1):
                    listClothes.add(clothesManager.createClothes());
                    saver.save(listClothes, "clothes");
                    break;
                case(2):
                    clothesManager.printList(listClothes);
                    break;
                case(3):
                    listUsers.add(userManager.createUser());
                    saver.save(listUsers, "users");
                    break;
                case(4):
                    customerManager.printList(listUsers);
                    break;
                case(5):
                    listDeals.add(dealManager.buyClothes(listClothes, listUsers, user));
                    saver.save(listClothes, "clothes");
                    saver.save(listDeals, "deals");
                    break;
                case(6):
                    dealManager.printList(listDeals, user);
                    break;
                case(0):
                    repeat = false;
                    break;
                default:
                    break;
            }
        } 
    }
}
