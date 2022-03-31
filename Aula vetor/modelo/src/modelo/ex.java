package modelo;

import java.util.Scanner;

public class ex {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int comprimento = 3;
	
	String[] nomes = new String[3];
	int[] idades = new int[comprimento];
	
	for(int i = 0; i < comprimento; i++) {
		System.out.println("Nome[" + i +"]: ");
		nomes[i] = scan.next();
		
		
			System.out.println("idade[" + i +"]: ");
			idades[i] = scan.nextInt();
			}

	for(int i = 0; i < comprimento; i++) {
		if(idades[i] <10) {
			System.out.println(nomes[i] + " criança." );
		}
		else if(idades[i] <20) {
			System.out.println(nomes[i] + " jovem." );
			
		}
		else{
			System.out.println(nomes[i] + " velho." );
		}
	}
		}
	}