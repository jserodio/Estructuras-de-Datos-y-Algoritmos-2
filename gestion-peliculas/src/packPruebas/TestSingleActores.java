package packPruebas;

import packCodigo.SinglePeliculas;

public class TestSingleActores {

	@org.junit.Test
	public void testbuscarActor() {
		SinglePeliculas.getSingle().cargarDatos("ficheros/casoA.txt");
//		// resultados
//		int esperado = 0;
//		int obtenido = SinglePeliculas.getSingle().getLista().size();
//		// tiene que dar true, no hay peliculas
//		assertEquals(esperado, obtenido);
//		
//		obtenido = SingleActores.getSingle().getLista().size();
//		// tiene que dar true, no hay actores
//		assertEquals(esperado, obtenido);
	}

}
