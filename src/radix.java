
import java.io.IOException;
import java.util.Random;

public class radix {
	
	private int N;
	private int a[];
	private int c=0;
	private double formula;
	
	public radix(String n) throws IOException {
		this.N = Integer.parseInt(n); 
		this.a = new int[N];
	}
	
	public void llenarArreglo(int orden) {
		if(orden == 1) {
			//Mejor caso
			this.formula = 400*N+251;
			for(int i = 0; i < N; i++) {
				this.a[i] = i;
			}
		}
		
		else if(orden == 2) {
			//Peor caso
			this.formula = 400*N+251;
			
			int f = 1;
			for(int i = N - 1; i > -1; i--) {
				this.a[i] = f;
				f++;
			}
		}
		
		else if(orden == 3) {
			//Caso medio
			this.formula = 400*N+251;
			
			Random aleatorio = new Random(System.currentTimeMillis());
			for(int i = 0; i < N; i++) {
				this.a[i] = aleatorio.nextInt(2*N);
			}
		}
	}
	
	public void ordenarArreglo() {
		int x,i,j;
		
		c = c + 2;
		for(x=31; x>=0; x--) {
			c = c + 2;
			c = c + 1;
			//Vector auxiliar
			int aux[] = new int[N];
			c = c + 1;
			j=0;
			c = c + 1;
			for(i=0; i<N; i++) {
				c = c + 2;
				c = c + 4;
				boolean mover = (a[i] << x) >=0;
				c = c + 2;
				if(x==0 ? !mover:mover) {
					c = c + 4;
					aux[j] = a[i];
					j++;
				}else {
					c = c + 4;
					a[i-j] = a[i];
				}
			}
			c = c + 1;
			c = c + 1;
			for(i=j; i<N;i++) {
				c = c + 5;
				aux[i]=a[i-j];
			}
			c = c + 1;
			a = aux;
		}
		c = c + 1;
	}
	public void devolverDatos() {
		System.out.println("");
		System.out.println("Por contador se obtuvo "+this.c+" operaciones elementales.");
		System.out.println("Por formula se obtuvo "+this.formula+" operaciones elementales.");
	}
}
