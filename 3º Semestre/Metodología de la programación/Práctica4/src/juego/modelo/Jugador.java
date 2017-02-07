package juego.modelo;

/**
 * Jugador.
 *
 * @author Jos� Luis Garrido Labrador
 * @author Jos� Miguel Ram�rez Sanz
 */

public class Jugador {

	// Atributos

	/**
	 * Nombre del jugador.
	 */
	private String nombre;

	/**
	 * Color con el que el jugador va a jugar.
	 */
	private Color color;

	// Constructores

	/**
	 * Constuye al jugador con el nombre y con el color.
	 * 
	 * @param nombre
	 *            - Cadena que contendrá el nombre
	 * @param color
	 *            - Cadena que contendrá el color
	 */
	public Jugador(String nombre, Color color) {
		this.nombre = nombre;
		this.color = color;
	}

	// Procedimientos

	// Funciones

	/**
	 * Devuelve el nombre del jugador.
	 * 
	 * @return atributo nombre
	 */
	public String obtenerNombre() {
		return nombre;
	}

	/**
	 * Devuelve el color del jugador.
	 * 
	 * @return atributo color
	 */
	public Color obtenerColor() {
		return color;
	}

	/**
	 * Devuelva una pieza del color del jugador.
	 * 
	 * @return la nueva pieza creada
	 */
	public Pieza generarPieza() {
		return new Pieza(color);
	}

	/**
	 * Devulve el estado de la clase jugador.
	 */
	public String toString() {
		return nombre + " - " + color;
	}
}
