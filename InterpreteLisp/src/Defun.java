import javax.naming.NamingEnumeration;
import java.util.HashMap;
import java.util.List;

public class Defun {

    private String funName = "";
    private HashMap<String, Object> variables = new HashMap<>();
    private List<Object> instructions;

    public Defun(String funName, List<String> variables, List instructions){
        this.funName = funName;
        for (String item: variables){
            this.variables.put(item, null);
        }
        this.instructions = instructions;
    }

    public List executeInstructions(List variables){
        List tempInstructions = this.instructions;
        HashMap<String, Object> tempVariables = this.variables;
        //System.out.println(tempInstructions);
        if (variables.size() == tempVariables.size()){//verifica si la lista es del tamaño necesario para ejecutar la funcion
            int i = 0;
            for (String key: tempVariables.keySet()) {
                tempVariables.replace(key, variables.get(i));
                i++;
            }
            //System.out.println(tempInstructions);
            i = 0;
            while (i < tempInstructions.size()){
                if ((tempInstructions.get(i) instanceof String)){
                    for (String key: tempVariables.keySet()) {
                        if (tempInstructions.get(i).equals(key)){
                            tempInstructions.add(i, tempVariables.get(key));
                            tempInstructions.remove(i + 1);
                        }
                    }
                }
                i++;
            }

            return instructions;

        } else {//Si la cantidad de variables es menor no se ejecutara el codigo.

        }

        return instructions;
    }

}

