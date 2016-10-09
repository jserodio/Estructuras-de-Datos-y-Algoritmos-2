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
			System.out.println(" leer");
			System.out.println(" ordenar");
			System.out.println(" buscar");
			System.out.println(" salir");
			System.out.print("> ");
			elegido = in.nextLine();
			System.out.println();
			switch (elegido) {
			case "leer":
				SingleActores.getSingle().imprimir();
				break;
			case "cargar":
				timer = new Stopwatch();
				SinglePeliculas.getSingle().cargarDatos("ficheros/FilmsActors20162017.txt");
				System.out.println(timer.elapsedTime() + " segundos.\n");
				break;
			case "buscar":
				System.out.println("Escriba el nombre del actor a buscar: ");
				System.out.print("> ");
				String nActor;
				nActor = in.nextLine();
				System.out.print("\n");
				// condicion del if.
				Actor actor = new Actor(nActor);
				int posicion = SingleActores.getSingle().buscarActor(actor);
				if (posicion < 0) {
					System.out.println("El actor no existe.\n");
				} else {
					System.out.println("El actor existe y se encuentra en la posicion: " + posicion);
				}
				break;
			case "salir":
				System.out.print('\n');
				System.out.println("saliendo\n");
				break;
			case "ordenar":
				timer = new Stopwatch();
				String actores[] = SingleActores.getSingle().ordenar();
				System.out.println(timer.elapsedTime() + " segundos.\n");
				System.out.println("Quieres ver la lista ordenada? (si/no)");
				System.out.print("> ");
				String respuesta = in.next();
				if (respuesta.equalsIgnoreCase("si")) {
					for (String a : actores) {
						System.out.println('-' + a);
					}
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