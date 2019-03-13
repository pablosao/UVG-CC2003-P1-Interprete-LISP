
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
        
        List parser = new ArrayList();
        
        String valor = instruccion.get(0).toString();
        
        if(valor.equals("(")){
            instruccion.remove(0);
            valor = instruccion.get(0).toString();
        }
        
        
        while(!instruccion.get(0).toString().equals(")")){
            
            if(valor.equals("(")){
                
                instruccion.remove(0);
                
                List temp = new ArrayList();
                while(!instruccion.get(0).toString().equals(")")){
                    temp.add(instruccion.get(0).toString());
                    instruccion.remove(0);
                }
                parser.add(temp);
                instruccion.remove(0);
            }
            else{
                parser.add(instruccion.get(0).toString());
                instruccion.remove(0);
            }
            
            valor = instruccion.get(0).toString();
            
        }
        
               
        
        return parser;
    }

    
    
    
}
