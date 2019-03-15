import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Realización de calculos aritmeticos recursivos
 * @Modifico Pablo Sao
 * @version: 1503/2019
 */
/**
 * Clase que realiza las operaciones aritmeticas
 * @author Juanfer De Leon
 *
 */
public class ArithmeticCalculator {

    /**
     * Retorna el resultado del calculo de la expresión aritmetica
     * @param prefixList Lista con las instrucciones de list
     * @return valor resultante de la evaluación
     */
    public Double calculate(List<Object> prefixList){
        
        Stack<Double> result = new Stack<>();
        
        String signo = String.valueOf(prefixList.get(0));
        
        for (int i = 1; i < prefixList.size(); i++){
            //Verificamos si el registro dentro de la lista es entero o double
            if(prefixList.get(i) instanceof Integer || prefixList.get(i) instanceof Double ){
                //ingresamos el digito al stack
                result.push(Double.parseDouble(prefixList.get(i).toString()));
            }
            //evaluamos si el valor de la lista es un arraylist
            else if(prefixList.get(i) instanceof ArrayList){
                //Se realiza calculo recursivo de la lista y se guarda el resultado en el stack
                result.push(calculate((List)prefixList.get(i)));
            }
        }
        
        //Evaluamos la operación aritmetica a realizar
        
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
    
    /**
     * Operación de suma
     * @param value Stack para realizar calculo
     * @return valor calculado
     */
    public double sumar(Stack<Double> value){
        
        double res = 0.00;
        int lenstack = value.size();
        for(int control = 0; control<lenstack;control++){
            res += value.pop();
        }
        return res;
    }
    
    /**
     * Operación de resta
     * @param value Stack para realizar calculo
     * @return valor calculado
     */
    public double restar(Stack<Double> value){
        //Volteamos Stack
        Stack<Double> temp_stack = revertStack(value);
        //colocamos el ultimo dato del stack como valor inicial
        double res = temp_stack.pop();
        int lenstack = temp_stack.size();
        
        for(int control = 0; control<lenstack;control++){
            res -= temp_stack.pop();
        }
        return res;
    }
    
    /**
     * Operación de multiplicación
     * @param value Stack para realizar cálculo
     * @return valor calculado
     */
    public double multiplicar(Stack<Double> value){
        //colocamos el ultimo dato del stack como valor inicial
        double res = value.pop();
        int lenstack = value.size();
        for(int control = 0; control<lenstack;control++){
            res *= value.pop();
        }        
        return res;
    }
    
    /**
     * Operación de dividir
     * @param value Stack para realizar calculo
     * @return valor calculado
     */
    public double dividir(Stack<Double> value){
        //Volteamos Stack
        Stack<Double> temp_stack = revertStack(value);
        //colocamos el ultimo dato del stack como valor inicial
        double res = temp_stack.pop();
        int lenstack = temp_stack.size();
        
        for(int control = 0; control<lenstack;control++){
            res /= temp_stack.pop();
        }
        
        return res;
    }
    
    /**
     * Metodo para revertir el orden de la lista
     * @param value Stack<Double> a revertir
     * @return stack con nuevo orden
     */
    public Stack<Double> revertStack(Stack<Double> value){
        Stack<Double> temp_stack = new Stack();
        while(!value.empty()){
            temp_stack.add((double)value.pop());
        }
        
        return temp_stack;
    } 
}
