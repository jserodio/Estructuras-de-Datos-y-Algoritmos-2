import java.util.Scanner;

public class Main {

	private static Scanner	teclado	= null;
	private static String	elegido;

	public static void main(String[] args) {

		Main.teclado = new Scanner(System.in);
		Main.elegido = Main.teclado.next();
		switch (Main.elegido) {
		case "leer":
			System.out.println("leyendo");
			break;
		case "cargar":
			System.out.println("Cargando datos del fichero: ");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("error en el retraso");
				e.printStackTrace();
			}
			Stopwatch timer = new Stopwatch();

			System.out.println(timer.elapsedTime() + " seconds.");

			SinglePeliculas.getSingle().cargarDatos("FilmsActors20162017.txt");

			System.out.println(timer.elapsedTime() + " seconds.");
			break;
		case "buscar":
			while (Main.teclado.hasNextLine()) {
				String nActor;// print the contents of a file by line
				nActor = Main.teclado.nextLine();
				SingleActores.getSingle().buscarActor(nActor);
			}
		}
	}
}
