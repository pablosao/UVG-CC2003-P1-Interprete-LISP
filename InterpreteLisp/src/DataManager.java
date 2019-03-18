
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Clase para el manejo de archivo e información
 * @author Pablo Sao
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
    
    /**
     * Metodo para Conversión de String al valor en su tipo de dato.
     * @param token string del token 
     * @return Objeto con el tipo nativo del valor
     */
    private Object getAtom(String token) {
        try {
            //Si es entero, retornamos el valor en tipo int
            return Integer.parseInt(token);
	} 
        catch (NumberFormatException e) {
            try {
                //Si es flotante, se convierte el string a Float
                return Float.parseFloat(token);
            } 
            catch (NumberFormatException e2) {
                try {
                    //Si es un double, se convierte el string a decimal
                    return Double.parseDouble(token);
		} 
                catch (NumberFormatException e3) {
                    //Si no es numerico, se retorna el token original en un tipo string
                    return token;
		}
            }
	}
    }
    
    /**
     * Metodo para obtener el parseo en forma de arreglos del lenguaje LISP
     * @param instruccion Estructura del lenguaje LISP dentro de una lista
     * @return Objeto que contiene una lista con el arreglo del lenguaje LISP
     * @throws Exception 
     */
    public Object getInstruccion(List instruccion) throws Exception {
        
        
        
        //Verificamos si la lista esta vacía.
        if (instruccion.isEmpty()) {
            throw new IllegalArgumentException("Valor incongruente. La instrucción es invalida.");
	}
	
        //Obtenemos el primer valor de la lista y la almacenamos en una variable
        String token = instruccion.remove(0).toString();
        
        //Verificamos si el primer valor es ( para realizar el armado de un subarreglo
	if (token.equals("(")) {
            
            //Creamos un ArrayList de tipo objeto con el tamaño de la lista 
            List<Object> tempList = new ArrayList<Object>(instruccion.size() - 1);
            try{
                

                //Loop para llenar el subarreglo hasta encontrar )
                while (!instruccion.get(0).equals(")")){
                    //recursión para el llenado del sub arreblo
                    tempList.add(getInstruccion(instruccion));
                }

                //removemos el primer valor de la instrucción
                instruccion.remove(0);


                if(instruccion.get(0).equals("(") && instruccion.size() > 1){
                    getInstruccion(instruccion);
                }
                
                //resultado.add(tempList);
                //Retornamos el sub arreglo para almacenarlo en la lista.
                return tempList;
            }
            catch(Exception e){
                return tempList;
            }
            
	} 
        else if (token.equals(")")) {
            throw new Exception("Inconsistencia al encontrar ')' dentro de la instrucción.");
	} 
        else {
            //retornamos el valor con su estructura de datos para almacenarlo en el arreglo
            return getAtom(token);
	}
        
    }
    
    //
    public List<Object> getListInstruccion(){
        String tempInstruction = "";
        char[] caracteres = (getDataFile().replace("\n","")+"\n").toCharArray();
        
        List<Object> listas = new ArrayList<Object>();
        
        for(int control = 0; control < caracteres.length;control++){
            //System.out.println(caracteres[control]);
            
            if(caracteres[control] == ')'){
                tempInstruction += caracteres[control];
                
                if(control < (caracteres.length - 2)){
                   if(caracteres[control + 1] == '('){
                       listas.add(tempInstruction);
                        tempInstruction = "";
                   }
                }
                
            }
            else if(caracteres[control] == '\n'){
                listas.add(tempInstruction);
                tempInstruction = "";
            }
            else{
                tempInstruction += caracteres[control];
            }
             
            
        }
        
        return listas;
    }
    
}