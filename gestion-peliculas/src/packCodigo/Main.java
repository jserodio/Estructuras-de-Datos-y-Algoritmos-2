package packCodigo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import packGrafo.GraphHash;

public class Main {

	public static void main(String[] args) {

		String elegido;
		Scanner in = new Scanner(System.in);
		Stopwatch timer;
		Actor actor;
		Pelicula pelicula;
		String nActor;
		String nPelicula;
		String respuesta;
		String ruta;
		boolean grafoCreado = false;
		GraphHash grafo = null;
		boolean correcto;
		
		// mientras elegido != salir no se cerrara el programa
		do {
			System.out.println("Escriba cual de las siguientes tareas desea realizar: ");
			System.out.println(" cargar");
			System.out.println(" leer actores");
			System.out.println(" leer peliculas");
			System.out.println(" ordenar actores");
			System.out.println(" ordenar peliculas");
			System.out.println(" buscar actor");
			System.out.println(" buscar pelicula");
			System.out.println(" insertar actor");
			System.out.println(" insertar pelicula");
			System.out.println(" peliculas de un actor");
			System.out.println(" actores de una pelicula");
			System.out.println(" insertar peliculas de un actor");
			System.out.println(" eliminar actor");
			System.out.println(" incrementar dinero");
			System.out.println(" guardar");
			System.out.println(" reiniciar");
			System.out.println(" crear grafo");
			System.out.println(" estan conectados");
			System.out.println(" salir");
			System.out.print("> ");
			elegido = in.nextLine();
			System.out.println();
			switch (elegido) {
			case "cargar":
				System.out.println("Escriba el nombre del archivo, por ejemplo (FilmsActors20162017.txt, o FilmsActors20162017Small.txt).");
				System.out.println("Los archivos se cargan desde la carpeta 'ficheros', en la raiz del ejecutable: ");
				System.out.print("> ");
				ruta = in.nextLine();
				System.out.println("Cargando archivo, espere por favor.");
				timer = new Stopwatch();
				SinglePeliculas.getSingle().cargarDatos(ruta);			
				System.out.println("El archivo ha sido cargado.");
				System.out.println(timer.elapsedTime() + " segundos.\n");
				break;
			case "leer actores":
				SingleActores.getSingle().imprimir();
				break;
			case "leer peliculas":
				SinglePeliculas.getSingle().imprimir();
				break;
			case "ordenar actores":
				timer = new Stopwatch();
				System.out.println("Ordenando, espere por favor.");
				String actores[] = SingleActores.getSingle().ordenar();
				System.out.println(timer.elapsedTime() + " segundos.\n");
				System.out.println("Quieres ver la lista de actores ordenada? (si/no)");
				System.out.print("> ");
				respuesta = in.nextLine();
				if (respuesta.equalsIgnoreCase("si")) {
					System.out.print('\n');
					if (actores != null)
						for (String a : actores) {
							System.out.println('-' + a);
						}
					else System.out.println("Debe cargar los datos primero, o insertar algun actor.");
				}
				System.out.print('\n');
				break;
			case "ordenar peliculas":
				timer = new Stopwatch();
				System.out.println("Ordenando, espere por favor.");
				String peliculas[] = SinglePeliculas.getSingle().ordenar();
				System.out.println(timer.elapsedTime() + " segundos.\n");
				System.out.println("Quieres ver la lista de peliculas ordenada? (si/no)");
				System.out.print("> ");
				respuesta = in.nextLine();
				if (respuesta.equalsIgnoreCase("si")) {
					System.out.print('\n');
					if (peliculas != null)
						for (String p : peliculas) {
							System.out.println('-' + p);
						}
					else System.out.println("Debe cargar los datos primero, o insertar alguna pelicula.");
				}
				System.out.print('\n');
				break;
			case "buscar actor":
				System.out.println("Escriba el nombre del actor a buscar: ");
				System.out.print("> ");
				nActor = in.nextLine();
				System.out.print("\nBuscando, espere por favor.");
				timer = new Stopwatch();
				actor = new Actor(nActor);
				// condicion del if.
				int posicion = SingleActores.getSingle().buscarActor(actor);
				System.out.print('\n');
				System.out.println(timer.elapsedTime() + " segundos.\n");
				if (posicion < 0) {
					System.out.println("El actor no existe.\n");
				} else {
					System.out.println("El actor existe y se encuentra en la posicion: " + posicion + "\n");
				}
				break;
			case "buscar pelicula":
				System.out.println("Escriba el nombre de la pelicula a buscar: ");
				System.out.print("> ");
				nPelicula = in.nextLine();
				System.out.print("\nBuscando, espere por favor.");
				timer = new Stopwatch();
				pelicula = new Pelicula(nPelicula);
				// condicion del if.
				int posicion2 = SinglePeliculas.getSingle().buscarPelicula(pelicula);
				System.out.print('\n');
				System.out.println(timer.elapsedTime() + " segundos.\n");
				if (posicion2 < 0) {
					System.out.println("La pelicula no existe.\n");
				} else {
					System.out.println("La pelicula existe y se encuentra en la posicion: " + posicion2 + "\n");
				}
				break;
			case "insertar actor":
				System.out.println("Escriba el nombre del actor a insertar: ");
				System.out.print("> ");
				nActor = in.nextLine();
				System.out.print("\nInsertando, espere por favor.");
				timer = new Stopwatch();
				actor = new Actor(nActor);
				boolean insertado = SingleActores.getSingle().insertarActor(actor);
				System.out.print('\n');
				System.out.println(timer.elapsedTime() + " segundos.\n");
				if (insertado) {
					System.out.println(nActor + " insertado correctamente.");
				} else {
					System.out.println("No se pudo insertar el actor.");
				}		
				System.out.print('\n');
				break;
			case "insertar pelicula":
				System.out.println("Escriba el nombre de la pelicula a insertar: ");
				System.out.print("> ");
				nPelicula = in.nextLine();
				System.out.print("\nInsertando, espere por favor.");
				timer = new Stopwatch();
				pelicula = new Pelicula(nPelicula);
				boolean insertad = SinglePeliculas.getSingle().insertarPelicula(pelicula);
				System.out.print('\n');
				System.out.println(timer.elapsedTime() + " segundos.\n");
				if (insertad) {
					System.out.println(nPelicula + " insertada correctamente.");
				} else {
					System.out.println("No se pudo insertar la pelicula.");
				}
				System.out.print('\n');
				break;
			case "peliculas de un actor":
				System.out.println("Escriba el nombre del actor: ");
				System.out.print("> ");
				nActor = in.nextLine();
				System.out.print("\nBuscando sus peliculas, espere por favor.\n");
				timer = new Stopwatch();
				actor = new Actor(nActor);
				try {
					actor = SingleActores.getSingle().getLista().get(SingleActores.getSingle().buscarActor(actor)); // obtener objeto original
					System.out.println(timer.elapsedTime() + " segundos.\n");
					actor.imprimir();
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Ups, el actor no existe.\n");
				}
				break;
			case "actores de una pelicula":
				System.out.println("Escriba el nombre de la pelicula: ");
				System.out.print("> ");
				nPelicula = in.nextLine();
				System.out.print("\nBuscando sus actores, espere por favor.\n");
				timer = new Stopwatch();
				pelicula = new Pelicula(nPelicula);
				try {
					pelicula = SinglePeliculas.getSingle().getLista().get(SinglePeliculas.getSingle().buscarPelicula(pelicula)); // obtener objeto original
					System.out.println(timer.elapsedTime() + " segundos.\n");
					pelicula.imprimir();
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Ups, la pelicula no existe.\n");
				}
				break;
			case "insertar peliculas de un actor":
				String[] pelis = null;
				System.out.println("Escriba el nombre del actor: ");
				System.out.print("> ");
				nActor = in.nextLine();
				actor = new Actor(nActor);
				try { // intenta buscar el actor en la lista, si no lo encuentra, crea uno nuevo y lo añade a la lista de actores.
					actor = SingleActores.getSingle().getLista().get(SingleActores.getSingle().buscarActor(actor)); // obtener objeto original
				} catch (IndexOutOfBoundsException e) {
					System.out.println("El actor no existe. Se ha creado uno nuevo.");
					SingleActores.getSingle().insertarActor(actor);
				}
				System.out.println("\nEste actor tiene estas peliculas: ");
				actor.imprimir();
				
				correcto = false;
				while (!correcto) {
					System.out.print("Por favor, introduzca sus peliculas en formato CSV.\n");
					System.out.print("Es decir, peliculas separadas por comas, (coma y espacio) ejemplo: \"Titanic, Star Wars, El Quinto Elemento\".\n");
					System.out.print("> ");
					String nPeliculas = in.nextLine();
					pelis = nPeliculas.split(", ");
					System.out.println("\nSe insertaran las siguientes peliculas: ");
					for (String pe : pelis) {
						System.out.println("-" + pe);
					}
					System.out.println("\nEs correcto? (si/no)");
					System.out.print("> ");
					respuesta = in.nextLine();
					if (respuesta.equalsIgnoreCase("si")) {
						correcto = true;
					}
					System.out.print("\n");
				}
				System.out.print("\n");
				timer = new Stopwatch();
				for (String pe : pelis) {
					pelicula = new Pelicula(pe);
					try { // intenta buscar al pelicula en la lista, si no la encuentra crea una nueva y la añade a ambas listas
						pelicula = SinglePeliculas.getSingle().getLista().get(SinglePeliculas.getSingle().buscarPelicula(pelicula));
					} catch (IndexOutOfBoundsException e) {
						System.out.println("La pelicula" + pe + " no existe en la lista, se ha creado una nueva.");
						SinglePeliculas.getSingle().insertarPelicula(pelicula);
					}
					actor.insertarPelicula(pelicula);
					pelicula.insertarActor(actor);
				}
				System.out.println("\nSe insertaron correctamente " + pelis.length + " peliculas.\n");
				System.out.println(timer.elapsedTime() + " segundos.\n");
				break;
			case "eliminar actor":
				System.out.println("Escriba el nombre del actor: ");
				System.out.print("> ");
				nActor = in.nextLine();
				timer = new Stopwatch();
				actor = new Actor(nActor);
				try { // intenta buscar el actor en la lista
					actor = SingleActores.getSingle().getLista().get(SingleActores.getSingle().buscarActor(actor)); // obtener objeto original
				} catch (IndexOutOfBoundsException e) {
					System.out.println("\nError.");
				}
				// Por cada pelicula de este actor, eliminar su pelicula
				ArrayList<Pelicula> pelisDelActor = actor.getListaPeliculas();
				for (Pelicula peli : pelisDelActor) {
					peli.eliminarActor(actor); // de cada peli eliminamos el actor
				}
				try {
					if (SingleActores.getSingle().eliminarActor(actor).equals(actor)){
						System.out.println("\nEliminado correctamente.\n");
						System.out.println(timer.elapsedTime() + " segundos.\n");
					} else {
							System.out.println("\nEl actor no existe.\n");
					}
				}
				catch (NullPointerException e) {
						System.out.println("\nEl actor no existe.\n");
					}
				break;
			case "incrementar dinero":
				System.out.println("Escriba el nombre de la pelicula: ");
				System.out.print("> ");
				nPelicula = in.nextLine();
				pelicula = new Pelicula(nPelicula);
				try { // intenta buscar al pelicula en la lista
					pelicula = SinglePeliculas.getSingle().getLista().get(SinglePeliculas.getSingle().buscarPelicula(pelicula));
					System.out.println("\nPresupuesto inicial: " + pelicula.getDinero());
					System.out.println("Cantidad a donar: ");
					System.out.print("> ");
					float cant = in.nextFloat();
					in.nextLine(); // para limpiar buffer
					pelicula.insertarDinero(cant);
					System.out.println("Presupuesto final: " + pelicula.getDinero());
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Error, la pelicula no existe.");
				}
				System.out.print("\n");
				break;
			case "guardar":
				System.out.println("Escriba el nombre del archivo, por ejemplo (papelones.txt).");
				System.out.println("Los archivos se guardan en la carpeta 'ficheros', en la raiz del ejecutable: ");
				System.out.print("> ");
				ruta = in.nextLine();
				System.out.println("Guardando, espere por favor.");
				timer = new Stopwatch();
				try {
					SinglePeliculas.getSingle().guardarDatos(ruta);
					System.out.println(timer.elapsedTime() + " segundos.\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "reiniciar":
				System.out.println("Se va a eliminar la informacion cargada.");
				System.out.println("\nEs correcto? (si/no)");
				System.out.print("> ");
				respuesta = in.nextLine();
				if (respuesta.equalsIgnoreCase("si")) {
					SingleActores.getSingle().vaciarLista();
					SinglePeliculas.getSingle().vaciarLista();
				}
				break;
			case "crear grafo":
				grafoCreado = true;
				System.out.println("Creando el grafo.\n");
				timer = new Stopwatch();
				grafo = new GraphHash();
				grafo.crearGrafo(SinglePeliculas.getSingle());
				System.out.println("El grafo ha sido creado.");
				System.out.println(timer.elapsedTime() + " segundos.\n");
				//grafo.print();
				break;
			case "estan conectados":
				if (grafoCreado) {
					System.out.println("Escriba el nombre del primer elemento.");
					System.out.print("> ");
					String p1 = in.nextLine();
					System.out.println("Escriba el nombre del segundo elemento.");
					System.out.print("> ");
					String p2 = in.nextLine();
					System.out.println("Buscando sus conexiones... espere por favor...\n");
					timer = new Stopwatch();
					System.out.print(grafo.estanConectadas(p1, p2) ? "Si," : "No"); System.out.println(" están conectados.");
					System.out.println(timer.elapsedTime() + " segundos.\n");
				} else {
					System.out.println("Debe crear primero el grafo.\n");
				}
				break;
			case "salir":
				System.out.println("Bye!\n");
				break;
			default:
				System.out.println("Comando incorrecto.");
				break;
			} // fin switch
		} while (!elegido.equals("salir"));
		in.close();
	}
}