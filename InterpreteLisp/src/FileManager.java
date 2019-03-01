
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pablo
 * @version 01/03/2019
 */
public class FileManager {
    
    public String getDataFile(String path){
        BufferedReader reader;
        String linea,datos = "";
        try{
            if((new File(path)).exists()){ //verificamos que el archivo exista
                
                
                reader = new BufferedReader(new FileReader(path));
                
                while((linea = reader.readLine()) != null){
                    //concatenamos con un tabular la lectura de la linea,
                    //el tabular se eliminara al separar las expresiones.
                    datos += linea;
                }
                
                reader.close();
            }
            else{
                System.out.println(String.format("El archivo no fue encontrado en la ruta: %s",path));
            }
            
        }
        //Tomaremos todo tipo de error en la ejecución del bloque de codigo dentro del catch
        catch(Exception e){
            e.printStackTrace();
        }
        
        return datos;
    }
}
