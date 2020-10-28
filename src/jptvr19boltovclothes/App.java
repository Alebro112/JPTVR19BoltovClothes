/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr19boltovclothes;

import entity.Clothes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tools.Saver;
import tools.creators.ClothesManager;


class App {
    private List<Clothes> listClothes = new ArrayList<>();
    
    private ClothesManager clothesManager = new ClothesManager();
    
    private Saver saver = new Saver();
        
    public App() {
        listClothes = saver.load("clothes");
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
                System.out.println("0. Выйти");
                System.out.print("Выберите задачу: ");
                numTask = scanner.nextInt();
                if(numTask > -1 && numTask <6){
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
                    break;
                case(4):
                    break;
                case(5):
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
