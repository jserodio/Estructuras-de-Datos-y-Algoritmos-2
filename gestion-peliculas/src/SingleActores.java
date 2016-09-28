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
	
	public void buscarActor(String nombre) {
		if (lista.contains(nombre) == true) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNombre() == nombre) {// Busca el nombre en
					// la
					// lista
					System.out.println("Nombre:" + nombre);// Imprime por
					// pantalla
					// la info
					System.out.println("Peliculas:");
					for (int j = 0; i < lista.get(i).getListaPeliculas().size(); j++) {
						System.out.println('\n' + lista.get(i)
								.getListaPeliculas().get(j).getNombre());
					}
				}
			}
		} else {
			System.out.println("No se ha encontrado al actor o actriz");
		}
	}

	public void eliminarActor(String nombre) {
		if (lista.contains(nombre) == true) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNombre() == nombre) {
					lista.remove(i);
				}
			}
		} else {
			System.out.println("No se ha encontrado al actor o actriz");
		}
	}

	public void insertarActor(Actor actor) {
		lista.add(actor);
	}

	public void ordenar() {
		// ordenar
	}

}
