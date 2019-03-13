
import java.util.List;




/**
 * Programa pincipal desde el cual se ejecuta el interprete de LISP
 * @author pablo
 * @version 03/02/2019
 */
public class InterpreteLisp {
    
    final static String DELIMITADOR = " \t\n\r\f";
    
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
                        DataManager archivo = new DataManager();
                        archivo.setPathFile(path);

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
        System.out.println(controlador.getInstruccion(instrucciones));
        
//        iLispController controlador = new LispController();
//        try{
//            System.out.println(controlador.getInstruccion(instrucciones));
//        }
//        catch(Exception e){
//            System.out.println(e.toString());
//        }
        
        //Evaluamos si contiene instrucciones reservadas del sistema
    }
    
}
