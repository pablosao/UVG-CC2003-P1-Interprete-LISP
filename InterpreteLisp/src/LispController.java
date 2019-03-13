/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pablo
 */
public class LispController implements iLispController{
    
    final char[] SIMBOLOS_PERMITIDOS = {
             '+'
            ,'-'
            ,'*'
            ,'/'
    };
    
    final String[] PALABRAS_RESERVADAS = {
             "DEFUN"
            ,"ATOM"
            ,"LIST"
            ,"EQUAL"
            
    };
    
    @Override
    public void operacion(String operador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificaSintaxis(String instruccion) {
        boolean isOK = false;
        FileManager archivo = new FileManager("");
        
        
        for(int control = 0;control<SIMBOLOS_PERMITIDOS.length;control++){
            isOK = archivo.contieneChar(instruccion, SIMBOLOS_PERMITIDOS[control]);
        }
        
        return isOK;
    }
    
}
