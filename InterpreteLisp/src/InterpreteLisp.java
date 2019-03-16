
import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.stream.Collectors;




/**
 * Programa pincipal desde el cual se ejecuta el interprete de LISP
 * @author pablo
 * @version 03/02/2019
 */
public class InterpreteLisp {
    
    final static String DELIMITADOR = " \t\n\r\f";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int opcion = 0;
        
        try{
            while(true){

                System.out.println("\n\t\tMenú");
                System.out.println("1) Ejecutar comando LISP");
                System.out.println("2) Salir");

                System.out.print("Ingrese la opción: ");
                //Realizamos la lectura de la terminal con la ayuda de la clase Keyboard
                opcion = Keyboard.readInt();

                switch(opcion){
                    case 1:
                        //Realizamos la solicitud del path del archivo a leer
                        String path = "";
                        System.out.print("Ingrese el Path del archivo: ");
                        
                        //Leemos el path con la ayuda de la clase Keyboard
                        path = Keyboard.readString();
                        
                        //Creamos un objeto del manejador de datos
                        DataManager archivo = new DataManager();
                        
                        //Seteamos el path del archivo en el objeto
                        archivo.setPathFile(path);
                        
                        //Verificamos que exista el archivo
                        if(archivo.getExists()){
                            //Mediante el objeto instanciado, obtenemos los tokens y parseo de la instruccion en lisp
                            runLisp(archivo.getInstruccion(archivo.getTokens(DELIMITADOR)));
                        }
                        else{
                            System.out.println(String.format("\n\t\tEl archivo de la ruta %s no fue encontrado", path));
                        }
                        break;
                    case 2:
                        //Salimos del programa
                        System.exit(0);
                }
            
            }
        }
        catch(Exception e){
            System.out.println(String.format("\n\n\t\tOcurrio el problema: %s",e.toString()));
        }
        
    }
    
    /**
     * Método para ejecutar la instrucción de LISP
     * @param value objeto con las instrucciones de LISP
     */
    public static void runLisp(Object value) throws Exception{
        try{
            //Casteamos el objeto a tipo List y lo asignamos auna variable List
            List instruccion = (List)value;

            //Evaluar sintaxis

            //Al cumplir con la evaluación de la sintaxis mostramos que instrucción se evaluara
            System.out.println(String.format( "\n\n\t\tExpresión a Evaluar: %s",(String) instruccion.stream()
                                .map(n -> String.valueOf(n))
                                .collect(Collectors.joining(" ", "(", ")")))
                                .replace(",", " ")
                                .replace("[", "(")
                                .replace("]", ")"));

            //Verificamos si contiene la instrucción ATOM
            if(instruccion.contains("atom")){
                
                //Si el tamaño es de 2, la sintaxis de LISP para atom es correcta
                if(instruccion.size() == 2 ){
                    //System.out.println("Ejecuta atom");
                    if( (new functionEvaluation()).isAtom(instruccion.get(1))){
                        System.out.print("\n\t\tResultado: True\n\n");
                    }
                    else{
                        System.out.print("\n\t\tResultado: NIL\n\n");
                    }
                }
                //de lo contrario salimos de la ejecucion de LISP
                else{
                    System.out.println("La función de atom tiene erroes de sintaxis");
                }
            }
            else if(instruccion.contains("defun")){

            }
            else{
                ArithmeticCalculator calculator = new ArithmeticCalculator();
                System.out.println("\n\t\tResultado: " + calculator.calculate(instruccion));
                //Despliegue temporal del parseo de las instrucciones
            }
        
        }
        catch(Exception e){
            System.out.println("\n\n\tOcurrio un problema al evaluar la expreción. \n\tError: " + e.toString());
        }
    }
}
