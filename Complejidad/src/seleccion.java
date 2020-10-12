import java.util.Random;

public class seleccion {
	
	private int N;
	private int a[];
	private int c;
	private int t;
	private int x;
	private double formula;
	
	public seleccion(String n) {
		this.N = Integer.parseInt(n); 
		this.a = new int[N];
	}
	
	public void llenarArreglo(int orden) {
		if(orden == 1) {
			//Mejor caso
			this.formula = (double)5/4*N*N + 4*N + 3;
			
			for(int i = 0; i < N; i++) {
				this.a[i] = i;
			}
		}
		
		else if(orden == 2) {
			//Peor caso
			this.formula = (double)3/2*N*N + 7.5*N + 3;
			
			for(int j = 0; j < N; j++){ 
				  a[j] = N - j;
			}
		}
		
		else if(orden == 3) {
			//Caso medio
			this.formula = (double)11/8*N*N + 23/4*N + 3;
			
			Random aleatorio = new Random(System.currentTimeMillis());
			for(int i = 0; i < N; i++) {
				this.a[i] = aleatorio.nextInt(2*N);
			}
		}
			
	}
	
	public void ordenarArreglo() {
		
		c = 1;
		for(int i = 0; i < N / 2.0; i++) { // N/2 ???
			c = c + 6;
			x = i;
					
			for(int j = i + 1; j < N - i; j++) { // N-i ????
				c = c + 5;
				if(a[x] > a[j]) {
					x = j;
					c = c + 1;
				}
			}
					
			c = c + 1;
			c = c + 1;
					
			if(i != x) {
				c = c + 7;
				t = a[i];
				a[i] = a[x];
				a[x] = t;
			}
		}
		c = c + 2;
	}
	
	public void devolverDatos() {
		System.out.println("Por contador se obtuvo "+this.c+" operaciones elementales.");
		System.out.println("Por formula se obtuvo "+this.formula+" operaciones elementales.");
	}
	
}
