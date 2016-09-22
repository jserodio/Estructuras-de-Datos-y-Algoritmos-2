import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Datos {
	public Datos () {	}
	
	public void cargarDatos (String ruta) {
		
		try {
		
			// Abriendo el fichero
		    Scanner input = null;
			input = new Scanner(new FileReader(ruta));
			String linea;
		
			System.out.println("\nCargando...");
			
			while (input.hasNext()) {

				// Leemos linea
				linea = input.nextLine();				
				if(linea.trim().length() == 0){
					continue;
				}
				
				// Dividir la linea en array f[] con diferentes posiciones
				// Antes de dividir:
				// linea ⬅️    "Eager to Die ---> Devon, Tony &&& O'Toole, Peter (I)"
				// Despues de dividir:
				// f[0] ⬅️   "Eager to Die"
				// f[1] ⬅️   "Devon, Tony &&& O'Toole, Peter (I)"
				String f[] = linea.split(" ---> ");
				
				// Imprimir pelicula
				System.out.println("Pelicula: " + f[0]);
				
				if(f.length>1){
					// Dividir f[1] en un array g[] con diferentes posiciones
					// Antes de dividir:
					// f[1] ⬅️   "Devon, Tony &&& O'Toole, Peter (I)"
					// Despues de dividir:
					// g[0] ⬅️  "Devon, Tony"
					// g[1] ⬅️  "O'Toole, Peter (I)"
					String g[] = f[1].split(" &&& ");
					
					for (String item : g) {
						// Imprimir actores
						System.out.println("Actor: " + item);
					}
						
				}
			}
			input.close();
			
			System.out.println("El archivo ha sido cargado." + '\n');
		
			// return algo;
			
		} catch (FileNotFoundException e) {
			System.out.println('\n'+ "No se pudo encontrar el archivo.");
			System.out.println("La ruta especificada: " + ruta);
			System.out.println("Comprueba que la ruta sea correcta.");
		}
			
	}
}
