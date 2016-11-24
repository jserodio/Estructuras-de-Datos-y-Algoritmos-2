package packPruebas;

import static org.junit.Assert.*;

import packCodigo.SingleActores;
import packCodigo.SinglePeliculas;

public class TestSinglePeliculas {

	@org.junit.Test
	public void testCargarDatos() {
		SinglePeliculas.getSingle().cargarDatos("casoVacio.txt");
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
		SinglePeliculas.getSingle().cargarDatos("casoA.txt");
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
		
		SingleActores.getSingle().vaciarLista();
		SinglePeliculas.getSingle().vaciarLista();
		
		SinglePeliculas.getSingle().cargarDatos("casoB.txt");
		// resultados
		int esperado = 3; // 3 peliculas nuevas
		int obtenido = SinglePeliculas.getSingle().getLista().size();
		// tiene que dar true, 3 peliculas
		assertEquals(esperado, obtenido);
		
		esperado = 5; // 5 actores nuevas
		obtenido = SingleActores.getSingle().getLista().size();
		// tiene que dar true, cinco actores
		assertEquals(esperado, obtenido);
	}

}
