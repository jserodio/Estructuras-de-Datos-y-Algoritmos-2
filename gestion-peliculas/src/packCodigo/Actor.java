package packCodigo;

import java.util.ArrayList;

public class Actor implements Comparable<Actor> {

	private final String		nombre;

	private ArrayList<Pelicula>	listaPeliculas;

	public Actor(String a) {
		this.nombre = a;
	}

	@Override
	public int compareTo(Actor o) {
		return nombre.compareTo(o.getNombre());
	}

	public ArrayList<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public String getNombre() {
		return nombre;
	}

}
