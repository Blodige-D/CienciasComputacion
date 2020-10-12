import java.io.IOException;
import java.util.Random;

public class RadixSort {
	
	private int N;
	private int arreglo[];
	private int array[];
	private int matriz[][];
	private int t=0;
	private int c=0;
	private double formula;
	
	public RadixSort(String n) throws IOException {
		this.N = Integer.parseInt(n); 
		this.arreglo = new int[N];
		this.array = new int[N];
		this.matriz = new int[N][N+1];
	}
	
	public void llenarArreglo(int orden) {
		if(orden == 1) {
			//Mejor caso
			this.formula = 400*N+251;
			for(int i = 0; i < N; i++) {
				this.arreglo[i] = i+1;
			}
		}
		
		else if(orden == 2) {
			//Peor caso
			this.formula = 400*N+251;
			
			int f = 1;
			for(int i = N - 1; i > -1; i--) {
				this.arreglo[i] = f;
				f++;
			}
		}
		
		else if(orden == 3) {
			//Caso medio
			this.formula = 400*N+251;
			
			Random aleatorio = new Random(System.currentTimeMillis());
			for(int i = 0; i < N; i++) {
				this.arreglo[i] = aleatorio.nextInt(2*N);
			}
		}
	}
	
	
	public void clasificar() {
		int mayor = arreglo[0];
		
		for(int i=0; i<N; i++) {
			mayor = arreglo[i] > mayor ? arreglo[i]:mayor;
		}
		
		int digitos = mayor > 1000 ? 4:(mayor > 100 ? 3:(mayor > 10 ? 2:1));
		
		for(int k=0; k < digitos; k++) {
			inicializar();
			if(k==0) {
				c = c + 1;
				for(int i=0; i<N; i++) {
					c = c + 26;
					int millares=arreglo[i]/1000;
					int centenas=(arreglo[i]-(millares*1000))/100;
					int decenas=(arreglo[i]- (millares*1000 + centenas*100))/10;
					int unidades=arreglo[i]-(millares*1000 + centenas*100 + decenas*10);
					llenarMatriz(unidades, i);
				}
				c = c + 2;
				for(int i=0; i<N; i++) {
					c = c + 2;
					almacenarArreglo(i);
				}
				c = c + 1;
			}
			if(k==1) {
				c = c + 1;
				for(int i=0; i<N; i++) {
					c = c + 18;
					int millares=arreglo[i]/1000;
					int centenas=(arreglo[i]-(millares*1000))/100;
					int decenas=(arreglo[i]- (millares*1000 + centenas*100))/10;
					llenarMatriz(decenas, i);
				}
				c = c + 2;
				for(int i=0; i<N; i++) {
					c = c + 2;
					almacenarArreglo(i);
				}
				c = c + 1;
			}
			if(k==2) {
				c = c + 1;
				for(int i=0; i<N; i++) {
					c = c + 11;
					int millares=arreglo[i]/1000;
					int centenas=(arreglo[i]-(millares*1000))/100;
					llenarMatriz(centenas, i);
				}
				c = c + 2;
				for(int i=0; i<N; i++) {
					c = c + 2;
					almacenarArreglo(i);
				}
				c = c + 1;
			}
			if(k==3) {
				c = c + 1;
				for(int i=0; i<N; i++) {
					c = c + 6;
					int millares=arreglo[i]/1000;
					llenarMatriz(millares, i);
				}
				c = c + 2;
				for(int i=0; i<N; i++) {
					c = c + 2;
					almacenarArreglo(i);
				}
				c = c + 1;
			}
		}
	}
	
	public void llenarMatriz(int a, int i) {
		c = c + 1;
		for(int j=0; j<N; j++) {
			c = c + 3;
			if(a == j) {
				c = c + 8;
				matriz[j][array[j]] = arreglo[i];
				array[j] += 1;
			}
		}
		c = c + 1;
	}
	public void almacenarArreglo(int i) {
		c = c + 1;
		for(int j=0; j<N; j++) {
			c = c + 5;
			if(matriz[i][j] != 0) {
				c = c + 5;
				arreglo[t] = matriz[i][j];
				t++;
			}
		}
		c = c + 1;
	}
	public void inicializar() {
		t = 0;
		for(int i=0; i<N; i++) {
			array[i] = 0;
			for(int j=0; j<N; j++) {
				matriz[i][j] = 0;
			}
		}
		
	}
	public void devolverDatos() {
		System.out.println("");
		System.out.println("Por contador se obtuvo "+this.c+" operaciones elementales.");
		System.out.println("Por formula se obtuvo "+this.formula+" operaciones elementales.");
	}

}
