package models;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Manu {


	private int id;
	private String equipamento;
	private Date dataManu;
	private double custoHora;
	private double  tempoGasto;

	private final Locale BRASIL = new Locale("pt", "BR");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private DecimalFormat df = new DecimalFormat("#.00");
	public Manu(int id) {
		this.id = id;
	}

	public Manu(int id, String equipamento, String dataManu, double custoHora, double tempoGasto) {
		super();
		this.id = id;
		this.equipamento = equipamento;
		try {
			this.dataManu = sdf.parse(dataManu);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.custoHora = custoHora;
		this.tempoGasto = tempoGasto;
	}
	public Manu(String linha) {
		df.setCurrency(Currency.getInstance(BRASIL));
		
		this.id = Integer.parseInt(linha.split(";")[0]);
		this.equipamento = linha.split(";")[1];
		try {
			this.dataManu = sdf.parse(linha.split(";")[2]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.custoHora = Double .parseDouble(linha.split(";")[3]);
		this.tempoGasto = Double.parseDouble(linha.split(";")[4]);
	}

	public int getId() {
		return id;
	}

	public String getId(String s) {
		return String.format("%d", id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public Date getDataManu() {
		return dataManu;
	}

	public void setDataManu(Date dataManu) {
		this.dataManu = dataManu;
	}

	public Double getCustoHora() {
		return custoHora;
	}

	public void setCustoHora(Double custoHora) {
		this.custoHora = custoHora;
	}

	public Double getTempoGasto() {
		return tempoGasto;
	}

	public void setTempoGasto(String dataManu) {
		this.tempoGasto = tempoGasto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	public String getDataManu(String s) {
		return sdf.format(dataManu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manu other = (Manu) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return id + "\t" + equipamento + "\t" +  getDataManu("s") + "\t" + getCustoHora("S") + "\t" + getTempoGasto("s") + "\n";
	}

	public String toCSV() {
		return id + "\t" + equipamento + "\t" + getDataManu("s") + "\t" + getCustoHora("S") + "\t" + getTempoGasto("s") + "\n";
	}

	public String getCustoHora(String string) {
		// TODO Auto-generated method stub
		return df.format(custoHora);
	}

	public String getTempoGasto(String string) {
		// TODO Auto-generated method stub
		return df.format(tempoGasto);
	}

}
