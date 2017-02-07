package excepcion;

/**
 * Excepci�n ejemplo.
 * 
 * @author <a href="mailto:rmartico@ubu.es">Ra�l Marticorena</a>
 * @author <a href="mailto:cpardo@ubu.es">Carlos Pardo</a> *
 * @version 1.0
 */
@SuppressWarnings("serial")
public class AException extends Exception {

	/**
	 * Constructor sin argumentos.
	 */
	public AException() {		
	}

	/**
	 * Constructor con texto descriptivo.
	 * 
	 * @param arg0 texto descriptivo
	 */
	public AException(String arg0) {
		super(arg0);
	}

	/**
	 * Constructor con excepci�n encadenada.
	 * 
	 * @param arg0 excepci�n encadenada
	 */
	public AException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * Constructor con texto descriptivo y excepci�n encadenada.
	 * 
	 * @param arg0 texto descriptivo
	 * @param arg1 excepci�n encadenada
	 */
	public AException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
