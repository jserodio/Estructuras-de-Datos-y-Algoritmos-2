package packCodigo;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String elegido;
		Scanner in = new Scanner(System.in);
		// mientras elegido != salir no se cerrara el programa
		do {
			System.out
			.println("Escriba cual de las siguientes tareas desea realizar: ");
			System.out.println(" cargar");
			System.out.println(" leer");
			System.out.println(" buscar");
			System.out.println(" salir");
			System.out.print("> ");
			elegido = in.next();
			System.out.println();
			switch (elegido) {
			case "leer":
				System.out.println("leyendo");
				break;
			case "cargar":
				Stopwatch timer = new Stopwatch();
				SinglePeliculas.getSingle().cargarDatos("ficheros/FilmsActors20162017.txt");
				System.out.println(timer.elapsedTime() + " segundos.\n");
				break;
			case "buscar":
				String nActor;// print the contents of a file by line
				nActor = new Scanner(System.in).nextLine();
				SingleActores.getSingle().buscarActor(nActor);
			case "salir":
				System.out.println("saliendo");
				break;
			default:
				System.out.println("Comando incorrecto.");
				break;
			} // fin switch			
		} while (!elegido.equals("salir"));
		in.close();
	}
}