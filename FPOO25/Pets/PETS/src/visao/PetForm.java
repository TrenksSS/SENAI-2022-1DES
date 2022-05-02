package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PetForm extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	// Atributos da tela
	private JPanel painel;
	private JLabel rotulo1, rotulo2, rotulo3, rotulo4, rotulo5,rotulo6,rotulo7,rotulo8;
	private JTextField id, senha, nome, raca,peso,nascimento,dono,telefone;
	private JButton login;
	private JComboBox especie;

	PetForm() {

		// Propriedades Básicas
		setTitle("Tela de Login");
		setBounds(600, 600, 660, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel = new JPanel(); //Painel de elementos
		setContentPane(painel); //Configua o painel
		setLayout(null);

		// Conteúdos da tela
		rotulo1 = new JLabel("Id:");
		rotulo1.setBounds(20, 20, 100, 20);
		id = new JTextField();
		id.setBounds(50, 20, 200, 30);
		
		rotulo3 = new JLabel ("Espeie");
		rotulo3.setBounds(20, 40, 150, 20);
		especie = new JComboBox();
		especie.setBounds(20, 40, 300, 20);
		
		
		rotulo2 = new JLabel("Raça:");
		rotulo2.setBounds(20, 60, 100, 20);
		raca = new JTextField();
		raca.setBounds(70, 60, 200, 30);
		
		rotulo4 = new JLabel("Nome:");
		rotulo4.setBounds(20, 90, 200, 20);
		nome = new JTextField();
		nome.setBounds(70, 90, 300, 20);
	
		
		rotulo5 = new JLabel("Peso:");
		rotulo5.setBounds(20, 110, 250, 20);
		peso = new JTextField();
		peso.setBounds(70, 110, 300, 20);
		
		rotulo6 = new JLabel("Nascimento:");
		rotulo6.setBounds(20, 140, 300, 20);
		nascimento = new JTextField();
		nascimento.setBounds(70, 140, 300, 20);
		
		rotulo7 = new JLabel("Dono:");
		rotulo7.setBounds(20, 170, 350, 20);
		dono = new JTextField();
		dono.setBounds(70, 170, 300, 20);
		
		rotulo8 = new JLabel("Telefone:");
		rotulo8.setBounds(20, 200, 400, 20);
		telefone = new JTextField();
		telefone.setBounds(70, 200, 300, 20);
		
		login = new JButton("Login");
		login.setBounds(400, 100, 200, 30);
		
		//Habilitando o evento de clicar no botão
		login.addActionListener(this);

		//Adicioar todos os elementos no painel
		painel.add(rotulo1);
		painel.add(id);
		painel.add(rotulo3);
		painel.add(especie);
		painel.add(especie);
		painel.add(rotulo2);
		painel.add(rotulo4);
		painel.add(nome);
		painel.add(rotulo5);
		painel.add(peso);
		painel.add(raca);
		painel.add(rotulo6);
		painel.add(nascimento);
		painel.add(rotulo7);
		painel.add(dono);
		painel.add(rotulo8);
		painel.add(telefone);
		painel.add(login);
		painel.add(rotulo1);
	}

	public static void main(String[] args) {
		PetForm tela = new PetForm();
		tela.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}