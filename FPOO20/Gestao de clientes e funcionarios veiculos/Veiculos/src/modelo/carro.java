package modelo;

import java.util.ArrayList;

	public class carro extends veiculo {
		private int tipo;
		private int passageiros;

		public carro(String placa, int anoModelo, int anoFabricado, String modelo, String marca, double valor, int tipo, int passageiros) {
			super(placa, anoModelo, anoFabricado, modelo, marca, valor);
			this.tipo = tipo;
			this.passageiros = passageiros;
		}

		@Override
		public String toString() {
			return tipo + passageiros + super.toString();
		}
		
	}

	
