package main;

import java.util.Scanner;

public class Main {
	
	public static Scanner sc = new Scanner(System.in); // Guarda dados de entrada do Console
	public static String entradaUsr = ""; // Guarda a entrada do usu�rio
	public static char[] entrada; // Guarda um caracter da entrada do usu�rio
	public static String estado_atual = ""; // Guarda o ultimo estado analizado
	public static String leitura = ""; // Guarda o valor de sa�da
	public static String[] estado_final = {"q1", "q3"}; // Guarda o(s) estado(s) final(is)

	public static void main(String[] args) {
		
		estado_atual = "q0"; // Estado atual = "q0"
		
		System.out.println("Entrada: "); // Exibe "Entrada: " no Console
		
		entradaUsr = sc.nextLine().toString(); // Recebe o valor da pr�xima linha digitada pelo usu�rio
		
		entrada = new char[entradaUsr.length()]; // Inicia o Array com tamanho equivalente � entrada de dados do usu�rio
		
		for (int i = 0;i < entradaUsr.length(); i++) { // enquanto 'i' for menor que a entrada de dados do usu�rio...
			entrada[i] = entradaUsr.charAt(i); // "entrada" recebe um caracter da entrada de dados do usu�rio para ser analizado
			
			if (estado_atual == "q0" && entrada[i] == 'a') { // Analiza a entrada e fornece a transi��o entre estados (q0, a) -> q1/0
				estado_atual = "q1";
				leitura = leitura + '0';
			} else if (estado_atual == "q0" && entrada[i] == 'b'){ // Analiza a entrada e fornece a transi��o entre estados (q0, b) -> q3/2
				estado_atual = "q3";
				leitura = leitura + '2';
			} else if (estado_atual == "q1" && entrada[i] == 'a'){ // Analiza a entrada e fornece a transi��o entre estados (q1, a) -> q3/2
				estado_atual = "q3";
				leitura = leitura + '2';
			} else if (estado_atual == "q1" && entrada[i] == 'b'){ // Analiza a entrada e fornece a transi��o entre estados (q1, b) -> q1/0
				estado_atual = "q1";
				leitura = leitura + '0';
			} else if (estado_atual == "q2" && entrada[i] == 'a'){ // Analiza a entrada e fornece a transi��o entre estados (q2, a) -> q0/1
				estado_atual = "q0";
				leitura = leitura + '1';
			} else if (estado_atual == "q2" && entrada[i] == 'b'){ // Analiza a entrada e fornece a transi��o entre estados (q2, b) -> q3/2
				estado_atual = "q3";
				leitura = leitura + '2';
			} else if (estado_atual == "q3" && entrada[i] == 'a'){ // Analiza a entrada e fornece a transi��o entre estados (q3, a) -> q3/2
				estado_atual = "q3";
				leitura = leitura + '2';
			} else if (estado_atual == "q3" && entrada[i] == 'b'){ // Analiza a entrada e fornece a transi��o entre estados (q3, b) -> q2/0
				estado_atual = "q2";
				leitura = leitura + '0';
			}
		}
		
		for (int i = 0; i < estado_final.length; i++) { // Analiza cada estado final
			if (estado_atual == estado_final[i]) { // Se ultimo estado analizado for igual ao �ltimo estado final analizado...
				System.out.println("Situa��o: Aprovada!"); // Exibe "Situa��o: Aprovada!" no Console
			} else { // Se n�o...
				System.out.println("Situa��o: Rejeitada!"); // Exibe "Situa��o: Rejeitada!" no Console
			}
		}
		
		System.out.println("Resultado: " + leitura); // Exibe os dados de sa�da
		
	}

}
