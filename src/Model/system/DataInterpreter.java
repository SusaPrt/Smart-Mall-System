/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.system;

import Model.administration.Customer;
import Model.administration.Item;
import Model.enterprises.restaurant.classes.Dish;
import Model.administration.Person;
import Model.administration.Staff;
import Model.enterprises.library.classes.Book;
import Model.enterprises.restaurant.classes.Course;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 *
 * @author Marzio
 */
public class DataInterpreter {
    private final DataWriter dataWriter;
    private final DataReader dataReader;
    private LinkedList<LinkedList> data;
    private LinkedList<Person> accounts;
    private String listReq;                    // riferimento all'oggetto chiamante per tipo di oggetti da mettere in lista
    
    public DataInterpreter(File f, String requirer) throws FileNotFoundException{
        this.dataReader = new DataReader(f);
        this.data = new LinkedList();
        this.accounts = new LinkedList();
        this.listReq = requirer;
        this.readData(this.dataReader.getRawData());
        this.dataWriter = new DataWriter(f, requirer);
    } 
    
    // Ritorna i dati ai relativi richiedenti    
    public LinkedList<LinkedList> getData(){
        return this.data;
    }
    
    // Le classi 'Customer' e 'Staff' essendo di natura diversa rispetto a
    // 'Dish', 'Book' e 'Item' vengono ritornati in un altra struttura
    public LinkedList<Person> getAccounts(){
        return this.accounts;
    }
    
    public DataWriter getDataWriter(){
        return this.dataWriter;
    }
    
    // Legge le stringhe che sono state lette da file dal DataReader
    private void readData(LinkedList<String> rawData){
        this.data.add(new LinkedList<Item>());
        String type = null;
        int i = 0;        
        for(String s: rawData){
            
            // Il simbolo '#' è utilizzato come carattere speciale per impostare 
            // il tipo di oggetto in lettura
            if(s.contains("#")){     
                type = s.substring(1);  
                // La classe 'Restaurant' si aspetta una collezione di piatti
                // divisi per portata, con la seguente condizione si implementa
                // la suddivisione richiesta popolando i 'FIRSTS' sulla posizione
                // '0', i 'SECONDS' sulla posizione 1 e così via
                if(!type.equals("FIRSTS") && this.listReq.equals("Restaurant")){
                   this.data.add(new LinkedList<Item>());
                   i++;
                }
                // La classe 'Library' deve caricare da file due classi molto 
                // diverse: 'Book' e 'Loan', con questa condizione gli oggetti
                // 'Book' verranno messi sulla posizione '0' mentre i 'Loan'
                // sulla posizione 1
                else if(type.equals("Loans") && !this.listReq.equals("Loans")){
                    this.data.add(new LinkedList<String[]>());
                    
                    // L'indice 'i' deve incrementare solo una volta, di modo che 
                    // tutti i 'Loan' vengano posizinati sulla stessa LinkedList
                    this.listReq = "Loans";
                    i++;
                }
            }else{
                parseData(s, type, i);
            }              
        }
    }
    
    // Metodo privato che traduce le stringhe prese da file mediante il DataReader
    // negli oggetti richiesti, il riconoscimento del tipo richiesto è assunto
    // mediante la stringa 'listReq' popolata alla creazione del DataInterpreter
    // "\\D+ serve per far riconoscere i numeri float da stringhe, regola la presa dei numeri forzandoli a vedere oltre
    // il . nel caso se sono numeri con la virgola fino allo spazio successivo
    private void parseData(String s, String type, int i){  
        // La stringa parametro viene divisa su ogni ricorrenza del carattere ','
        String[] tokens = s.split(",");
        if(this.listReq.equals("Restaurant")){           
                    this.data.get(i).add(new Dish(tokens[0], 
                            Double.parseDouble(tokens[1]),
                            Integer.parseInt(tokens[2].replaceAll("\\D+", "")),
                            Course.selectType(type)));
        } 
        else if(this.listReq.equals("Library") && i == 0){           
            this.data.get(i).add(new Book(tokens[0], 
                            tokens[1], Double.parseDouble(tokens[2]),
                            Integer.parseInt(tokens[3].replaceAll("\\D+", "")), 
                            Integer.parseInt(tokens[4].replaceAll("\\D+", "")), 
                            type, Integer.parseInt(tokens[5].replaceAll("\\D+", ""))));
        }
        else if(this.listReq.equals("Loans")){
            this.data.get(i).add(tokens);
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
                        Integer.parseInt(tokens[3].replaceAll("\\D+", "")));
                p = (Person)person;
            }
            this.accounts.add(p);
        }
    }
}
