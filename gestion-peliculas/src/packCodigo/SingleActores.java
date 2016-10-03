package packCodigo;
import java.util.ArrayList;

public class SingleActores {

	// start-singleton-pattern
	// lazy-initialization
	private static SingleActores	miSingleActores	= null;

	private SingleActores() {
	}

	public static SingleActores getSingle() {

		if (SingleActores.miSingleActores == null) {
			SingleActores.miSingleActores = new SingleActores();
		}

		return SingleActores.miSingleActores;
	}
	// fin-singleton-pattern
	
	/**
	 * 
	 * CODIGO DE SINGLEACTORES
	 * 
	 */
	private final ArrayList<Actor>	lista			= new ArrayList<Actor>();
	
	/**
	 * Mira si está el actor en la lista.
	 * 
	 * @param nombre
	 * @return	Devuelve TRUE si encuentra el actor, si no FALSE.
	 */
	public boolean estaActor(String nombre) {
		return lista.contains(nombre);
	}
	
	/**
	 * Busca el actor y devuelve su posición.
	 * 
	 * @param nombre
	 * @return Devuelve la POSICIÓN donde se encuentra el actor.
	 */
	public int buscarActor(String nombre) {
		return lista.indexOf(nombre);
	}
	
	public void imprimir() {
		for (Actor actor : lista) {
			System.out.println("\n" + actor.getNombre());
		}
	}

	public void eliminarActor(String nombre) {
		if (this.estaActor(nombre)) {
			lista.remove(this.buscarActor(nombre)); 
		}
	}

	public boolean insertarActor(Actor actor) {
		if (this.estaActor( actor.getNombre() )) {
			return false;
		} else {		
			lista.add(actor);
			return true;
		}
		
	}

	public void ordenar() {
		// ordenar
	}

	public ArrayList<Actor> getLista() {
		return lista;
	}

}
