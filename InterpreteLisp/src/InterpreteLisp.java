
import java.util.Map;
import java.util.TreeMap;


/**
 *
 * @author pablo
 * @version 03/02/2019
 */
public class InterpreteLisp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int opcion = 0;
        
        while(true){
            
            System.out.println("\n\t\tMenú");
            System.out.println("1) Ejecutar comando LISP");
            System.out.println("2) Salir");
            
            System.out.print("Ingrese la opción de archivo: ");
            opcion = Keyboard.readInt();
            
            switch(opcion){
                case 1:
                    String path = "";
                    System.out.print("Ingrese el Path del archivo: ");
                    path = Keyboard.readString();
                    FileManager archivo = new FileManager(path);

                    if(archivo.getExists()){
                        buildTree(archivo.getCaracterDataFile());
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
    
    /**
     * 
     * @param arrayChar
     * @return 
     */
    public static Map buildTree(char[] arrayChar){
        
        //Mapa temporal para separar 
        Map mapa = new TreeMap();
        
        //System.out.print(lisp);
        
        return mapa;
        
    }
    
    /**
     * 
     * @param instrucciones 
     */
    public static void runLisp(Map instrucciones){
        
    }
    
}
