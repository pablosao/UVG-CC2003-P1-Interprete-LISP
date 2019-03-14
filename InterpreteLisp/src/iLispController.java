/**
 * Interfaz para el controlador de LISP
 * @author pablo
 * @version 01/03/2019
 */
public interface iLispController {
       
    
    void put(Object key,Object valores);
    
    Object get(Object expresion);
    
    boolean contieneKey(Object key);
    
}
