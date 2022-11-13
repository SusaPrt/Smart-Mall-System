/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Marzio
 */
public class DataReader {
    private Scanner sc;
    private LinkedList<String> rawData;
    
    public DataReader(File f) throws FileNotFoundException{
        this.rawData = new LinkedList<>();
        this.sc = new Scanner(f);
    }
    
    // Legge il file aperto in lettura riga per riga e ritorna la LinkedList di
    // stringhe al DataInterpreter chiamante
    public LinkedList<String> getRawData(){
        String line;
        while (sc.hasNextLine()){                        
            line = sc.nextLine();            
            if(!line.equals(""))
                this.rawData.add(line);        
        }
        return this.rawData;
    }    
}
