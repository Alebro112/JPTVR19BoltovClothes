package jptvr19boltovclothes;

import entity.Clothes;
import entity.Customer;
import entity.Deal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tools.Saver;
import tools.creators.ClothesManager;
import tools.creators.CustomerManager;
import tools.creators.DealManager;


class App {
    private List<Clothes> listClothes = new ArrayList<>();
    private List<Customer> listCustomers = new ArrayList<>();
    private List<Deal> listDeals = new ArrayList<>();
    
    private ClothesManager clothesManager = new ClothesManager();
    private CustomerManager customerManager = new CustomerManager();
    private DealManager dealManager = new DealManager();
    
    private Saver saver = new Saver();
        
    public App() {
        listClothes = saver.load("clothes");
        listCustomers = saver.load("customers");
        listDeals = saver.load("deals");
    }
    
    Scanner scanner = new Scanner(System.in);
    public void run() {
        boolean repeat = true;
        while(repeat){
            int numTask = 0;
            while(true){          
                System.out.println("1. Добавить товар");
                System.out.println("2. Список товаров");
                System.out.println("3. Добавить покупателя");
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
                    listCustomers.add(customerManager.createCustomer());
                    saver.save(listCustomers, "customers");
                    break;
                case(4):
                    customerManager.printList(listCustomers);
                    break;
                case(5):
                    listDeals.add(dealManager.buyClothes(listClothes, listCustomers));
                    saver.save(listClothes, "clothes");
                    saver.save(listDeals, "deals");
                    break;
                case(6):
                    dealManager.printList(listDeals);
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
