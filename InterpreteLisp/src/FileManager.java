
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 *
 * @author pablo
 * @version 01/03/2019
 */
public class FileManager {
    
    String PATH_FILE = "";
    final String DELIMITADOR = " \t\n\r\f";
    
    /***
     * Constructor utilizado para setear el path del file
     * @param path path de la ruta del archivo
     */
    public FileManager(String path){
        PATH_FILE = path;
    }
    
    /***
     * Metodo para la obtención del contenido de un archivo
     * @param path ruta fisica del archivo
     * @return string con los datos del archivo
     */
    public String getDataFile(){
        BufferedReader reader;
        String linea,datos = "";
        
        try{
            reader = new BufferedReader(new FileReader(PATH_FILE));
                
            while((linea = reader.readLine()) != null){
                //concatenamos con un tabular la lectura de la linea,
                //el tabular se eliminara al separar las expresiones.
                datos += linea + "\n";
            }
            
            // Cerramos la conexion
            reader.close();
            
        }
        //Tomaremos todo tipo de error en la ejecución del bloque de codigo dentro del catch
        catch(Exception e){
            e.printStackTrace();
        }
        
        return datos;
    }
    
    /***
     * Metodo para verificar la existencia del archivo ingresado
     * @return true si el archivo existe, false si el archivo no existe
     */
    public boolean getExists(){
        return (new File(PATH_FILE)).exists();
    }
    
    
    /**
     * Retorna un arreglo con cada caracter del string enviado
     * @param datos String para separar en caracteres
     * @return array de caracteres
     */
    public char[] getCaracterDataFile(String datos){
        String tempData = getDataFile();
        return tempData.toCharArray();
    }
    
    /**
     * Retorna ArrayList con los tokens creados
     * @param parser string a descomponer en tokens
     * @param delimitador delimitador para descomposición de tokens
     * @return Array con los tokens crados, según el delimitador
     */
    public List getTokens(String delimitador){
        
//        //Se crea array para almacenar los tokens
//        List datos = new ArrayList();
//        
//        //Se crean los tokens según el delimitador enviado
//        StringTokenizer token = new StringTokenizer(getDataFile(), delimitador);
//        
//        while(token.hasMoreTokens()){
//            //agregamos al array todos los tokens creados a partir del delimitador
//            datos.add(token.nextToken());
//        }
//        
//        return datos;
        
        return Collections.list(new StringTokenizer(getDataFile(), delimitador)).stream()
        .map(token -> (String) token)
        .collect(Collectors.toList());
        
    }
    
}