
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
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
public class DataManager {
    
    String PATH_FILE = "";
    
    
    
    public DataManager(){
        
    }
    
    /***
     * Constructor utilizado para setear el path del file
     * @param path path de la ruta del archivo
     */
    public void setPathFile(String path){
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
     * Retorna ArrayList con los tokens creados
     * @param delimitador delimitador para descomposición de tokens
     * @return Array con los tokens crados, según el delimitador
     */
    public List getTokens(String delimitador){
        
        return Collections.list(new StringTokenizer(getDataFile().replaceAll("\\(", " ( ").replaceAll("\\)", " ) ").trim(), delimitador)).stream()
        .map(token -> (String) token)
        .collect(Collectors.toList());
        
    }
    
    private Object getAtom(String token) {
        try {
            return Integer.parseInt(token);
	} 
        catch (NumberFormatException e) {
            try {
                return Float.parseFloat(token);
            } 
            catch (NumberFormatException e2) {
                try {
                    return Double.parseDouble(token);
		} 
                catch (NumberFormatException e3) {
                    return token;
		}
            }
	}
    }
    
    
    public Object getInstruccion(List instruccion) throws Exception {
        
        if (instruccion.isEmpty()) {
            throw new IllegalArgumentException("unexpected EOF while reading");
	}
	
        String token = instruccion.remove(0).toString();

	if (token.equals("(")) {
            List<Object> atoms = new ArrayList<Object>(instruccion.size() - 1);
            while (!instruccion.get(0).equals(")")){
                atoms.add(getInstruccion(instruccion));
            }
            
            instruccion.remove(0);
            return atoms;
	} 
        else if (token.equals(")")) {
            throw new Exception("unexpected ')'");
	} 
        else {
            return getAtom(token);
	}
    }
}