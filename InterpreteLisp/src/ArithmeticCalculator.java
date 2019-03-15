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

    public Double calculate(List<Object> prefixList){
        
        Stack<Double> result = new Stack<>();
        
        String value = "";
        
        String signo = String.valueOf(prefixList.get(0));
        

        for (int i = 1; i < prefixList.size(); i++){
            if(prefixList.get(i) instanceof Integer || prefixList.get(i) instanceof Double ){
                value = "" + prefixList.get(i); 
                result.push(Double.parseDouble(value));
                    }
                    
                    else if(prefixList.get(i) instanceof ArrayList){
                        result.push(calculate((List)prefixList.get(i)));
                    }
        }
        
        if(signo.matches("[+]")){
            result.push(sumar(result));
        }
        if(signo.matches("[-]")){
            result.push(restar(result));
        }
        if(signo.matches("[*]")){
            result.push(multiplicar(result));
        }
        if(signo.matches("[/]")){
            result.push(dividir(result));
        }
        
        return result.peek();
    }

    public double sumar(Stack<Double> value){
        
        double res = 0.00;
        int lenstack = value.size();
        for(int control = 0; control<lenstack;control++){
            res += value.pop();
        }
        return res;
    }

    public double restar(Stack<Double> value){
        
        Stack<Double> temp_stack = revertStack(value);
        
        double res = temp_stack.pop();
        int lenstack = temp_stack.size();
        
        for(int control = 0; control<lenstack;control++){
            res -= temp_stack.pop();
        }
        return res;
    }

    public double multiplicar(Stack<Double> value){
        double res = value.pop();
        int lenstack = value.size();
        for(int control = 0; control<lenstack;control++){
            res *= value.pop();
        }        
        return res;
    }

    public double dividir(Stack<Double> value){
        
        Stack<Double> temp_stack = revertStack(value);
        
        double res = temp_stack.pop();
        int lenstack = temp_stack.size();
        
        for(int control = 0; control<lenstack;control++){
            res /= temp_stack.pop();
        }
        
        return res;
    }
    
    public Stack<Double> revertStack(Stack<Double> value){
        Stack<Double> temp_stack = new Stack();
        while(!value.empty()){
            temp_stack.add((double)value.pop());
        }
        
        return temp_stack;
    } 
}
