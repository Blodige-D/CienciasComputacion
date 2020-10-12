
public class Determinante {

	public static void main(String[] args) {
		double [][]matriz = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		
		int i, j, k, N=4, ver=0, c, ver1 = 1, m = 0;
		double traza = 1, formulaM, formulaP, formulaR;
		
		formulaM = (double) 16/6*(N*(N-1)*(2*N-1)) + 5*(N*N-N-(N*(N-1)/2)) + 9*(N-1)+6*N+5;
		formulaP = (double) 16/6*(N*(N-1)*(2*N-1)) + 5*(N*N-N-(N*(N-1)/2)) + 9*(N*N-N-(N*(N-1))/2) + 15 + 9*(N-1)+6*N+5;
		formulaR = (double) 16/6*(N*(N-1)*(2*N-1)) + 5*(N*N-N-(N*(N-1)/2)) + 9*(N-1)+6*N+5 + (9*(N*N-N-(N*(N-1))/2)+15)/2;
		
		c = 3;
		
		for(i = 0; i < N - 1; i++) {
			ver1 = 1;
			c = c + 6;
			if(matriz[i][i] == 0){
				
				c = c + 1;
				for(int z = i; z < N - 1; z++) {
					c = c + 9;
					if(matriz[z][i] != 0 && ver1==0) {
						c = c + 12;
						double[] aux = matriz[i];
						matriz[i] = matriz[z];
						matriz[z] = aux;
						traza = traza*(-1);
						ver1=1;
					}
				}
				c = c + 2;
			}

			c = c + 3;
			
			for(j = i + 1; j < N; j++) {
				c = c + 5;
				for(k = i + 1; k < N; k++) {
					c = c + 2;
					matriz[k][j] = (double) (matriz[k][j] - (matriz[k][i]*matriz[i][j])/matriz[i][i]);
					c = c + 14;
				}
			}	
		}
			
		for(i = 0; i < N; i++) {
			c = c + 6;
			traza = (double) traza*matriz[i][i];
		}
		
		for(i = 0; i < N; i++) {
			if(matriz[i][i]==0) {
				c=c+3;
				traza = 0;
			}
		}	
				
			
		
		
		c = c + 2;
		
		
		if(traza == -0) {
			traza = 0;
		}
		
		if(ver == 1) {
			System.out.println("El determinante no se puede calcular por Gauss. El resultado es: "+traza);
			System.out.println("El valor del contador de operaciones elementales es: "+c);
			System.out.println("El valor de la formula de operaciones elementales en el mejor caso es: "+formulaM);
			System.out.println("El valor de la formula de operaciones elementales en el peor caso es: "+formulaP);
			System.out.println("El valor de la formula de operaciones elementales en el caso medio es: "+formulaR);
		}
		else {
			System.out.println("El valor del determinante es: "+traza);
			System.out.println("El valor del contador de operaciones elementales es: "+c);
			System.out.println("El valor de la formula de operaciones elementales en el mejor caso es: "+formulaM);
			System.out.println("El valor de la formula de operaciones elementales en el peor caso es: "+formulaP);
			System.out.println("El valor de la formula de operaciones elementales en el caso medio es: "+formulaR);
		}
			
	}

}
