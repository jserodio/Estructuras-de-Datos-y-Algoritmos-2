public class Main {

	public static void main(String[] args) {

		System.out.println("Cargando datos del fichero: ");

		Stopwatch timer = new Stopwatch();
		
		System.out.println(timer.elapsedTime() + " seconds.");
		
		SinglePeliculas.getSingle().cargarDatos("FilmsActors20162017.txt");
		
		System.out.println(timer.elapsedTime() + " seconds.");

	}

}
