package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controle.Processa;

public class Tela extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	// Atributos da tela
	private JPanel painel;
	private JLabel rotulo1, rotulo2;
	private JTextField email, senha;
	private JButton login;

	Tela() {
		// Propriedades Básicas
		setTitle("Tela de Login");
		setBounds(600, 300, 360, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel = new JPanel(); //Painel de elementos
		setContentPane(painel); //Configua o painel
		setLayout(null);

		// Conteúdos da tela
		rotulo1 = new JLabel("Clique no botão para calcular a média!");
		rotulo1.setBounds(65, 20, 250, 20);
		login = new JButton("Calcular");
		login.setBounds(75, 100, 200, 30);
		
		//Habilitando o evento de clicar no botão
		login.addActionListener(this);

		//Adicioar todos os elementos no painel
		painel.add(rotulo1);
		painel.add(login);
	}
	public static void main(String[] args) {
		Processa.carregar();
		Tela tela = new Tela();
		tela.setVisible(true);
	}
}