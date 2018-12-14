import java.util.Arrays;

class MetodoOrdenamientoBurbuja{
	
	public void mostrarVector(int [] datos) {
		System.out.println(Arrays.toString(datos));
	}
	
	public void eficiencia(int comparaciones, int intercambios, int recorridos, long tiempoTotal) {
		
		System.out.println("--- Eficiencia ---");
		System.out.println("Recorridos: " + comparaciones);
		System.out.println("Comparaciones: " + comparaciones);
		System.out.println("Intercambios: " + intercambios);
		System.out.println("Tiempo de ejecucion: " + (double)tiempoTotal / 100000000 + "milisegundos" );
		
	}
	
	public void ordenamienetoBurbuja0(int[] datos) {
		int comparaciones = 0, intercambios = 0, recorridos = 0;
		long tiempoTotal = 0, tiempoInicial = 0;
		
		int aux = 0;
		tiempoInicial = System.nanoTime();
		for(int i = 0; i < datos.length; i++) {
			for(int j = (i + 1); j < datos.length; j++) {
					comparaciones ++;
			if(datos[i] > datos[j]) {
				intercambios ++;
				aux = datos[i];
				datos[i] = datos[j];
				datos[j] = aux;
			}
		
			}
			recorridos ++;
		}
		tiempoTotal = System.nanoTime() - tiempoInicial;
		mostrarVector(datos);
		System.out.println();
		eficiencia(comparaciones, intercambios, recorridos, tiempoTotal);
		
	}
	
	public void ordenamientoBurbuja1(int[] datos) {
		int comparaciones = 0, intercambios = 0, recorridos = 0;
		long tiempoTotal = 0, tiempoInicial = 0;
		
		int aux = 0;
		tiempoInicial = System.nanoTime();
		for(int i = 2; i <= datos.length; i++) {
			for(int j = 0; j <= datos.length -1; j++) {
				comparaciones ++;
				if(datos[j] > datos[j+1]) {
					intercambios ++;
					aux = datos[j];
					datos[j] = datos[j + 1];
					datos[j + 1] = aux;
				}
			}
			
			recorridos ++;
		}
		
		tiempoTotal = System.nanoTime() - tiempoInicial;
		mostrarVector(datos);
		System.out.println();
		eficiencia(comparaciones, intercambios, recorridos, tiempoTotal);
	}
	
	public void ordenamientoBurbuja2(int[] datos) {
		int comparaciones = 0, intercambios = 0, recorridos = 0;
		long tiempoTotal = 0, tiempoInicial = 0;
		int i = 1, aux = 0;
		boolean ordenado = false;
		
		tiempoInicial = System.nanoTime();
		while(i < datos.length && !ordenado) {
			i ++;
			ordenado = true;
			for(int j = 0; j < datos.length-i; j++) {
				comparaciones ++;
				if(datos[j] > datos[j+1]) {
					intercambios ++;
					ordenado = false;
					aux = datos[j];
					datos[j] = datos[j+1];
					datos[j+1] = aux;
				}
			}
			recorridos ++;
		}
		tiempoTotal = System.nanoTime() - tiempoInicial;
		mostrarVector(datos);
		System.out.println();
		eficiencia(comparaciones, intercambios, recorridos, tiempoTotal);
	}
	
	public void ordenamientoBurbuja3(int[] datos) {
		int comparaciones = 0, intercambios = 0, recorridos = 0;
		long tiempoTotal = 0, tiempoInicial = 0;
		int i = 1, aux = 0;
		boolean ordenado;
		
		tiempoInicial = System.nanoTime();
		do {
			i++;
			ordenado = true;
			for(int j = 0; j <= datos.length-1; j++) {
				comparaciones ++;
				if(datos[j] > datos[j+1]) {
					intercambios ++;
					ordenado = false;
					aux = datos[j];
					datos[j] = datos[j+1];
					datos[j+1] = aux;
				}
			}
			recorridos ++;
		}
		while(i < datos.length || !ordenado);
		tiempoTotal = System.nanoTime() - tiempoInicial;
		mostrarVector(datos);
		System.out.println();
		eficiencia(comparaciones, intercambios, recorridos, tiempoTotal);
	}
	
}//ClaseBurbuja


public class PruebaMetodoBurbuja {

	public static void main(String[] args) {
		
		int[] edades = {34, 28, 10, 5, 50, 20, 60, 2, 15};
		
		MetodoOrdenamientoBurbuja mob = new MetodoOrdenamientoBurbuja();
		
		System.out.println("Vector sin ordenar: ");
		mob.mostrarVector(edades);
		System.out.println("Vector ordenado: ");
		mob.ordenamienetoBurbuja0(edades);
		
		mob.ordenamientoBurbuja1(edades);
		
		mob.ordenamientoBurbuja2(edades);
		
		mob.ordenamientoBurbuja3(edades);
		

	}//main

}//clase
