package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controle.PetProcess;
import modelo.Pet;

public class PetForm extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel id, especie, nomePet, raca, peso, nascimento, nomeDono, telefone, rotulos, imagem;
	private JTextField tfId, tfNomePet, tfRaca, tfPeso, tfNascimento, tfNomeDono, tfTelefone;
	private JComboBox<String> cbEspecie;
	private JTextArea verResultados;
	private JButton create, read, update, delete;
	private String imgIco = "./assets/icone.png";
	private String[] imagens = { "C:\\Users\\suporte\\Desktop\\SENAI-2022-1DES\\FPOO25\\Pets\\PETS\\assets\\assets\\coelho.png","C:\\Users\\suporte\\Desktop\\SENAI-2022-1DES\\FPOO25\\Pets\\PETS\\assets\\assets\\doguinho.png",
			"C:\\Users\\suporte\\Desktop\\SENAI-2022-1DES\\FPOO25\\Pets\\PETS\\assets\\assets\\miau.png","C:\\Users\\suporte\\Desktop\\SENAI-2022-1DES\\FPOO25\\Pets\\PETS\\assets\\assets\\ornitorrinco.png"
			};
	private ImageIcon icon;
	private int autoId = PetProcess.pets.size() + 1;
	private String texto = "";

	PetForm() {
		setTitle("Formul�rio de Pets");
		setBounds(200, 300, 800, 800);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		painel.setBackground(new Color(255, 233, 213));
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		id = new JLabel("Id:");
		id.setBounds(20, 20, 120, 30);
		painel.add(id);
		especie = new JLabel("Especie:");
		especie.setBounds(20, 50, 120, 30);
		painel.add(especie);
		nomePet = new JLabel("Nome pet:");
		nomePet.setBounds(20, 80, 120, 30);
		painel.add(nomePet);
		raca = new JLabel("Ra�a:");
		raca.setBounds(20, 110, 120, 30);
		painel.add(raca);
		peso = new JLabel("Peso:");
		peso.setBounds(20, 140, 120, 30);
		painel.add(peso);
		nascimento = new JLabel("Nascimento:");
		nascimento.setBounds(20, 170, 120, 30);
		painel.add(nascimento);
		nomeDono = new JLabel("Nome dono:");
		nomeDono.setBounds(20, 200, 120, 30);
		painel.add(nomeDono);
		telefone = new JLabel("Telefone:");
		telefone.setBounds(20, 230, 120, 30);
		painel.add(telefone);
		rotulos = new JLabel("Id|Esp�cie|NomePet|Ra�a|Peso|Idade|Dono|Telefone:");
		rotulos.setBounds(20, 260, 500, 30);
		painel.add(rotulos);

		tfId = new JTextField(String.format("%d", autoId));
		tfId.setEditable(false);
		tfId.setBounds(140, 20, 260, 30);
		painel.add(tfId);
		cbEspecie = new JComboBox<String>(new String[] { "Cachorro", "Gato", "Coelho", "Outro" });
		cbEspecie.setBounds(140, 50, 260, 30);
		painel.add(cbEspecie);
		tfNomePet = new JTextField();
		tfNomePet.setBounds(140, 80, 260, 30);
		painel.add(tfNomePet);
		tfRaca = new JTextField();
		tfRaca.setBounds(140, 110, 260, 30);
		painel.add(tfRaca);
		tfPeso = new JTextField();
		tfPeso.setBounds(140, 140, 260, 30);
		painel.add(tfPeso);
		tfNascimento = new JTextField();
		tfNascimento.setBounds(140, 170, 260, 30);
		painel.add(tfNascimento);
		tfNomeDono = new JTextField();
		tfNomeDono.setBounds(140, 200, 260, 30);
		painel.add(tfNomeDono);
		tfTelefone = new JTextField();
		tfTelefone.setBounds(140, 230, 260, 30);
		painel.add(tfTelefone);
		verResultados = new JTextArea();
		// verResultados.setEnabled(false);
		verResultados.setBounds(20, 290, 750, 150);
		verResultados.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		preencherAreaDeTexto();
		painel.add(verResultados);
		imagem = new JLabel();
		imagem.setBounds(410, 145, 150, 115);
		imagem.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		alternarImagens(0);
		painel.add(imagem);

		create = new JButton("Cadastrar");
		read = new JButton("Buscar");
		update = new JButton("Atualizar");
		delete = new JButton("Excluir");
		create.setBounds(410, 20, 150, 30);
		read.setBounds(410, 50, 150, 30);
		update.setBounds(410, 80, 150, 30);
		delete.setBounds(410, 110, 150, 30);
		update.setEnabled(false);
		delete.setEnabled(false);
		painel.add(create);
		painel.add(read);
		painel.add(update);
		painel.add(delete);

		// Ouvir os eventos dos Bot�es, ComboBox e outros
		cbEspecie.addActionListener(this);
		create.addActionListener(this);
		read.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);

	}

	private void alternarImagens(int indice) {
		icon = new ImageIcon(new ImageIcon(imagens[indice]).getImage().getScaledInstance(150, 115, 100));
		imagem.setIcon(icon);
	}

	// CREATE - CRUD
	private void cadastrar() {
		if (tfNomePet.getText().length() != 0 && tfRaca.getText().length() != 0 && tfPeso.getText().length() != 0
				&& tfNascimento.getText().length() != 0 && tfNomeDono.getText().length() != 0
				&& tfTelefone.getText().length() != 0) {
			PetProcess.pets.add(new Pet(autoId, cbEspecie.getSelectedItem().toString(), tfNomePet.getText(),
					tfRaca.getText(), Float.parseFloat(tfPeso.getText()), tfNascimento.getText(), tfNomeDono.getText(),
					tfTelefone.getText()));
			autoId++;
			preencherAreaDeTexto();
			limparCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
	}

	private void limparCampos() {
		tfNomePet.setText(null);
		tfRaca.setText(null);
		tfPeso.setText(null);
		tfNascimento.setText(null);
		tfNomeDono.setText(null);
		tfTelefone.setText(null);
	}

	private void preencherAreaDeTexto() {
		texto = ""; // Limpar a �rea de texto antes de preenher
		for (Pet p : PetProcess.pets) {
			texto += p.toString();
		}
		verResultados.setText(texto);
	}

	private void buscar() {
		String entrada = JOptionPane.showInputDialog("Digite o Id do animal:");
		int id = Integer.parseInt(entrada);
		Pet pet = new Pet(id);
		if(PetProcess.pets.contains(pet)) {
			int indice = PetProcess.pets.indexOf(pet);
			tfNomePet.setText(PetProcess.pets.get(indice).getNomePet());
			tfRaca.setText(PetProcess.pets.get(indice).getRaca());
			tfPeso.setText(PetProcess.pets.get(indice).getPeso("s"));
			tfNascimento.setText(PetProcess.pets.get(indice).getNascimento("s"));
			tfNomeDono.setText(PetProcess.pets.get(indice).getNomeDono());
			tfTelefone.setText(PetProcess.pets.get(indice).getTelefone());
		} else {
			JOptionPane.showMessageDialog(this,"Pet n�o encontrado");
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cbEspecie) {
			alternarImagens(cbEspecie.getSelectedIndex());
		}
		if (e.getSource() == create) {
			cadastrar();
		}
		if (e.getSource() == read) {
			buscar();
		}
		if (e.getSource() == update) {

		}
		if (e.getSource() == delete) {

		}
	}

	public static void main(String[] agrs) throws ParseException {
		PetProcess.carregarTestes();
		new PetForm().setVisible(true);
	}
}