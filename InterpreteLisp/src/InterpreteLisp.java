
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




/**
 * Programa pincipal desde el cual se ejecuta el interprete de LISP
 * @author pablo
 * @version 03/02/2019
 */
public class InterpreteLisp {
    
    final static String DELIMITADOR = "\n()";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int opcion = 0;
        
        try{
            while(true){

                System.out.println("\n\t\tMenú");
                System.out.println("1) Ejecutar comando LISP");
                System.out.println("2) Salir");

                System.out.print("Ingrese la opción: ");
                opcion = Keyboard.readInt();

                switch(opcion){
                    case 1:
                        String path = "";
                        System.out.print("Ingrese el Path del archivo: ");
                        path = Keyboard.readString();
                        FileManager archivo = new FileManager(path);

                        if(archivo.getExists()){
                            //buildTree(archivo.getCaracterDataFile());
                            runLisp(archivo.getTokens(DELIMITADOR));
                        }
                        else{
                            System.out.println(String.format("\n\t\tEl archivo de la ruta %s no fue encontrado", path));
                        }
                        break;
                    case 2:
                        System.exit(0);
                }
            
            }
        }
        catch(Exception e){
            System.out.println(String.format("\n\n\t\tOcurrio el problema: %s",e.toString()));
        }
        
    }
    
    /**
     * 
     * @param instrucciones 
     */
    public static void runLisp(List instrucciones){
        
        iLispController controlador = new LispController();
        if(controlador.verificaSintaxis(instrucciones.get(0).toString().replace(" ",""))){
            System.out.println("Sintaxis correcta");
        }
        else{
            System.out.println("Contiene simbolos no permitidos");
        }
        
        
        //Evaluamos si contiene instrucciones reservadas del sistema
    }
    
}
