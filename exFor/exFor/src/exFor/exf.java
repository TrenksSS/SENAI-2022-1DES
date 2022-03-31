package exFor;




	import java.util.Random;
	import java.util.Scanner;

	public class exf {
		public static Scanner  scan;
		public static void main(String[] args) {
		scan = new Scanner(System.in);
		Random  rand = new Random();
		 int menu = 0;
		 
		  while (menu!=4) {
			  System.out.print("1- Números pares\n2- Números Impares\n3- Maior Menor\n4-Fatorial\n5-xerox\n6-soma");
			  menu = scan.nextInt();
			  switch(menu) {
			  case 1:
				  par();
				  	break;
			  case 2:
				 impar();
				  break;
				  
			  case 3:
				maiormenor();
				  break;
			  case 4: 
				  fatorial();
				   break;
			  case 5:
				  tabela();
				  break;
				  case 6:
					  soma();
					  break;
				default :
					System.out.println("Opção Inválida");
					break;
			  }
		  }
		}
		public static void par() {
		System.out.println("Digite dois números: ");
		 int v1= scan.nextInt();
		 int v2= scan.nextInt();
		 int p = v1;
		 if (p%2 !=0) {
			 p++;
		
		 for(int i = p; i <= v2; i+=2) {
			 System.out.println(i);
		 }  
				 }else {
					 for(int i = p; i <= v2; i+=2) {
						 System.out.println(i);
					 }
				 }
		}
	public static void impar() {
		
		int []v = new int[2];
		System.out.println("Digite dois números: ");
		v[0]= scan.nextInt();
		v[1]= scan.nextInt();
		
		int m = v[0];
			if(m%2 ==0) {
				m++;
				
				 for(int i = m; i <= v[1]; i+=2) {
					 System.out.println(i);
			}
				
					}else {
						 for(int i = m; i <= v[1]; i+=2) {
							 System.out.println(i);
						 }
					}
	}
	public static void maiormenor() {
		Random  rand = new Random();
		int v1;
		int Mm=0;
		int m=100;
		for(int i = 0; i<10;i++) {
			v1 = rand.nextInt(10);
			System.out.print(v1 + "\t");
			
			if (v1>Mm) {
				Mm=v1;
			}
			
			if (v1<m) {
				m=v1;
			}
		}
		System.out.println();
		System.out.println("Maior: " + Mm);
		System.out.println("Menor: " + m);
	}
	public static void fatorial() {
		
		System.out.println("Digite um valor: ");
		int v = scan.nextInt();
		int f=1;
		for( int i = v; i > 0; i-- ) {
			 f = f * i;
			 System.out.println(i+ " ");
		} 
		System.out.printf("O fatorial é: %d", f);
			 
		
	}
	public static void tabela() {
		
//		
//		System.out.println("Digite o valor do xerox: R$ ");
//		double x = scan.nextDouble();
//		double y = 0;
//		for (double i = 1; i <200;i++) {
//			y = y + x;
//			x=y;
//		for(int j = 0; j <10; j++) {
//					x = y;
//						System.out.printf("%.2f%n" ,x);
//			}
//		}
	}
	public static void  soma() {
		
		System.out.println("Digite dois valores ");
		int v1= scan.nextInt();
		int v2=scan.nextInt();
		int s=0;
		int s1=0;
		
			for(int i = v1;i<=v2;i+=2 ) {
				if(i%2==0) {
					s=s + i;
				}
			}
				System.out.println("A soma dos pares é " +s);
				
				for(int j = v1;j<=v2;j++ ) {
					if(j%2!=0) {
						s1=s1 + j;		
					}
				}
				System.out.println("A soma dos impares é " +s1);
	}
	}