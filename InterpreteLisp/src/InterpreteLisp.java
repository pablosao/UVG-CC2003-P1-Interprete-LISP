
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
        
        FileManager archivo = new FileManager();
        
        System.out.println(archivo.getDataFile("C:\\dato.txt"));
    }
    
}
