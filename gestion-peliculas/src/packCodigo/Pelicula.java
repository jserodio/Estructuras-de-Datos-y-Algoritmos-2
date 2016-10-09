package packCodigo;
import java.util.ArrayList;

public class Pelicula {

	private final String		nombre;

	private ArrayList<Actor>	listaActores;
	private float				dinero;

	public Pelicula(String p) {
		this.nombre = p;
		this.listaActores = new ArrayList<Actor>();
	}

	public String getNombre() {
		return nombre;
	}

	public void insertarDinero(float cantidad) {
		this.dinero = cantidad;
	}

	public void insertarActor(Actor actor) {
		listaActores.add(actor);
	}
}
