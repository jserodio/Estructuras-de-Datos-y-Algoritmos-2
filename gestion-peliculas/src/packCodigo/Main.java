package packCodigo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String elegido;
		Scanner in = new Scanner(System.in);
		Stopwatch timer;
		Actor actor;
		Pelicula pelicula;
		String nActor;
		String nPelicula;
		
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
			System.out.println(" insertar actores de una pelicula");
			System.out.println(" salir");
			System.out.print("> ");
			elegido = in.nextLine();
			System.out.println();
			switch (elegido) {
			case "cargar":
				System.out.println("Cargando archivo, espere por favor.");
				timer = new Stopwatch();
				SinglePeliculas.getSingle().cargarDatos("ficheros/FilmsActors20162017.txt");
				System.out.println("El archivo ha sido cargado.");
				System.out.println(timer.elapsedTime() + " segundos.\n");
				break;
			case "leer actores":
				SingleActores.getSingle().imprimir();
				break;
			case "leer peliculas":
				SinglePeliculas.getSingle().imprimir();
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
			case "ordenar actores":
				timer = new Stopwatch();
				System.out.println("Ordenando, espere por favor.");
				String actores[] = SingleActores.getSingle().ordenar();
				System.out.println(timer.elapsedTime() + " segundos.\n");
				System.out.println("Quieres ver la lista de actores ordenada? (si/no)");
				System.out.print("> ");
				String respuesta = in.nextLine();
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
				String respuest = in.nextLine();
				if (respuest.equalsIgnoreCase("si")) {
					System.out.print('\n');
					if (peliculas != null)
						for (String p : peliculas) {
							System.out.println('-' + p);
						}
					else System.out.println("Debe cargar los datos primero, o insertar alguna pelicula.");
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
				actor = SingleActores.getSingle().getLista().get(SingleActores.getSingle().buscarActor(actor)); // obtener objeto original
				System.out.println(timer.elapsedTime() + " segundos.\n");
				actor.imprimir();
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