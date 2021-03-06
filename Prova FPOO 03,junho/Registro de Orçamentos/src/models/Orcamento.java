package models;

import java.util.Objects;

public class Orcamento {

	private int id;
	private String fornecedor;
	private String produto;
	private double preco;
	private boolean menorPreco;
	
	
	public Orcamento(int id, String fornecedor, String produto, double preco, boolean menorPreco) {
		this.id = id;
		this.fornecedor = fornecedor;
		this.produto = produto;
		this.preco = preco;
		this.menorPreco = menorPreco;
	}
	
	public Orcamento(String linha) {
		this.id = Integer.parseInt(linha.split(";")[0]);
		this.fornecedor = linha.split(";")[1];
		this.produto = linha.split(";")[2];
		this.preco = Double.parseDouble(linha.split(";")[3]);
		this.menorPreco = Boolean.parseBoolean(linha.split(";")[4]);
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(fornecedor, id, menorPreco, preco, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orcamento other = (Orcamento) obj;
		return  id == other.id;
	}

	public Orcamento(int iid) {
		this.id = iid;
	}

	public String getId(String s) {
		return String.valueOf(id);
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

	public double getPreco() {
		return preco;
	}
	
	public String getPreco(String s) {
		return String.format("%.2f", preco);
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isMenorPreco() {
		return menorPreco;
	}

	public void setMenorPreco(boolean menorPreco) {
		this.menorPreco = menorPreco;
	}

	
	public String barato() {
		if(menorPreco) {
			return "menor pre?o";
		}
		return null;
	}
	
	@Override
	public String toString() {
		return id + ";" + fornecedor + ";" + produto + ";" + preco + ";" + barato();
	}
	
	public String toCSV() {
		return id + ";" + fornecedor + ";" + produto + ";" + preco + ";" + menorPreco + "\r\n";
	}
	
}
