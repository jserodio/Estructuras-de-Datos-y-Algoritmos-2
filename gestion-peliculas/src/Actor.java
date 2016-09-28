import java.util.ArrayList;

public class Actor {

	private final String		nombre;

	private ArrayList<Pelicula>	listaPeliculas;

	public Actor(String a) {
		this.nombre = a;
	}

	public ArrayList<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public String getNombre() {
		return nombre;
	}

}
