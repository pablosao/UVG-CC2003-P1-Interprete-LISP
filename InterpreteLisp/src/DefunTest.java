import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefunTest {

    @Test
    public void executeInstructions() {
        List instructions = new ArrayList();
        instructions.add("/");
        List subList = new ArrayList();
        subList.add("-");
        subList.add("n");
        subList.add(1.8);
        instructions.add(subList);
        instructions.add("n");
        List variables = new ArrayList();
        variables.add("n");
        Defun defun = new Defun("cuadrado", variables, instructions);
        List variables2 = new ArrayList();
        int cons = 2;
        variables2.add(cons);
        instructions = defun.executeInstructions(variables2);

        List expected = new ArrayList();


        expected.add("*");
        expected.add(cons);
        expected.add(cons);

        System.out.println(instructions);
        System.out.println(expected);

        assertEquals(instructions, expected);
    }
}