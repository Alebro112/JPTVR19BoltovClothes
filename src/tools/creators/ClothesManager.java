/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.creators;

import entity.Clothes;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ClothesManager {
    Scanner scanner = new Scanner(System.in);
    public Clothes createClothes() {
        Clothes clothes = new Clothes();
        System.out.println("--- Добавление одежды ---");
        System.out.print("Введите название одежды: ");
        clothes.setName(scanner.nextLine());
        System.out.print("Укажите цену: ");
        clothes.setPrice(scanner.nextDouble());
        System.out.print("Укажите колличество: ");
        clothes.setQuantity(scanner.nextInt());
        System.out.println("Добавлена одежда: "+clothes.getName());
        return clothes; 
    }
    public void printList(List<Clothes> listClothes){
        for (int i = 0; i < listClothes.size(); i++) {
            System.out.println(i + ". " + listClothes.get(i).getName() + " Цена: " + listClothes.get(i).getPrice() + " евро" + " Колличество: " + listClothes.get(i).getQuantity());
        }
    }
}
