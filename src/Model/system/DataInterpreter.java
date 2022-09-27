/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.system;

import Model.administration.Item;
import Model.enterprises.restaurant.Dish;
import Model.enterprises.library.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 *
 * @author Mars_DB
 */
public class DataInterpreter {
    private DataReader dR;
    private LinkedList<LinkedList> data;
    private String listReq;                    // riferimento all'oggetto chiamante per tipo di oggetti da mettere in lista
    
    public DataInterpreter(File f, String requirer) throws FileNotFoundException{
        this.dR = new DataReader(f);
        this.data = new LinkedList<>();
        this.listReq = requirer;
        readData(this.dR.getRawData());
    }
    
    private void readData(LinkedList<String> rawData){
        this.data.add(new LinkedList<Item>());
        String type = null;
        int i = 0;        
        for(String s: rawData){
            if(s.contains("#")){     
                type = s.substring(1);
                this.data.add(new LinkedList<Item>());
                i++;
            }else{
                    parseData(s, type, i);
            }              
        }
    } 
        
    public LinkedList<LinkedList> getData(){
        return this.data;
    }
    
    private void parseData(String s, String type, int i){       
        String[] tokens = s.split(",");
        if(this.listReq.equals("Restourant")){           
                    this.data.get(i).add(new Dish(tokens[0], 
                            Double.parseDouble(tokens[1].replaceAll("\\D+", "")),
                            Integer.parseInt(tokens[2].replaceAll("\\D+", "")), type));
        }              
        else if(this.listReq.equals("Library")){           
            this.data.get(i).add(new Book(tokens[0], 
                            tokens[1], Double.parseDouble(tokens[2].replaceAll("\\D+", "")),
                            Integer.parseInt(tokens[3].replaceAll("\\D+", "")), 
                            Integer.parseInt(tokens[4].replaceAll("\\D+", "")), type));
        }
        else if(this.listReq.equals("Shop")){
            this.data.get(i).add(new Item(tokens[0], 
                    Double.parseDouble(tokens[2].replaceAll("\\D+", "")), 
                    Integer.parseInt(tokens[3].replaceAll("\\D+", ""))));
        }
    }
}
