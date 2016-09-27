import java.util.ArrayList;

public class Pelicula {

	private final String		nombre;

	private ArrayList<Actor>	listaActores;
	private float				dinero;

	public Pelicula(String p) {
		this.nombre = p;
	}

	public String getNombre() {
		return nombre;
	}

	public void insertarDinero(float cantidad) {
		this.dinero = cantidad;
	}
}
