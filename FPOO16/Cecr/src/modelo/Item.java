package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
	public String nome;
	public String local;
	public int valor;
	public Date dataCompra;
	
	private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	

	@SuppressWarnings("deprecation") 
	public int idadeDoItem() {
		Date hoje = new Date();
		return hoje.getYear() - dataCompra.getYear();
	}
	
	public String paraString() {
		return nome + "\t" + local + "\t" + valor + "\t" + df.format(dataCompra)+"\t"+idadeDoItem();
	} 
	
}