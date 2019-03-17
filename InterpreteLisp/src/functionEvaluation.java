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

    public List<Object> toList(List<Object> values){
        return values;
    }

    public boolean isEqual(Object a, Object b){
        return a.equals(b);
    }
    
}
