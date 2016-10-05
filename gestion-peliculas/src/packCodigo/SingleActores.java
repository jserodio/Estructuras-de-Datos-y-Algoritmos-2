package packCodigo;

import java.util.ArrayList;
import java.util.Collections;

public class SingleActores {

	// start-singleton-pattern
	// lazy-initialization
	private static SingleActores	miSingleActores	= null;

	/**
	 *
	 * CODIGO DE SINGLEACTORES
	 *
	 */
	final static ArrayList<Actor>	lista			= new ArrayList<Actor>();

	private SingleActores() {
	}

	public void buscarActor(String nombre) {
		if (SingleActores.lista.contains(nombre) == true) {
			for (int i = 0; i < SingleActores.lista.size(); i++) {
				if (SingleActores.lista.get(i).getNombre() == nombre) {// Busca
					// el
					// nombre
					// en
					// la
					// lista
					System.out.println("Nombre:" + nombre);// Imprime por
					// pantalla
					// la info
					System.out.println("Peliculas:");
					for (int j = 0; i < SingleActores.lista.get(i)
							.getListaPeliculas().size(); j++) {
						System.out.println('\n' + SingleActores.lista.get(i)
								.getListaPeliculas().get(j).getNombre());
					}
				}
			}
		} else {
			System.out.println("No se ha encontrado al actor o actriz");
		}
	}

	public void eliminarActor(String nombre) {
		if (SingleActores.lista.contains(nombre) == true) {
			for (int i = 0; i < SingleActores.lista.size(); i++) {
				if (SingleActores.lista.get(i).getNombre() == nombre) {
					SingleActores.lista.remove(i);
				}
			}
		} else {
			System.out.println("No se ha encontrado al actor o actriz");
		}
	}

	public ArrayList<Actor> getLista() {
		return SingleActores.lista;
	}

	public void insertarActor(Actor actor) {
		SingleActores.lista.add(actor);
	}

	public static SingleActores getSingle() {

		if (SingleActores.miSingleActores == null) {
			SingleActores.miSingleActores = new SingleActores();
		}

		return SingleActores.miSingleActores;
	}

	// fin-singleton-pattern

	public static void ordenar() {
		Collections.sort(SingleActores.getSingle().getLista());

	}

}
