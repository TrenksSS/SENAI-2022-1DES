package ex1;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ex{

	public static Scanner scan;
	public static void main(String[] args) throws IOException{
		scan = new Scanner(System.in);
		
		Random rand = new Random();
		int x [][] = new int [5][5];
		
		for(int i = 0; i <5;i++) {
			for(int j = 0; j <5;j++) {
				x[i][j]= rand.nextInt(100);
			}
		}
		
		for(int i = 0; i <5;i++) {
			for(int j = 0; j <5;j++) {
				System.out.print(x[i][j] + "\t");
			}
			System.out.println();
		}
		
		int menu = 0;
		while(menu != 4) {
			System.out.print("1.Menor e maior\n2.Numeros impares e pares:\n3.Media e mediana\n4.Sair");
			menu = scan.nextInt();
			switch(menu) {
			case 1: 
				Maiores(x);
				break;
			case 2:
				Pares(x);
				break;
			case 3:
				Media(x);
				break;
			case 4:

				break;
			default:

				break;
			}
		}
	}

		public static void Maiores(int[][]x) {
			int quan =5;
			int mmp =0;
			int mp =100;
			int mmi =0;
			int mi =100;
			
				for(int i=0; i<quan; i+=2){
					for(int j=0; j<quan; j+=2){
					 int z = x[i][j]%2;
				if(z!=0) { 
					for(int k=0; k<x.length;k++) {
						for(int l=0; l<x.length;l++){
							if(x[k][l]>mmi){
								mmi=x[k][l];
								
							}
				if(x[k][l]<mi) {
					mi=x[k][l];
				}
						
						}
					}
						
				}else {
					for(int k=0; k<x.length;k+=2){
						for(int l=0; l<x.length;l+=2){
							if(x[k][l]>mmp) {
								mmp=x[k][l];
							}
							if(x[k][l]<mp) {
								mp=x[k][l];
							}
								
						}
					}
				}
					}
					
				}
				System.out.println("O maior par ? " +mmp);
				System.out.println("O menor par ? " +mp);
				System.out.println("O maior impar ? " +mmi);
				System.out.println("O menor impar ? " +mi);
			}
	public static void Pares(int[][]x) {
		System.out.println("Os pares s?o:");
		int quan =5;
		for(int i=0; i<quan;i++) {
			for(int j=0; j<quan;j++) {
				int r=x[i][j]%2;
					if(r==0) {
						int y=x[i][j];
						//System.out.println("Os pares s?o ");
						System.out.println(y);
					}
			}
		}
		System.out.println("Os impares s?o:");
		for(int k=0;k<quan;k++) {
			for(int l=0;l<quan;l++) {
				int t=x[k][l]%2;
					if(t!=0) {
						int v=x[k][l];
						//System.out.println("Os impares s?o ");
						System.out.println(v);
					}
			}
		}

		}
	public static void Media(int[][]x) {
		
	}

}