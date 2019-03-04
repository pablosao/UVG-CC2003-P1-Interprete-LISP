
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
            
            System.out.println("\t\tMenú");
            System.out.println("1) Ejecutar comando LISP");
            System.out.println("2) Salir");
            opcion = Keyboard.readInt();
            
            switch(opcion){
                case 1:
                    runLisp();
                case 2:
                    System.exit(0);
            }
        }
        
    }
    
    /**
     * Método para realizar la ejecución la instrucción LISP
     */
    public static void runLisp(){
        String path = "";
        System.out.println("Ingrese el Path del archivo: ");
        
        path = Keyboard.readString();
        FileManager archivo = new FileManager(path);
        
        if(archivo.getExists()){
            System.out.println(archivo.getDataFile());
        }
        else{
            System.out.println(String.format("\n\t\tEl archivo de la ruta %s no fue encontrado", path));
        }
        
        
    }
    
}
