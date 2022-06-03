package models;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

public class Orcamento {

	private int id;
	private Date data;
	private String fornecedor;
	private String produto;
	private double valor;

	private final Locale BRASIL = new Locale("pt", "BR");
	private DecimalFormat df = new DecimalFormat("#.00");

	public Orcamento(int id, String data, String fornrcrdor, String produto) {
	}
	public Orcamento(int idd) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
	public double getValor() {
		return valor;
	}
	public double setValor(double valor) {
		return this.valor = valor;
	}

	public DecimalFormat getDf() {
		return df;
	}

	public void setDf(DecimalFormat df) {
		this.df = df;
	}

	public Locale getBRASIL() {
		return BRASIL;
	}

	public String toString() {
		return id + "\t" +  "\t" + fornecedor
				+ "\t" + produto + "\t" + valor + "\n";
	}

	public String toCSV() {
		return id + ";" +  ";"  + fornecedor + ";" + produto + ";" + valor + "\r\n";
	}

}


