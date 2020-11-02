package jptvr19boltovclothes;

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
import ui.ManagerUI;
import ui.UserUI;


class App {
    private List<User> listUsers = new ArrayList<>();
    private List<Customer> listCustomers = new ArrayList<>();

    private UserManager userManager = new UserManager();
    private CustomerManager customerManager = new CustomerManager();

    private Saver saver = new Saver();
        
    public App() {
        listUsers = saver.load("users");
        listCustomers = saver.load("customers");
    }
    
    
    Scanner scanner = new Scanner(System.in);
    public void run() {
        User user = new User();
        System.out.println("1. Вход");
        System.out.println("2. Регистрация");
        
        int num = scanner.nextInt();
        
        if (num == 1){
            user = userManager.login(listUsers);
        } else {
            user = userManager.createUser();
            listUsers.add(user);
            saver.save(listUsers, "users");   
            System.out.println(user.toString());
        }
        
        if(user.getRole().equals("MANAGER")){
            ManagerUI managerUI = new ManagerUI();
            managerUI.run(user);
        }
        if(user.getRole().equals("CUSTOMER")){
            UserUI userUI = new UserUI();
            userUI.run(user);
        }
    }
    
}
