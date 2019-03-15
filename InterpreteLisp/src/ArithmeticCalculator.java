import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Clase que realiza las operaciones aritmeticas
 * @author Juanfer De Leon
 *
 */
public class ArithmeticCalculator {

    private Stack<Double> result = new Stack<>();

    public Double calculate(List<Object> prefixList){

        String value = "";
        
        String signo = String.valueOf(prefixList.get(0));
        

        for (int i = 1; i < prefixList.size(); i++){
            //if (prefixList.get(i) instanceof String){
                //if (String.valueOf(prefixList.get(i)).matches("[+]")){//Suma
                if (signo.matches("[+]")){//Suma
                    
                    if(prefixList.get(i) instanceof Integer || prefixList.get(i) instanceof Double ){
                        value = "" + prefixList.get(i); 
                        result.push(Double.parseDouble(value));
                    }
                    
                    else if(prefixList.get(i) instanceof ArrayList){
                        calculate((List)prefixList.get(i));
                    }
                    
                    
//                    if (prefixList.get(i + 1) instanceof Integer){
//                        value = "" + prefixList.get(i + 1); 
//                        result.push(Double.parseDouble(value));
//                        
//                        if (prefixList.get(i + 2) instanceof ArrayList){ 
//                            calculate((List)prefixList.get(i + 2));
//                        } else if (prefixList.get(i + 2) instanceof Integer){
//                            value = "" + prefixList.get(i + 2);
//                            result.push(Double.parseDouble(value));
//                        }
//                    }
//                    result.push(sumar());
                    
                }

                //if (String.valueOf(prefixList.get(i)).matches("[-]")){//Resta
                if (signo.matches("[-]")){//Resta
                    if (prefixList.get(i + 1) instanceof Integer){
                        value = "" + prefixList.get(i + 1);
                        result.push(Double.parseDouble(value));
                        if (prefixList.get(i + 2) instanceof ArrayList){
                            calculate((List)prefixList.get(i + 2));
                        } else if (prefixList.get(i + 2) instanceof Integer){
                            value = "" + prefixList.get(i + 2);
                            result.push(Double.parseDouble(value));
                        }
                    }
                    
                    result.push(restar());
                    
                }

                //if (String.valueOf(prefixList.get(i)).matches("[*]")){//Multiplicar
                if (signo.matches("[*]")){//Multiplicar
                    if (prefixList.get(i + 1) instanceof Integer){
                        value = "" + prefixList.get(i + 1);
                        result.push(Double.parseDouble(value));
                        if (prefixList.get(i + 2) instanceof ArrayList){
                            calculate((List)prefixList.get(i + 2));
                        } else if (prefixList.get(i + 2) instanceof Integer){
                            value = "" + prefixList.get(i + 2);
                            result.push(Double.parseDouble(value));
                            
                        }
                    }
                    result.push(multiplicar());
                }

                //if (String.valueOf(prefixList.get(i)).matches("[/]")){//Dividir
                if (signo.matches("[/]")){//Dividir
                    if (prefixList.get(i + 1) instanceof Integer){
                        value = "" + prefixList.get(i + 1);
                        result.push(Double.parseDouble(value));
                        if (prefixList.get(i + 2) instanceof ArrayList){
                            calculate((List)prefixList.get(i + 2));
                        } else if (prefixList.get(i + 2) instanceof Integer){
                            value = "" + prefixList.get(i + 2);
                            result.push(Double.parseDouble(value));
                        }
                    }
                    result.push(dividir());
                }

                //i += 2;
            //}
       
        }
        
        if(signo.matches("[+]"))
                result.push(sumar());
        
        return this.result.peek();
    }

    public double sumar(){
        
        double res = 0.00;
        int lenstack = result.size();
        for(int control = 0; control<lenstack;control++){
            res += result.pop();
        }
//        double a = result.pop();
//        double b = result.pop();
        //return a + b;
        
        return res;
    }

    public double restar(){
        double a = result.pop();
        double b = result.pop();
        return b - a;
    }

    public double multiplicar(){
        double a = result.pop();
        double b = result.pop();
        return a * b;
    }

    public double dividir(){
        double a = result.pop();
        double b = result.pop();
        return (b/a);
    }

}
