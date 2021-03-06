package viewers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.Process;
import models.Manu;

public class Tela extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel id, equipamento, dataManu, custoHora, tempoGasto, rotulos,imagem;
	private JTextField tfId, tfEquipamento, tfDataManu, tfCustoHora, tfTempoGasto;
	private JComboBox<String> cbEquipamento;
	private JScrollPane rolagem;
	private JTextArea verResultados;
	private JButton create, read, update, delete;
	private String imgIco = "./assets/icone.png";
	private String[] imagens = { "./imagens/roçadeira.jpg", "./imagens/trator.jpg", "./imagens/caminhao.jpg",
			"./imagens/outros.jpg" };
	private ImageIcon icon;
	private int autoId = Process.manu.size() + 1;
	private String texto = "";

	private final Locale BRASIL = new Locale("pt", "BR");
	private DecimalFormat df = new DecimalFormat("#.00");

	Tela() {
		setTitle("Formulário de Manutenção");
		setBounds(100, 100, 800, 600);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		painel.setBackground(new Color(0, 255, 127));
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		id = new JLabel("Id:");
		id.setBounds(20, 20, 120, 30);
		painel.add(id);
		equipamento = new JLabel("Equipamento:");
		equipamento.setBounds(20, 55, 120, 30);
		painel.add(equipamento);
		dataManu = new JLabel("Data Manutenção:");
		dataManu.setBounds(20, 90, 120, 30);
		painel.add(dataManu);
		custoHora = new JLabel("Valor da Hora:");
		custoHora.setBounds(20, 125, 120, 30);
		painel.add(custoHora);
		tempoGasto = new JLabel("Tempo Gasto:");
		tempoGasto.setBounds(20, 165, 120, 30);
		rotulos = new JLabel("Id | Equipamento | Data | CustoHora | TempoGasto:");
		rotulos.setBounds(20, 310, 500, 30);
		painel.add(rotulos);

		tfId = new JTextField(String.format("%d", autoId));
		tfId.setEditable(false);
		tfId.setBounds(140, 25, 140, 30);
		painel.add(tfId);
		cbEquipamento = new JComboBox<String>(new String[] { "Roçadeira", "Trator", "Caminhão", "Outro" });
		cbEquipamento.setBounds(140, 60, 255, 30);
		painel.add(cbEquipamento);
		tfDataManu = new JTextField();
		tfDataManu.setBounds(140, 95, 255, 30);
		painel.add(tfDataManu);
		tfCustoHora = new JTextField();
		tfCustoHora.setBounds(140, 130, 255, 30);
		painel.add(tfCustoHora);
		tfTempoGasto = new JTextField();
		tfTempoGasto.setBounds(140, 165, 255, 30);
		painel.add(tfTempoGasto);
		verResultados = new JTextArea();
		verResultados.setEditable(false);
		verResultados.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		preencherAreaDeTexto();
		rolagem = new JScrollPane(verResultados);
		rolagem.setBounds(20, 340, 740, 200);
		painel.add(rolagem);
		imagem = new JLabel();
		imagem.setBounds(405, 60, 350, 240);
		imagem.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		alternarImagens(0);
		painel.add(imagem);

		create = new JButton("Cadastrar");
		read = new JButton("Buscar");
		update = new JButton("Atualizar");
		delete = new JButton("Excluir");
		create.setBounds(285, 25, 110, 30);
		read.setBounds(405, 25, 110, 30);
		update.setBounds(525, 25, 110, 30);
		delete.setBounds(645, 25, 110, 30);
		update.setEnabled(false);
		delete.setEnabled(false);
		painel.add(create);
		painel.add(read);
		painel.add(update);
		painel.add(delete);

		// Ouvir os eventos dos Botões, ComboBox e outros
		cbEquipamento.addActionListener(this);
		create.addActionListener(this);
		read.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);

	}

	private void alternarImagens(int indice) {
		icon = new ImageIcon(new ImageIcon(imagens[indice]).getImage().getScaledInstance(350, 240, 100));
		imagem.setIcon(icon);
	}

	// CREATE - CRUD
	private void cadastrar() {
		if ( tfDataManu.getText().length() != 0 && tfCustoHora.getText().length() != 0
				&& tfTempoGasto.getText().length() != 0) {

			df.setCurrency(Currency.getInstance(BRASIL));
			double t,c;
			try {
				t = Double.parseDouble(df.parse(tfTempoGasto.getText()).toString());
				c = Double.parseDouble(df.parse(tfCustoHora.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				t = 0;
				c = 0;
			}

			Process.manu.add(new Manu(autoId, cbEquipamento.getSelectedItem().toString(), tfDataManu.getText(),
					c, t));
			autoId++;
			preencherAreaDeTexto();
			limparCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
	}

	private void limparCampos() {
		tfEquipamento.setText(null);
		tfDataManu.setText(null);
		tfCustoHora.setText(null);
		tfTempoGasto.setText(null);
	}

	private void preencherAreaDeTexto() {
		texto = ""; // Limpar a área de texto antes de preenher
		for (Manu p : Process.manu) {
			texto += p.toString();
		}
		verResultados.setText(texto);
	}

	// Retornar índice da espécie
	int obterIndiceEquipamento(String equipamento) {
		switch (equipamento) {
		case "Roçadeira":
			return 0;
		case "Trator":
			return 1;
		case "Caminhão":
			return 2;
		case "Outro":
			return 3;
		default:
			return -1;
		}
	}

	// READ - CRUD
	private void buscar() {
		String entrada = JOptionPane.showInputDialog(this,"Digite o Id da Manutenção:");

		boolean isNumeric = true;
		if (entrada != null) {
			for (int i = 0; i < entrada.length(); i++) {
				if (!Character.isDigit(entrada.charAt(i))) {
					isNumeric = false;
				}
			}
		}else {
			isNumeric = false;
		}
		if (isNumeric) {
			int id = Integer.parseInt(entrada);
			Manu manu = new Manu(id);
			if (Process.manu.contains(manu)) {
				int indice = Process.manu.indexOf(manu);
				tfId.setText(Process.manu.get(indice).getId("s"));
				cbEquipamento.setSelectedIndex(obterIndiceEquipamento(Process.manu.get(indice).getEquipamento()));
				tfDataManu.setText(Process.manu.get(indice).getDataManu("s"));
				tfCustoHora.setText(Process.manu.get(indice).getCustoHora("s"));
				tfTempoGasto.setText(Process.manu.get(indice).getTempoGasto("S"));
				create.setEnabled(false);
				update.setEnabled(true);
				delete.setEnabled(true);
				Process.salvar();
			} else {
				JOptionPane.showMessageDialog(this, "Serviço não encontrado");
			}
		}

	}

	// UPDATE - CRUD
	private void alterar() {
		int id = Integer.parseInt(tfId.getText());
		Manu pet = new Manu(id);
		int indice = Process.manu.indexOf(pet);
		if (tfEquipamento.getText().length() != 0 && tfDataManu.getText().length() != 0 && tfCustoHora.getText().length() != 0
				&& tfTempoGasto.getText().length() != 0) {

			// Converter o peso no formato Brasileiro usando virgula como decimal
			df.setCurrency(Currency.getInstance(BRASIL));
			double t,c;
			try {
				t = Double.parseDouble(df.parse(tfTempoGasto.getText()).toString());
				c = Double.parseDouble(df.parse(tfCustoHora.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				t = 0;
				c = 0;
			}

			Process.manu.set(indice, new Manu(autoId, cbEquipamento.getSelectedItem().toString(), tfDataManu.getText(),
					t, c));
			preencherAreaDeTexto();
			limparCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
		tfId.setText(String.format("%d", autoId));
		Process.salvar();
	}

	// DELETE - CRUD
	private void excluir() {
		int id = Integer.parseInt(tfId.getText());
		Manu manu = new Manu(id);
		int indice = Process.manu.indexOf(manu);
		Process.manu.remove(indice);
		preencherAreaDeTexto();
		limparCampos();
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
		tfId.setText(String.format("%d", autoId));
		Process.salvar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cbEquipamento) {
			alternarImagens(cbEquipamento.getSelectedIndex());
		}
		if (e.getSource() == create) {
			cadastrar();
		}
		if (e.getSource() == read) {
			buscar();
		}
		if (e.getSource() == update) {
			alterar();
		}
		if (e.getSource() == delete) {
			excluir();
		}
	}

	public static void main(String[] agrs) throws ParseException {
		// PetProcess.carregarTestes();
		Process.abrir();
		new Tela().setVisible(true);
	}

}