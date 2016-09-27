import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SinglePeliculas {

	// start-singleton-pattern
	// lazy-initialization
	private static SinglePeliculas		miSinglePeliculas	= null;

	private final ArrayList<Pelicula>	lista				= new ArrayList<Pelicula>();

	private SinglePeliculas() {
	}

	public void cargarDatos(String ruta) {

		HashSet<String> listaHash = new HashSet<String>();

		try {

			// Abriendo el fichero
			Scanner input = null;
			input = new Scanner(new FileReader(ruta));
			String linea;

			System.out.println("\nCargando...");

			while (input.hasNext()) {

				// Leemos linea
				linea = input.nextLine();
				if (linea.trim().length() == 0) {
					continue;
				}

				// Dividir la linea en array f[] con diferentes posiciones
				// Antes de dividir:
				// linea ⬅️
				// "Eager to Die ---> Devon, Tony &&& O'Toole, Peter (I)"
				// Despues de dividir:
				// f[0] ⬅️ "Eager to Die"
				// f[1] ⬅️ "Devon, Tony &&& O'Toole, Peter (I)"
				String f[] = linea.split(" ---> ");

				// Imprimir pelicula
				System.out.println("Pelicula: " + f[0]);

				// Instanciar el objeto pelicula e insertarlo a la lista
				Pelicula peli = new Pelicula(f[0]);
				SinglePeliculas.getSingle().insertarPelicula(peli);

				if (f.length > 1) {
					// Dividir f[1] en un array g[] con diferentes posiciones
					// Antes de dividir:
					// f[1] ⬅️ "Devon, Tony &&& O'Toole, Peter (I)"
					// Despues de dividir:
					// g[0] ⬅️ "Devon, Tony"
					// g[1] ⬅️ "O'Toole, Peter (I)"
					String g[] = f[1].split(" &&& ");

					// Por cada actor.
					for (String item : g) {

						// Si el actor no esta en la listaHash
						if (listaHash.contains(item) == false) {
							listaHash.add(item);
							// Crear objeto actor e insertarlo en la Lista
							// completa.
							Actor actor = new Actor(item);
							SingleActores.getSingle().insertarActor(actor);
							System.out.println("Actor: " + item);
						} else {

							System.out.println("# Actor repetido: " + item);
						}
					}

				}
				System.out.println("");
			}
			input.close();

			System.out.println("El archivo ha sido cargado." + '\n');

			// return algo;

		} catch (FileNotFoundException e) {
			System.out.println('\n' + "No se pudo encontrar el archivo.");
			System.out.println("La ruta especificada: " + ruta);
			System.out.println("Comprueba que la ruta sea correcta.");
		}

	}

	public void guardarDatos(String ruta) {
		// guardar
	}

	public void insertarPelicula(Pelicula pelicula) {
		lista.add(pelicula);
	}

	public static SinglePeliculas getSingle() {

		if (SinglePeliculas.miSinglePeliculas == null) {
			SinglePeliculas.miSinglePeliculas = new SinglePeliculas();
		}

		return SinglePeliculas.miSinglePeliculas;
	}
	// fin-singleton-pattern

}
