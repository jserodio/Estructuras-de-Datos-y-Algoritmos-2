import java.util.ArrayList;

public class SingleActores {

	// start-singleton-pattern
	// lazy-initialization
	private static SingleActores miSingleActores = null;
	
	private SingleActores() {}
	
	public static SingleActores getSingle() {
		
		if (miSingleActores == null) {
			miSingleActores = new SingleActores();
		}
		
		return miSingleActores;
	}
	// fin-singleton-pattern
	
	private ArrayList<Actor> lista = new ArrayList<Actor>();
	
	public void buscarActor(String nombre) {
		// buscar
	}
	
	public void insertarActor(Actor actor) {
		// insertar
	}
	
	public void eliminarActor(String nombre) {
		// eliminar
	}
	
	public void ordenar() {
		// ordenar
	}
}
