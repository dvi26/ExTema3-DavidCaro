package fecha;

/**
 * En la clase fecha guardaremos la informacion de una fecha concreta.
 */
public class Fecha {
	public static final int DIEZ = 10;
	/**
	 * Atributo que contendra el valor del dia
	 */
	private int dia; // d�a
	/**
	 * Atributo que contendra el valor del mes
	 */
	private int mes; // mes
	/**
	 * Atributo que contendra el valor del anho
	 */
	private int anho; // a�o

	/**
	 * Constructor sin parametros
	 */
	public Fecha() {

	}

	/**
	 * Constructor con parametros
	 */
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anho = anio;
	}

	/**
	 * Metodo que devuelve varios booleanos (dia, mes y año), sin parametros de
	 * entrada. Comprobara el rango en el que esta la fecha. Tendra en cuenta el
	 * caso en el que el año sea bisiesto.
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		
		boolean mesCorrecto;
		
		boolean anioCorrecto;
		
		anioCorrecto = anho > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		boolean diaMayor1 = dia >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dia <= 29;
			} else {
				diaCorrecto = diaMayor1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	/**
	 * Metodo que devuelve un booleano, sin parametros de entrada. Comprobara si el
	 * año introducido es bisiesto.
	 */
	private boolean esBisiesto() {
		return anho % 4 == 0 && anho % 100 != 0 || anho % 400 == 0;
	}

	// M�todo diaSiguiente
	/**
	 * Metodo que no devuelve nada, sin parametros de entrada. Se encargara de pasar
	 * al día siguiente. Tambien considerara los casos en los que la fecha
	 * introducida devuelva False
	 */
	public void nextDay() {
		dia++;
		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				anho++;
			}
		}
	}

	// M�todo toString
	/**
	 * Metodo que devuelve una cadena, sin parametros de entrada. Devolvera
	 * diferentes cadenas en funcion del mes y el dia (Si son mayores o menores de
	 * 10,etc.).
	 */
	public String toString() {
		String cadena;
		if (dia < DIEZ && mes < DIEZ) {
			cadena = "0" + dia + "-0" + mes + "-" + anho;
		} else if (dia < DIEZ && mes >= DIEZ) {
			cadena = "0" + dia + "-" + mes + "-" + anho;
		} else if (dia >= DIEZ && mes < DIEZ) {
			cadena = dia + "-0" + mes + "-" + anho;
		} else {
			cadena = dia + "-" + mes + "-" + anho;
		}
		return cadena;
	}

}
