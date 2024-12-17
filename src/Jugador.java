import java.io.Serializable;

public class Jugador implements Serializable {
	
	//Creamos los atributos de la clase
	private String nombre;
	private int puntos;

	
	//Creamos los diferentes constructores
	public Jugador(String nombre, int puntos) {
		super();
		this.nombre = nombre;
		this.puntos = puntos;
	}
	
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Jugador() {
		
	}

		
	//Creamos los getters y los setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
