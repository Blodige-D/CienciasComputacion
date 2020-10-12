import java.util.Random;

public class insercion {
	private int N;
	private int a[];
	private int c;
	private double formula;
	
	public insercion(String n) {
		this.N = Integer.parseInt(n); 
		this.a = new int[this.N + 1];
	}
	
	public void llenarArreglo(int orden) {
		if(orden == 1) {
			//Mejor caso
			this.formula = (double) 12*(N-1) + 4;
			
			for(int i = 0; i <= N; i++) {
				this.a[i] = i;
			}
		}
		
		else if(orden == 2) {
			//Peor caso
			this.formula = (double) 8*((N/2)*(N + 1) - N) + 12*(N - 1) + 4;
			
			for(int j = 0; j <= N; j++){ 
				  a[j] = N - j;
			}
		}
		
		else if(orden == 3) {
			//Caso medio
			this.formula = (double) 4*((N/2)*(N + 1) - N) + 12*(N - 1) + 4;
			
			Random aleatorio = new Random(System.currentTimeMillis());
			for(int i = 0; i <= N; i++) {
				this.a[i] = aleatorio.nextInt(2*N);
			}
		}
			
	}
	
	public void ordenarArreglo() {
		int j, temp, i = 2;
		this.a[0] = -32767;
		
		c = 3;
		while (i <= this.N) {
			c = c + 5;
			
			j = i - 1;
			temp = this.a[i];
			
			while (temp < this.a[j]) {
				c = c + 8;
				
				this.a[j + 1] = this.a[j];
				j = j - 1;
			}
			
			c = c + 2;
			
			this.a[j + 1] = temp;
			i = i + 1;
	
			c = c + 5;
		}
		
		c = c + 1;
		
	}
	
	public void devolverDatos() {
		System.out.println("Por contador se obtuvo "+this.c+" operaciones elementales.");
		System.out.println("Por formula se obtuvo "+this.formula+" operaciones elementales.");
	}
}
