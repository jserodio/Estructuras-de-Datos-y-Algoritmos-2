package packPruebas;

import static org.junit.Assert.*;

import packCodigo.SingleActores;
import packCodigo.SinglePeliculas;

public class TestSinglePeliculas {

	@org.junit.Test
	public void testCargarDatos() {
		SinglePeliculas.getSingle().cargarDatos("ficheros/casoVacio.txt");
		// resultados
		int esperado = 0;
		int obtenido = SinglePeliculas.getSingle().getLista().size();
		// tiene que dar true, no hay peliculas
		assertEquals(esperado, obtenido);
		
		obtenido = SingleActores.getSingle().getLista().size();
		// tiene que dar true, no hay actores
		assertEquals(esperado, obtenido);
	}
	
	@org.junit.Test
	public void testCargarDatosCasoA() {
		SinglePeliculas.getSingle().cargarDatos("ficheros/casoA.txt");
		// resultados
		int esperado = 1;
		int obtenido = SinglePeliculas.getSingle().getLista().size();
		// tiene que dar true, una pelicula obtenida
		assertEquals(esperado, obtenido);
		
		esperado = 3;
		obtenido = SingleActores.getSingle().getLista().size();
		// tiene que dar true, tres actores
		assertEquals(esperado, obtenido);
	}
	
	@org.junit.Test
	public void testCargarDatosCasoB() {
		SinglePeliculas.getSingle().cargarDatos("ficheros/casoB.txt");
		// resultados
		int esperado = 4; // 1 pelicula de antes + 3 peliculas nuevas
		int obtenido = SinglePeliculas.getSingle().getLista().size();
		// tiene que dar true, cuatro peliculas obtenidas
		assertEquals(esperado, obtenido);
		
		esperado = 8; // 3 peliculas del test anterior + 5 peliculas nuevas
		obtenido = SingleActores.getSingle().getLista().size();
		// tiene que dar true, tres actores
		assertEquals(esperado, obtenido);
	}

}
