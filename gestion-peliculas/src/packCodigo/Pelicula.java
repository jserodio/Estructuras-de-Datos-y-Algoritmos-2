package packCodigo;
import java.util.ArrayList;
//import java.util.Iterator;
//import packCircularLinkedList.UnorderedCircularLinkedList;

public class Pelicula {

	private final String		nombre;
	// private ArrayList<Actor>	listaActores;
	private ArrayList<Actor>	listaActores;
	private float				dinero;

	public Pelicula(String p) {
		this.nombre = p;
		// this.listaActores = new ArrayList<Actor>();
		this.listaActores = new ArrayList<Actor>();
		this.dinero = 0;
	}

	public String getNombre() {
		return nombre;
	}
	
	public float getDinero() {
		return this.dinero;
	}
	
	public ArrayList<Actor> getListaActores() {
		return this.listaActores;
//		ArrayList<Actor> ret = new ArrayList<Actor>();
//		
//		Iterator<Actor> it = this.listaActores.iterator();
//		
//		while (it.hasNext()) {
//			Actor elem = (Actor) it.next();
//			ret.add(elem);
//		}
//		
//		return ret;
	}

	public void insertarActor(Actor actor) {
		listaActores.add(actor);
		//listaActores.addToRear(actor);
	}
	
	public void eliminarActor(Actor actor) {
		listaActores.remove(actor);
	}
	
	public void insertarDinero(float cantidad) {
		this.dinero = this.dinero + cantidad;
	}
	
	public void imprimir() {
		
		for (Actor actor : listaActores) {
			System.out.println("-" + actor.getNombre());
		}
		
		/*
		Iterator<Actor> it = this.listaActores.iterator();
		
		while (it.hasNext()) {
			Actor elem = (Actor) it.next();
			System.out.println("-" + elem.getNombre());
		}
		*/
		System.out.print("\nSe han obtenido: " + listaActores.size() + " actores.\n\n");
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
		Pelicula other = (Pelicula) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
