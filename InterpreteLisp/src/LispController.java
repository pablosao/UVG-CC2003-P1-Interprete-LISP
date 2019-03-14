
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Pablo Sao
 */
public class LispController implements iLispController{

    iLispController SALIDA = null;
    Map<Object,Object> MAPAS = new HashMap<Object,Object>();
    
    public LispController(iLispController salida, Object[] parametros, Object[] argumentos) {
        this.SALIDA = salida;
        if (parametros != null) {
            for (int i = 0; i < parametros.length; ++i) {
                MAPAS.put(parametros[i], argumentos[i]);
            }
	}
    }
    
    public LispController() {
        this(null, null, null);
    }
    
    @Override
    public void put(Object key, Object valores) {
        MAPAS.put(key, valores);
    }
    
    @Override
    public Object get(Object expresion) {
        Object dato = MAPAS.get(expresion);
	if (dato != null){
            return dato;
        }
	if (SALIDA != null){
            return SALIDA.get(expresion);
        }
            
	return null;
    }
    
    @Override
    public boolean contieneKey(Object key) {
        
        if (MAPAS.containsKey(key)){
            return true;
        }
        if (SALIDA != null){
            return SALIDA.contieneKey(key);
        }
	
        return false;
    }
    
    
}
