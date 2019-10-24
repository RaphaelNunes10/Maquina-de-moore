package main;

import java.util.Scanner;

public class Main {
	
	public static Scanner sc = new Scanner(System.in); // Guarda dados de entrada do Console
	public static String entradaUsr = ""; // Guarda a entrada do usuário
	public static char[] entrada; // Guarda um caracter da entrada do usuário
	public static String estado_atual = ""; // Guarda o ultimo estado analizado
	public static String leitura = ""; // Guarda o valor de saída
	public static String[] estado_final = {"q1", "q3"}; // Guarda o(s) estado(s) final(is)

	public static void main(String[] args) {
		
		estado_atual = "q0"; // Estado atual = "q0"
		
		System.out.println("Entrada: "); // Exibe "Entrada: " no Console
		
		entradaUsr = sc.nextLine().toString(); // Recebe o valor da próxima linha digitada pelo usuário
		
		entrada = new char[entradaUsr.length()]; // Inicia o Array com tamanho equivalente à entrada de dados do usuário
		
		for (int i = 0;i < entradaUsr.length(); i++) { // enquanto 'i' for menor que a entrada de dados do usuário...
			entrada[i] = entradaUsr.charAt(i); // "entrada" recebe um caracter da entrada de dados do usuário para ser analizado
			
			if (estado_atual == "q0" && entrada[i] == 'a') { // Analiza a entrada e fornece a transição entre estados (q0, a) -> q1/0
				estado_atual = "q1";
				leitura = leitura + '0';
			} else if (estado_atual == "q0" && entrada[i] == 'b'){ // Analiza a entrada e fornece a transição entre estados (q0, b) -> q3/2
				estado_atual = "q3";
				leitura = leitura + '2';
			} else if (estado_atual == "q1" && entrada[i] == 'a'){ // Analiza a entrada e fornece a transição entre estados (q1, a) -> q3/2
				estado_atual = "q3";
				leitura = leitura + '2';
			} else if (estado_atual == "q1" && entrada[i] == 'b'){ // Analiza a entrada e fornece a transição entre estados (q1, b) -> q1/0
				estado_atual = "q1";
				leitura = leitura + '0';
			} else if (estado_atual == "q2" && entrada[i] == 'a'){ // Analiza a entrada e fornece a transição entre estados (q2, a) -> q0/1
				estado_atual = "q0";
				leitura = leitura + '1';
			} else if (estado_atual == "q2" && entrada[i] == 'b'){ // Analiza a entrada e fornece a transição entre estados (q2, b) -> q3/2
				estado_atual = "q3";
				leitura = leitura + '2';
			} else if (estado_atual == "q3" && entrada[i] == 'a'){ // Analiza a entrada e fornece a transição entre estados (q3, a) -> q3/2
				estado_atual = "q3";
				leitura = leitura + '2';
			} else if (estado_atual == "q3" && entrada[i] == 'b'){ // Analiza a entrada e fornece a transição entre estados (q3, b) -> q2/0
				estado_atual = "q2";
				leitura = leitura + '0';
			}
		}
		
		for (int i = 0; i < estado_final.length; i++) { // Analiza cada estado final
			if (estado_atual == estado_final[i]) { // Se ultimo estado analizado for igual ao último estado final analizado...
				System.out.println("Situação: Aprovada!"); // Exibe "Situação: Aprovada!" no Console
			} else { // Se não...
				System.out.println("Situação: Rejeitada!"); // Exibe "Situação: Rejeitada!" no Console
			}
		}
		
		System.out.println("Resultado: " + leitura); // Exibe os dados de saída
		
	}

}
