package packCodigo;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SinglePeliculas {

	// start-singleton-pattern
	// lazy-initialization
	private static SinglePeliculas		miSinglePeliculas	= null;

	private SinglePeliculas() {
	}
	
	public static SinglePeliculas getSingle() {

		if (SinglePeliculas.miSinglePeliculas == null) {
			SinglePeliculas.miSinglePeliculas = new SinglePeliculas();
		}

		return SinglePeliculas.miSinglePeliculas;
	}
	// fin-singleton-pattern

	/**
	 * 
	 * CODIGO DE SINGLEPELICULAS
	 * 
	 */
	private ArrayList<Pelicula> lista = new ArrayList<Pelicula>();
	private String[] nombresOrdenados;
	
	public void cargarDatos(String ruta) {

		Map<String, Actor> listaHash = new HashMap<String, Actor>();

		// vacio los datos anteriores
		this.vaciarLista();
		SingleActores.getSingle().vaciarLista();
		
		try {

			// Abriendo el fichero
			Scanner input = null;
			input = new Scanner(new FileReader("ficheros/" + ruta));
			String linea;
			Actor actor;
			Pelicula pelicula;
			
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
//				System.out.println("Pelicula: " + f[0]);

				// Instanciar el objeto pelicula e insertarlo a la lista
				pelicula = new Pelicula(f[0]);
				SinglePeliculas.getSingle().insertarPelicula(pelicula);

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
						
						// Actor actor = new Actor(item);
						// Si el actor no esta en la listaHash
						if (listaHash.containsKey(item) == false) {
							
							actor = new Actor(item);
							listaHash.put(item, actor);
							
							SingleActores.getSingle().insertarActor(actor);
//							System.out.println("Actor: " + item);
							
						}
						
						// Insertar actor concreto en la lista de la pelicula concreta.
						// Si el actor es nuevo, se inserta en la lista HashMap
						// Si no es un actor nuevo, igualmente estaba en la lista
						// Pase lo que pase, se obtiene el objeto Actor previamente creado
						actor = listaHash.get(item);
						pelicula.insertarActor(actor);
						
						// Para este actor, sea uno nuevo, o antiguo, insertamos su peli
						actor.insertarPelicula(pelicula);
					}

				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println('\n' + "No se pudo encontrar el archivo.");
			System.out.println("La ruta especificada: " + ruta);
			System.out.println("Comprueba que la ruta sea correcta.");
		}

	}

	/**
	 * Guarda las peliculas y los actores.
	 * Precondicion: Para que un actor se guarde, tiene que tener asociada una pelicula.
	 * 
	 * @param ruta		Especifica el nombre del fichero y donde se guardará.
	 */
	public void guardarDatos(String ruta) throws IOException {
		String[] actores;
		String g;
		String linea;
		
		Charset myCharset = StandardCharsets.UTF_8;

		Writer writer = new OutputStreamWriter( new FileOutputStream("ficheros/" + ruta), myCharset );
		
		for (Pelicula peli : this.lista) {
			actores = peli.getListaActores().stream().map(Actor::getNombre).toArray(String[]::new);
			g = String.join(" &&& ", actores);
			linea = String.join(" ---> ", peli.getNombre(), g );
			writer.write(linea + '\n');
		}
		writer.flush();
		writer.close();
	}

	public boolean insertarPelicula(Pelicula pelicula) {
		return lista.add(pelicula);
	}
	
	public ArrayList<Pelicula> getLista() {
		return lista;
	}

	/**
	 * Imprime la lista de peliculas
	 */
	public void imprimir() {
		System.out.print("\n");
		if (lista != null) {
			lista.stream().map(Pelicula::getNombre).forEach(nombrePelicula -> System.out.println("-" + nombrePelicula));
			System.out.println("\nSe han listado " + lista.size() + " peliculas.\n");
		} else {
			System.out.println("Debe cargar los datos primero.");
		}
	}

	/**
	 * Busca la pelicula y devuelve su posición.
	 * 
	 * @param nombre
	 * @return Devuelve la POSICIÓN donde se encuentra la pelicula.
	 * 		   Si no encuentra la pelicula devuelve -1.
	 */
	public int buscarPelicula(Pelicula pelicula) {
		return lista.indexOf(pelicula);
	}

	/**
	 * Ordenación por QuickSort.
	 * Coste: O(n·Log2·n)
	 * 
	 * @return String[] ordenado. NULL si la lista está vacia.
	 */
	public String[] ordenar() {
		
		// si lista esta vacia
        if (lista.equals(null) || lista.size()==0) {
        	nombresOrdenados = null;
        	System.out.println("Debe cargar los datos primero o insertar nuevos.");
        } else {
	    	// array de strings con tamano original de la lista
	    	nombresOrdenados = lista.stream().map(Pelicula::getNombre).toArray(String[]::new);
    		// algoritmo de quickSort
        	nombresOrdenados = quickSort(0, lista.size() - 1);
        }
		
		return nombresOrdenados;
	}
	
	private String[] quickSort(int inicio, int fin) {
	     int izq = inicio;
	     int der = fin;
	     String temp;
	     String pivote = nombresOrdenados[inicio + (fin - inicio) / 2];
	
	     while (izq <= der) {
	         while (nombresOrdenados[izq].compareToIgnoreCase(pivote) < 0) {
	             izq++;
	         }
	
	         while (nombresOrdenados[der].compareToIgnoreCase(pivote) > 0) {
	             der--;
	         }
	
	         if (izq <= der) {
	    	     temp = nombresOrdenados[izq];
	    	     nombresOrdenados[izq] = nombresOrdenados[der];
	    	     nombresOrdenados[der] = temp;
	             izq++;
	             der--;
	         }
	     }
	     if (inicio < der) {
	    	 quickSort(inicio, der); // recursividad
	     }
	     if (izq < fin) {
	         quickSort(izq, fin); // recursividad
	     }
	     return nombresOrdenados;
	}
	
	/**
	 * Vaciar lista.
	 */
	public void vaciarLista() {
		this.lista = new ArrayList<Pelicula>();
	}
}
