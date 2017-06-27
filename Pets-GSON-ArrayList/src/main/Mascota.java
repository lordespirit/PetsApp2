package main;
/**
 * Como Mascota es abstracta no podr� instanciada directamente.
 * Solo vale para ser extendida.
 * Las clases que extienden de esta clase deben implementar los m�todos abstractos (como getPesoRacion())
 * El m�todo no abstracto (getEstadoNutricion()) no es abstracto, por lo tanto puede o no ser redefinido.
 * @author alumne
 *
 */
public abstract class Mascota {
	
	final public String typeClass; 
	private Person propietario;
	private String nombre;
	private float peso;
	private float altura;
	private float largo;
	
	public Mascota(){
		typeClass= getTypeClass(); 
	}
	
	public Mascota(String nombre, float peso, float altura, float largo){
		typeClass= getTypeClass(); 
		this.nombre = nombre;
		this.peso = peso;
		this.altura = altura;
		this.largo = largo;
	}
	
	/**
	 * Metodo que debe retornar el nombre de la clase, 
	 * Use getClass().getName();  debe definirse en todos los objetos que extienden de
	 * Mascota
	 * @return
	 */
	
	protected abstract String getTypeClass();  
		
	
	/**
	 * M�todo NO abstracto, tambi�n puede ser redefinido con @Override igual que un m�todo abstracto, pero aqu� es opcional, en abstracto es obligatorio.
	 * @return
	 */
	public float getEstadoNutricion(){
		return 0;
	}
	
	/**
	 * M�todo abstracto que debe ser definido en la herencia (clases que extienden de esta clase (Mascota)).
	 * @return
	 */
	public abstract float getPesoRacion();

	
	
	// GETTERS AND SETTERS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getLargo() {
		return largo;
	}

	public void setLargo(float largo) {
		this.largo = largo;
	}
	
	public Person getPropietario() {
		return propietario;
	}

	public void setPropietario(Person propietario) {
		this.propietario = propietario;
	}

}

