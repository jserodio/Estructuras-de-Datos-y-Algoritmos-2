package packCodigo;

import java.util.ArrayList;

public class Actor implements Comparable<Actor> {

	private final String		nombre;

	private ArrayList<Pelicula>	listaPeliculas;

	public Actor(String a) {
		this.nombre = a;
		this.listaPeliculas = new ArrayList<Pelicula>();
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
	
	public void imprimir() {
		for (Pelicula pelicula : listaPeliculas) {
			System.out.println("-" + pelicula.getNombre());
		}
		System.out.print("\nSe han obtenido: " + listaPeliculas.size() + " peliculas.\n\n");
	}
	
	public void insertarPelicula(Pelicula peli) {
		listaPeliculas.add(peli);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
