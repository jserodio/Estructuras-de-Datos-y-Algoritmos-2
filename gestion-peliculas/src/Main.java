import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out
				.println("Escriba cual de las siguientes tareas desea realizar: ");
		System.out.println(" cargar");
		System.out.println(" leer");
		System.out.println(" buscar");
		System.out.println(" salir");

		String elegido = "";// Para que no ocurra nullpointerexception
		// mientras elegido != salir no se cerrara el programa
		while (!elegido.equals("salir")) {
			elegido = new Scanner(System.in).next();
			switch (elegido) {
			case "leer":
				System.out.println("leyendo");
				break;
			case "cargar":
				System.out.println("Cargando datos del fichero: ");
				try {
					Thread.sleep(2000);// e puesto esto para que aparezca mas
					// tiempo el mensaje de cargando datos
					// del fichero
				} catch (InterruptedException e) {
					System.out.println("error en el retraso");
					e.printStackTrace();
				}
				Stopwatch timer = new Stopwatch();

				System.out.println(timer.elapsedTime() + " seconds.");

				SinglePeliculas.getSingle().cargarDatos(
						"FilmsActors20162017.txt");

				System.out.println(timer.elapsedTime() + " seconds.");
				break;
			case "buscar":
				String nActor;// print the contents of a file by line
				nActor = new Scanner(System.in).nextLine();
				SingleActores.getSingle().buscarActor(nActor);
			}
		}
	}
}
