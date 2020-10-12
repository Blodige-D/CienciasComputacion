
import java.io.IOException;
import java.util.Random;

public class burbuja {
	
	private int N;
	private int a[];
	private int c;
	private int t;
	private double formula;
	
	public burbuja(String n) throws IOException {
		this.N = Integer.parseInt(n); 
		this.a = new int[N];
	}
	
	public void llenarArreglo(int orden) {
		if(orden == 1) {
			//Mejor caso
			this.formula = (5*this.N*this.N + 7*this.N - 6)/2;
			for(int i = 0; i < N; i++) {
				this.a[i] = i;
			}
		}
		
		else if(orden == 2) {
			//Peor caso
			this.formula = (6*this.N*this.N - 3);
			
			int f = 1;
			for(int i = N - 1; i > -1; i--) {
				this.a[i] = f;
				f++;
			}
		}
		
		else if(orden == 3) {
			//Caso medio
			this.formula = (double)((17*this.N*this.N) + (7*this.N) - 12)/4;
			
			Random aleatorio = new Random(System.currentTimeMillis());
			for(int i = 0; i < N; i++) {
				this.a[i] = aleatorio.nextInt(2*N);
			}
		}
	}
	
	public void ordenarArreglo() {
		this.c = 0;
		
		//Para i = 0
		this.c = this.c + 1; 
		
		for(int i = 0; i < this.N - 1; i++) {
			//Para i < (N - 1), i++, j = i + 1
			this.c = this.c + 5;
			
			for(int j = i + 1; j < this.N; j++) {
				//Para j < N, j++
				this.c = this.c + 2;
				
				if(this.a[i] > this.a[j]) {
					this.t = this.a[i];
					this.a[i] = this.a[j];
					this.a[j] = this.t;
					
					//Para t = a[i], a[i] = a[j], a[j] = t
			        this.c = this.c + 7;
			    }
				
				//Para if, a[i], a[j]
				this.c = this.c + 3;
			}
			
			//Condicion falsa j < this.N
			this.c = this.c + 1;
		}
		
		//Condicion falsa i < this.N - 1
		this.c = this.c + 2;
	}
	public void devolverDatos() {
		System.out.println("Por contador se obtuvo "+this.c+" operaciones elementales.");
		System.out.println("Por formula se obtuvo "+this.formula+" operaciones elementales.");
	}
}
