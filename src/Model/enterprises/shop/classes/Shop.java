/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.shop.classes;

//@Author Susanna

import Model.administration.Customer;
import Model.administration.Item;
import Model.enterprises.shop.interfaces.IShop;
import Model.system.DataInterpreter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Shop implements IShop {
    private final String name;
    private LinkedList<Item> warehouse;
    private DataInterpreter dataInt;

    public Shop(){
        super();
        this.name = "Shop";
        try {
            this.dataInt = new DataInterpreter(new File("./src/Model/system/DataFolder/Shop.txt"), "Shop");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        this.warehouse = this.dataInt.getData().getFirst();
    }
    
    public Shop(String name) throws IOException {
        super();
        this.name = name.substring(0, name.length()-4); 

        this.fileChecker(name);
    }

    @Override
    public List<Item> getWarehouse() {
        return this.warehouse.stream().filter(i -> i.getQuantity() > 0).collect(Collectors.toList());
    }
    
    @Override
    public boolean addItem(String name, double price, int quantity) {
        boolean done = false;
        if(!this.checkItemByName(name)) {
            this.warehouse.add(new Item(name, price, quantity));
            done = true;
        }
        else
            System.out.println("Error: item already registered");
        return done;
    }
    
    @Override
    public boolean removeItem(Item i) {
        boolean done = false;
        if(this.checkItemByName(i.getName())) {
            done = true;
            this.warehouse.remove(i);
        }
        else
            System.out.println("Error: item not registered");
        return done;
    }

    @Override
    public boolean refueling(Item i, int n) {
        boolean done = false;
        if(this.checkItemByName(i.getName())) {
            i.increaseQuantity(n);
            done = true;
        }
        if(!done)
            System.out.println("Error: book not registered");
        return done;
    }
    
    public String getName(){
        return this.name;
    }

    @Override
    public boolean buyAItem(Item i, int n, Customer c) {
        boolean done = false;
        if(i.getQuantity() >= n) {
            if ((c.getCredit() - i.getPrice()) >= 0) {
                i.decreaseQuantity(n);
                c.getCart().addItem(i);
                done = true;
            } else
                System.out.println("Error: insufficient credit ");
        } else
            System.out.println("Error: books not enough"); 
        return done;
    }
    
    public void saveData(){
        this.getDataInterpreter().getDataWriter().setTxt();
        this.getWarehouse().forEach(i -> this.getDataInterpreter().getDataWriter().addItem(i));
        try {
            this.getDataInterpreter().getDataWriter().writeOnFile();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public DataInterpreter getDataInterpreter(){
        return this.dataInt;
    }
    
    private boolean checkItemByName(String name) {
        return this.warehouse.stream().filter(item -> item.getName().equalsIgnoreCase(name)).findFirst().isPresent();
    }
    
    private void fileChecker(String name) throws IOException{
        try{
        this.dataInt = new DataInterpreter(new File("./src/Model/system/DataFolder/" + name + ".txt"), "Shop");       
        }catch(FileNotFoundException fNf){
            File f = new File("./src/Model/system/DataFolder/" + name + ".txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f, true);
            fw.write("");
            this.dataInt = new DataInterpreter(f, "Shop");
        }finally{
            this.warehouse = dataInt.getData().getFirst();          
        }
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = result * hash + Objects.hashCode(this.name);
        result = result * hash + Objects.hashCode(this.warehouse);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Shop other = (Shop) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.warehouse, other.warehouse);
    }

    @Override
    public String toString() {
        return "Shop " + this.name;
    }
}
