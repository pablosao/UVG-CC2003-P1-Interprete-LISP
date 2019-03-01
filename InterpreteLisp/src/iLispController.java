

/**
 * Interfaz para el controlador de LISP
 * @author pablo
 * @version 01/03/2019
 */
public interface iLispController {
    
    void operacion(String operador);
    
    /**
     * Metodo para verificar la sintaxis del documento
     * @param instruccion 
     */
    void verificaSintaxis(String instruccion);
    
}
