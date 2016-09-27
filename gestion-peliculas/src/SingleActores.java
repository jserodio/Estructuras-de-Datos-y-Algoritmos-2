import java.util.ArrayList;

public class SingleActores {

	// start-singleton-pattern
	// lazy-initialization
	private static SingleActores	miSingleActores	= null;

	private final ArrayList<Actor>	lista			= new ArrayList<Actor>();

	private SingleActores() {
	}

	public void buscarActor(String nombre) {
		// buscar
		System.out.println(nombre);

	}

	public void eliminarActor(String nombre) {
		// eliminar
	}

	public void insertarActor(Actor actor) {
		// insertar
	}

	public void ordenar() {
		// ordenar
	}

	public static SingleActores getSingle() {

		if (SingleActores.miSingleActores == null) {
			SingleActores.miSingleActores = new SingleActores();
		}

		return SingleActores.miSingleActores;
	}
	// fin-singleton-pattern
}
