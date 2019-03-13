
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
    public boolean verificaSinbolos(String instruccion) {
        boolean isOK = false;
        DataManager archivo = new DataManager();
        
        
        for(int control = 0;control<SIMBOLOS_PERMITIDOS.length;control++){
            isOK = archivo.contieneChar(instruccion, SIMBOLOS_PERMITIDOS[control]);
        }
        
        return isOK;
    }
    

    @Override
    public List getInstruccion(List instruccion) {
        List seccion = new ArrayList();
        
        String registro = instruccion.get(0).toString();
                
        if(registro.equals("(") ){
            instruccion.remove(0);
            while(!registro.equals(")")){
                try{
                    registro = instruccion.get(0).toString();
                    seccion.add(Integer.parseInt(registro));
                }
                catch(NumberFormatException e){
                    seccion.add(registro);
                }
                catch(Exception e){}
                finally{
                    instruccion.remove(0);
                    getInstruccion(instruccion);
                }
            }
        }
        else if (registro.equals(")")){
            //
            throw new UnsupportedOperationException("Se encontro un operador no valido.");
        }
        
        return seccion;
    }

    
    
    
}
