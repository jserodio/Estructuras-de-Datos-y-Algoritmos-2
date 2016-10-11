package packCodigo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String elegido;
		Scanner in = new Scanner(System.in);
		Stopwatch timer;
		
		// mientras elegido != salir no se cerrara el programa
		do {
			System.out.println("Escriba cual de las siguientes tareas desea realizar: ");
			System.out.println(" cargar");
			System.out.println(" leer actores");
			System.out.println(" leer peliculas");
			System.out.println(" ordenar");
			System.out.println(" buscar actor");
			System.out.println(" buscar pelicula");
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
				String nActor = in.nextLine();
				System.out.print("\nBuscando, espere por favor.");
				timer = new Stopwatch();
				Actor actor = new Actor(nActor);
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
				String nPelicula = in.nextLine();
				System.out.print("\nBuscando, espere por favor.");
				timer = new Stopwatch();
				Pelicula pelicula = new Pelicula(nPelicula);
				// condicion del if.
				int posicion2 = SinglePeliculas.getSingle().buscarPelicula(pelicula);
				System.out.print('\n');
				System.out.println(timer.elapsedTime() + " segundos.\n");
				if (posicion2 < 0) {
					System.out.println("La pelicula no existe.\n");
				} else {
					System.out.println("La pelicula existe y se encuentra en la posicion: " + posicion2);
				}
				break;
			case "salir":
				System.out.println("Bye!\n");
				break;
			case "ordenar":
				timer = new Stopwatch();
				System.out.println("Ordenando, espere por favor.");
				String actores[] = SingleActores.getSingle().ordenar();
				System.out.println(timer.elapsedTime() + " segundos.\n");
				System.out.println("Quieres ver la lista ordenada? (si/no)");
				System.out.print("> ");
				String respuesta = in.nextLine();
				if (respuesta.equalsIgnoreCase("si")) {
					if (actores != null)
						for (String a : actores) {
							System.out.println('-' + a);
						}
					else System.out.println("\nDebe cargar los datos primero.");
				}
				System.out.print('\n');
				break;
			default:
				System.out.println("Comando incorrecto.");
				break;
			} // fin switch
		} while (!elegido.equals("salir"));
		in.close();
	}
}