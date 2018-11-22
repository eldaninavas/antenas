import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;



public class  proyecto{


	public static void mostrar_matriz(int[][] matriz_a_mostrar){ //Función para mostrar la matriz 
	for (int i=0;i<matriz_a_mostrar.length ;i++ ) {
		System.out.println(); 
		for (int j=0;j<matriz_a_mostrar[0].length ;j++ ) {
			System.out.print(matriz_a_mostrar[i][j]+ " ");}}
	System.out.println(); 
	}
	
	public static int[][] aplicar_cobertura(int[][] matriz, int cobertura){ //Función para cambiar los 0 por 2
	cobertura = (cobertura-1)/2;
	for (int i=0;i<matriz.length ;i++ ){
		for (int j=0;j<matriz[0].length ;j++ ){
			if (matriz[i][j]==1){
				if ((i-cobertura)>=0){
					if ((j-cobertura)>=0){ 
					for (int a=0;a<=cobertura;a++ ){
						for (int b=0;b<=cobertura ;b++ ){ 
							if (matriz[i-cobertura+a][j-cobertura+b] != 1){ 
								matriz[i-cobertura+a][j-cobertura+b] = 2;}}}}} //Para arriba 	

				if ((j-cobertura)>=0){matriz[i][j-cobertura] = 2;} // Para la Izq.
				if ((i+cobertura)<(matriz.length-1)){matriz[i+cobertura][j] = 2;} // Para abajo
				if ((j+cobertura)<(matriz[0].length-1)){matriz[i][j+cobertura] = 2;} // Para Derecha
			 
			} 
		
		} 
	} 
	
	return matriz;	
	}

	public static void main(String[] args) throws IOException{
	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Ingrese el número de filas de la ciudad "); 
	int fila = Integer.parseInt(r.readLine());
	System.out.println("Ingrese el número de columnas de las ciudad "); 
	int col = Integer.parseInt(r.readLine());
	int [][] ciudad = new int[fila][col];// Se crea la matriz con los datos solicitados
	System.out.println("Ingrese la cobertura de una Antena (recuerde que debe ser un número impar) "); 
	int cobertura = Integer.parseInt(r.readLine());
	if (cobertura% 2 != 0){// Condición para que la cobertura sea impar
		System.out.println("Ingrese el número de antenas ya existentes en la ciudad "); 
		int no_antenas = Integer.parseInt(r.readLine());
		for (int i=1;i<=no_antenas ;i++ ){ // Ciclo colocador de antenas iniciales
			System.out.println("Ingrese la fila de la antena: " + i); 
			int x = Integer.parseInt(r.readLine());
			System.out.println("Ingrese la columna de la antena: " +i );
			int y =	Integer.parseInt(r.readLine());
			if (x>fila || x<0 || y>col || y<0){System.out.println("No puedes colocar las antenas fuera de la ciudad "); } 
			ciudad[x][y] = 1;
			mostrar_matriz(ciudad);} 
		ciudad = aplicar_cobertura(ciudad,cobertura);
		mostrar_matriz(ciudad);

	
	
	
	}
	else{System.out.println("Te dije que debía ser un número impar, ahora vuelve a empezar "); }	
	}} 
