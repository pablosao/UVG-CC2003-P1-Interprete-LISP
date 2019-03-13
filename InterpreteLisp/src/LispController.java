
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public List getInstruccion(List instruccion) {
        List seccion = new ArrayList();
        String registro = "";
        
        //Obtenemos el primer registro de la cadena
        registro = instruccion.get(0).toString();
        
        //eliminamos el registro obtenido
        instruccion.remove(0);
        
        //Verificamos si es el inicio de una instruccion
        if(registro.equals("(")){
           
            //Asignamos el nuevo registro a evaluar
            registro = instruccion.get(0).toString();
            
            
            
        }
//        
//        String registro = instruccion.get(0).toString();
//                
//        if(registro.equals("(") ){
//            instruccion.remove(0);
//            while(!registro.equals(")")){
//                try{
//                    registro = instruccion.get(0).toString();
//                    seccion.add(Integer.parseInt(registro));
//                }
//                catch(NumberFormatException e){
//                    seccion.add(registro);
//                }
//                catch(Exception e){}
//                finally{
//                    instruccion.remove(0);
//                    getInstruccion(instruccion);
//                }
//            }
//        }
//        else if (registro.equals(")")){
//            //
//            throw new UnsupportedOperationException("Se encontro un operador no valido.");
//        }
        
        return seccion;
    }

    
    
    
}
