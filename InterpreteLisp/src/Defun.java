import java.util.List;

public class Defun {

    private String funName = "";
    private Integer variables;
    private List<Object> instructions;

    public Defun(String funName, List variables, List instructions){
        this.funName = funName;
        this.variables = variables.size();
        this.instructions = instructions;
    }

    public void executeInstructions(List variables){
        if (variables.size() == this.variables){//verifica si la lista es del tamaño necesario para ejecutar la funcion
            
        } else {//Si la cantidad de variables es menor no se ejecutara el codigo.
            return;
        }
    }

}
