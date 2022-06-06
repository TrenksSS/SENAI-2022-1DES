package viewers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.OrcamentoProcess;
import models.Orcamento;

public class OrcamentoForm extends JFrame implements ActionListener {

	private JPanel painel;
	private JLabel id, fornecedor,produto,preco;
	private JTextField tfId, tfFornecedor, tfProduto,tfPreco;
	private JButton adicionar, alterar, excluir, buscar;
	private JTable tabelaOrcamentos;
	private DefaultTableModel tableModel;
	private JScrollPane scroll;
	
	private final Locale BRASIL = new Locale("pt", "BR");
	private DecimalFormat df = new DecimalFormat("#.00");
	
	OrcamentoForm(){
		setTitle("Orçamento");
		setBounds(650, 200, 595,467);
		painel = new JPanel();
		painel.setBackground(new Color(0, 255, 255));
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		textField();
		buttons();
		tabela();
	}
	
	private void textField(){
		id = new JLabel("Id:");
		id.setBounds(20, 20, 120, 30);
		painel.add(id);
		tfId = new JTextField();
		tfId.setBounds(130, 20, 90, 25);
		painel.add(tfId);
		
		fornecedor = new JLabel("Fornecedor:");
		fornecedor.setBounds(20, 50, 120, 30);
		painel.add(fornecedor);
		tfFornecedor = new JTextField();
		tfFornecedor.setBounds(130, 50, 175, 25);
		painel.add(tfFornecedor);
		
		produto = new JLabel("Produto:");
		produto.setBounds(20, 80, 120, 30);
		painel.add(produto);
		tfProduto = new JTextField();
		tfProduto.setBounds(130, 80, 175, 25);
		painel.add(tfProduto);
		
		preco = new JLabel("Preço:");
		preco.setBounds(20, 110, 120, 30);
		painel.add(preco);
		tfPreco = new JTextField();
		tfPreco.setBounds(130, 110, 175, 25);
		painel.add(tfPreco);
	}
	private void buttons() {
		adicionar = new JButton("Adicionar");
		adicionar.setBounds(360, 20, 170, 30);
		painel.add(adicionar);
		buscar = new JButton("Buscar");
		buscar.setBounds(360, 60, 170, 30);
		buscar.setEnabled(true);
		painel.add(buscar);
		alterar = new JButton("Alterar");
		alterar.setBounds(360, 100, 80, 30);
		alterar.setEnabled(false);
		painel.add(alterar);
		excluir = new JButton("Excluir");
		excluir.setBounds(450, 100, 80, 30);
		excluir.setEnabled(false);
		painel.add(excluir);
		
		
		adicionar.addActionListener(this);
		buscar.addActionListener(this);
		alterar.addActionListener(this);
		excluir.addActionListener(this);
	}
	private void tabela() {
		tabelaOrcamentos = new JTable();
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Fornecedor");
		tableModel.addColumn("Produto");
		tableModel.addColumn("Preco");
		tableModel.addColumn("Melhor preço");
		if(OrcamentoProcess.orcamentos.size() != 0) {
			preencherTabela();
		}
		tabelaOrcamentos = new JTable(tableModel);
		tabelaOrcamentos.setEnabled(false);
		scroll = new JScrollPane(tabelaOrcamentos);
		scroll.setBounds(20, 180, 540, 230);
		scroll.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		painel.add(scroll);
	}
	private void preencherTabela() {
		int totLinhas = tableModel.getRowCount();
		if(tableModel.getRowCount() > 0) {
			for(int i = 0; i < totLinhas; i++) {
				tableModel.removeRow(0);
			}
		}
		for (Orcamento o : OrcamentoProcess.orcamentos) {
			tableModel.addRow(new String[] {o.getId("s"), o.getFornecedor(), o.getProduto(),o.getPreco("s"), o.barato()});
		}
	}
	private void limparCampos() {
		tfId.setText(null);
		tfFornecedor.setText(null);
		tfProduto.setText(null);
		tfPreco.setText(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == adicionar) {
			adicionar();
		}
		if(e.getSource() == buscar) {
			buscar();
		}
		if(e.getSource() == alterar) {
			alterar();
		}
		if(e.getSource() == excluir) {
			excluir();
		}
	}
	
	private void adicionar() {
		if(tfId.getText().length() != 0 && tfFornecedor.getText().length() != 0 && tfProduto.getText().length() != 0  && tfPreco.getText().length() != 0) {
			df.setCurrency(Currency.getInstance(BRASIL));
			double preco = 0;
			boolean barato = true;
			try {
				preco = Double.parseDouble(df.parse(tfPreco.getText()).toString());
			}catch(ParseException e) {
				System.out.println(e);
			}
			for(int i = 0; i < OrcamentoProcess.orcamentos.size(); i++) {
				if(OrcamentoProcess.orcamentos.get(i).getProduto().contains(tfProduto.getText())) {
					if(OrcamentoProcess.orcamentos.get(i).getPreco() > preco) {
						OrcamentoProcess.orcamentos.get(i).setMaisBarato(false);
						barato = true;
					}else {
						barato = false;
					}
				}
				
			}
			OrcamentoProcess.orcamentos.add(new Orcamento(Integer.parseInt(tfId.getText()), tfFornecedor.getText(), tfProduto.getText(), preco, barato));
			
			preencherTabela();
			limparCampos();
			OrcamentoProcess.salvar();
		}
	}
	
	private void excluir() {
		
	}

	private void alterar() {
		
	}

	private void buscar() {
		
	}

	

	public static void main(String[] args) {
		OrcamentoProcess.abrir();
		new OrcamentoForm().setVisible(true);
	}
	
}
