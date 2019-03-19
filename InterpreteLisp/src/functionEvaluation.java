import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para el manejo de evaluaciones
 * @author Pablo Sao
 * @version 15/03/2018
 */
public class functionEvaluation {
    
    /**
     * Metodo para verificar el atom del objeto pasado, según la sintaxis de LISP
     * @param value dato para evaluar si cumple con la condición de LISP
     * @return verdadero si cumple, falso de no ser así
     */
    public boolean isAtom(Object value){
        try {
            //Si es entero, retornamos el valor en tipo int
            if((Integer)Integer.parseInt(value.toString()) instanceof Integer){
                return true;
            }
	} 
        catch (NumberFormatException e) {
            try {
                //Si es flotante, se convierte el string a Float
                if((Float)Float.parseFloat(value.toString()) instanceof Float){
                    return true;
                }
            } 
            catch (NumberFormatException e2) {
                try {
                    //Si es un double, se convierte el string a decimal
                    if((Double)Double.parseDouble(value.toString()) instanceof Double){
                        return true;
                    }
		} 
                catch (NumberFormatException e3) {
                    //Si no es numerico, se retorna el token original en un tipo string
                    try{
                        String valor = value.toString();
                        if(valor instanceof String){
                            if(Character.toString(valor.charAt(0)).equals("'")){
                                return true;
                            }
                            //Si no cumple con la sintaxis retorna falso
                            return false;
                        }
                    }
                    catch(Exception e4){
                        return false;
                    }
		}
            }
	}
        return false;
    }

    /**
     * Metodo para hacer una lista
     * @param values  lista que sera devuelta por el metodo
     * @return
     */
    public List<Object> toList(List<Object> values){
        return values;
    }

    /**
     * Metodo para comparar dos objetos
     * @param a
     * @param b
     * @return
     */
    public boolean isEqual(Object a, Object b){
        return a.equals(b);
    }

    public boolean isGreaterThan (Object a, Object b){
        return (Double.parseDouble(a.toString()) > Double.parseDouble(b.toString()));
    }

    public boolean isLessThan(Object a, Object b){
        return (Double.parseDouble(a.toString()) < Double.parseDouble(b.toString()));
    }

    public Object cond(List instructions){//Cond
        List subList = instructions.subList(1, instructions.size());
        List subList2 = (List) subList.get(0);
        int i = 0;
        for (Object inst: subList2) {
            List instruccion = (List)inst;
            if (instruccion.contains("equal")){
                if (isEqual(instruccion.get(1), instruccion.get(2))){
                    return instruccion.get(3);
                }
            } else if (instruccion.contains("<")){
                if (isLessThan(instruccion.get(1), instruccion.get(2))){
                    return instruccion.get(3);
                }
            } else if (instruccion.contains(">")){
                if (isGreaterThan(instruccion.get(1), instruccion.get(2))){
                    return instruccion.get(3);
                }
            } else if (i == subList2.size()){
                return subList2.get(i);
            }
            i++;
        }
        return null;
    }
    
}
