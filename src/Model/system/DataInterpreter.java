/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.system;

import Model.administration.Administration;
import Model.administration.Customer;
import Model.administration.Item;
import Model.enterprises.restaurant.Dish;
import Model.administration.Person;
import Model.administration.Staff;
import Model.enterprises.library.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 *
 * @author Mars_DB
 */
public class DataInterpreter {
    private Administration aD;
    private DataWriter dW;
    private DataReader dR;
    private LinkedList<LinkedList> data;
    private LinkedList<Person> accounts;
    private String listReq;                    // riferimento all'oggetto chiamante per tipo di oggetti da mettere in lista
    
    public DataInterpreter(File f, String requirer) throws FileNotFoundException{
        this.dR = new DataReader(f);
        this.data = new LinkedList();
        this.accounts = new LinkedList();
        this.listReq = requirer;
        this.readData(this.dR.getRawData());
        this.dW = new DataWriter(f, requirer, this.dR.getRawData());
    }
    
    public DataInterpreter(File f, String requirer, Administration aD) throws FileNotFoundException{
        this.dR = new DataReader(f);
        this.data = new LinkedList();
        this.accounts = new LinkedList();
        this.listReq = requirer;
        this.readData(this.dR.getRawData());
        this.dW = new DataWriter(f, requirer, this.dR.getRawData());
        this.aD = aD;
    }
    
    private void readData(LinkedList<String> rawData){
        this.data.add(new LinkedList<Item>());
        String type = null;
        int i = 0;        
        for(String s: rawData){
            if(s.contains("#")){     
                type = s.substring(1);               
                if(!type.equals("FIRSTS") && this.listReq.equals("Restaurant")){
                   this.data.add(new LinkedList<Item>());
                   i++;
                }
            }else{
                    parseData(s, type, i);
            }              
        }
    } 
        
    public LinkedList<LinkedList> getData(){
        return this.data;
    }
    
    public LinkedList<Person> getAccounts(){
        return this.accounts;
    }
    
    public DataWriter getDataWriter(){
        return this.dW;
    }
    // "\\D+ serve per far riconoscere i numeri float da stringhe, regola la presa dei numeri forzandoli a vedere oltre
    // il . nel caso se sono numeri con la virgola fino allo spazio successivo!
    private void parseData(String s, String type, int i){       
        String[] tokens = s.split(",");
        if(this.listReq.equals("Restaurant")){           
                    this.data.get(i).add(new Dish(tokens[0], 
                            Double.parseDouble(tokens[1]),
                            Integer.parseInt(tokens[2].replaceAll("\\D+", "")), type));
        } 
        else if(this.listReq.equals("Library")){           
            this.data.get(i).add(new Book(tokens[0], 
                            tokens[1], Double.parseDouble(tokens[2]),
                            Integer.parseInt(tokens[3].replaceAll("\\D+", "")), 
                            Integer.parseInt(tokens[4].replaceAll("\\D+", "")), 
                            type, Integer.parseInt(tokens[5].replaceAll("\\D+", ""))));
        }
        else if(this.listReq.equals("Shop")){
            this.data.get(i).add(new Item(tokens[0], 
                    Double.parseDouble(tokens[1]), 
                    Integer.parseInt(tokens[2].replaceAll("\\D+", ""))));
        }
        else if(this.listReq.equals("Archive")){
            Person p;
            if(type.equals("Staff")){
                Staff person = new Staff(tokens[0], 
                        tokens[1], 
                        Integer.parseInt(tokens[2].replaceAll("\\D+", "")));
                p = (Person)person;
            }else{
                Customer person = new Customer(tokens[0], 
                        tokens[1], Double.parseDouble(tokens[2]), 
                        Integer.parseInt(tokens[3].replaceAll("\\D+", "")), this.aD);
                p = (Person)person;
            }
            this.accounts.add(p);
        }
    }
}
