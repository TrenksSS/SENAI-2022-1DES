package viewers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import controllers.OrcamentoProcess;
import models.Orcamento;

public class OrcamentoForm extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel id, data, equip, fornecedor, produto;
	private JTextField tfid, tfFornecedor , tfProduto, tfValor;
	private DefaultTableModel tableModel;
	private JButton create, read, update, delete;
	private JTable table;
	private JScrollPane rolagem;
	
	private String imgIco = "";
	private int autoId = OrcamentoProcess.orcamento.get(OrcamentoProcess.orcamento.size() - 1).getId() + 1;
	private DecimalFormat df = new DecimalFormat("#.00");
	private final Locale BRASIL = new Locale("pt", "BR");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	

	OrcamentoForm(){
		setTitle("Regitro de Orçamento");
		setBounds(100, 100, 610, 390);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		id = new JLabel("ID:");
		id.setBounds(20, 25, 120, 30);
		tfid = new JTextField(String.format("%d", autoId));
		tfid.setEditable(false);
		tfid.setEditable(false);
		tfid.setBounds(40, 25, 40, 30);
		tfid.setBackground(new Color(215, 215, 215));
		
	
		fornecedor = new JLabel("Custo Hora:");
		fornecedor.setBounds(215, 70, 80, 30);
		tfFornecedor = new JTextField();
		tfFornecedor.setBounds(290, 70, 80, 30);
		tfFornecedor.setBackground(new Color(215, 215, 215));
		
		produto = new JLabel("Tempo gasto:");
		produto.setBounds(380, 70, 80, 30);
		tfProduto = new JTextField();
		tfProduto.setBounds(460, 70, 80, 30);
		tfProduto.setBackground(new Color(215, 215, 215));
		
		
		painel.add(id);
		painel.add(tfid);
		painel.add(data);
		painel.add(equip);
		painel.add(fornecedor);
		painel.add(tfFornecedor);
		painel.add(produto);
		painel.add(tfProduto);
		
		table = new JTable();
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Data");
		tableModel.addColumn("Equipamento");
		tableModel.addColumn("Fornecedor");
		tableModel.addColumn("Produto");
		tableModel.addColumn("Total");
		
		if (OrcamentoProcess.orcamento.size() != 1) {
			preencherTabela();
		}
		table = new JTable(tableModel);
		table.setEnabled(false);
		rolagem = new JScrollPane(table);
		rolagem.setBounds(20, 170, 550, 130);
		painel.add(rolagem);

		
		create = new JButton("Cadastrar");
		create.setBounds(60, 120, 110, 30);
		create.setBackground(new Color(189,236,182));
		painel.add(create);

		read = new JButton("Buscar");
		read.setBounds(180, 120, 110, 30);
		painel.add(read);

		update = new JButton("Alterar");
		update.setBounds(300, 120, 110, 30);
		update.setEnabled(false);
		painel.add(update);

		delete = new JButton("Excluir");
		delete.setBounds(420, 120, 110, 30);

		delete.setEnabled(false);
		painel.add(delete);
		
		
		
		create.addActionListener((ActionListener) new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		cadastrar();
        	}
        });
		read.addActionListener((ActionListener) new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		buscar();
        	}
        });
		update.addActionListener((ActionListener) new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		alterar();
        	}
        });
		delete.addActionListener((ActionListener) new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		excluir();
        	}
        });
		
	}
	
	int obterEquipamento(String equipamento) {
		switch (equipamento) {
		case "Paleteiras":
			return 0;
		case "Guindastes":
			return 1;
		case "Comboio":
			return 2;
		case "Monovias":
			return 3;
		case "Esteiras":
			return 4;
		default:
			return -1;
		}
	}
	
	private void cadastrar() {
		if(tfid.getText().length() != 0  &&
				tfFornecedor.getText().length() != 0 && tfProduto.getText().length() != 0) {
			
			df.setCurrency(Currency.getInstance(BRASIL));
			String fornecedor;
			String produto;
			try {
				fornecedor = tfFornecedor.getText().toString();
				produto = tfFornecedor.getText().toString();
			} catch (ParseException e) {
				System.out.println(e);
				fornecedor = 0;
				produto = 0;
			}

		}else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
	}
	


	
	private void buscar() {
		String text = JOptionPane.showInputDialog(this, "Digite o id do item");
		try {
			int id = Integer.parseInt(text);
			
			for (Orcamento m : OrcamentoProcess.orcamento) {
				if (m.getId() == id) {
					int indice = OrcamentoProcess.orcamento.indexOf(m);
			tfid.setText(String.format("%d", OrcamentoProcess.orcamento.get(indice).getId()));
			tfFornecedor.setText((String.format("%.2f" , OrcamentoProcess.orcamento.get(indice).getFornecedor())));
			tfProduto.setText((String.format("%.2f", OrcamentoProcess.orcamento.get(indice).getProduto())));
			create.setEnabled(false);
			update.setEnabled(true);
			delete.setEnabled(true);
			OrcamentoProcess.salvar();
					}
				}
			} catch (Exception e) {
		JOptionPane.showMessageDialog(this, "Id inv�lido!", "Erro", JOptionPane.ERROR_MESSAGE);
	}
	
}
	private void alterar() {
		int id = Integer.parseInt(tfid.getText());
		Orcamento manu = new Orcamento(id);
		int indice = OrcamentoProcess.orcamento.indexOf(manu);
		if (tfid.getText().length() != 0 && tfdata.getText().length() != 0 && 
				tfcustoHora.getText().length() != 0 && tftempoGasto.getText().length() != 0)  {
			Orcamento tempOr = new Orcamento((tfid.getText()),fornecedor.getText), produto.getText(), (Double.parseDouble(tfvalor.getText().replace(",", "."))));
			for (Orcamento m : OrcamentoProcess.orcamento) {
				if (m.getId() == tempManu.getId()) {
					m.setId(tempManu.getId());
					m.setFornecedor(tempManu.getFornecedor());
					m.setProduto(tempManu.getProduto());
					
				}
			}
			df.setCurrency(Currency.getInstance(BRASIL));
			double fornecedor;
			double produto;
			try {
				fornecedor = Double.parseDouble(df.parse(tfFornecedor.getText()).toString());
				produto = Double.parseDouble(df.parse(tfProduto.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				fornecedor = 0;
				produto = 0;
			}
				preencherTabela();
				limparCampos();
				OrcamentoProcess.salvar();
				
				create.setEnabled(true);
				update.setEnabled(false);
				delete.setEnabled(false);
				tfid.setText(String.format("%d", autoId));
				OrcamentoProcess.salvar();
			
		} else {
			JOptionPane.showMessageDialog(this, "Favor Preencher todas as informa��es");
		}
	}
	
	private void limparCampos() {
		tfid.setText(String.format("%d",autoId));
		tfFornecedor.setText(null);
		tfProduto.setText(null);

	}

	private void preencherTabela() {
		int totLinhas = tableModel.getRowCount();
		if (tableModel.getRowCount() > 0) {
			for (int i = 0; i < totLinhas; i++) {
				tableModel.removeRow(0);
			}
		}
		for (Orcamento m : OrcamentoProcess.orcamento) {
			tableModel.addRow(new String[] { String.format("%d", m.getId()), String.format("%.2f", m.getFornecedor()), String.format("%.2f", m.getProduto()), String.valor())});
		}
	}

	
	private void excluir() {
	if (JOptionPane.showConfirmDialog(this, "Tem certeza que deseja EXCLUIR esse Produto?") == 0) {
		Orcamento prodTemp = null;
		for (Orcamento m : OrcamentoProcess.orcamento) {
			if (m.getId() == Integer.parseInt(tfid.getText())) {
				prodTemp = m;
			}
		}

		OrcamentoProcess.orcamento.remove(OrcamentoProcess.orcamento.indexOf(prodTemp));

		preencherTabela();
		limparCampos();
		OrcamentoProcess.salvar();

		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
	}
}
	
	public void actionPerformed(ActionEvent e) {
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
		OrcamentoProcess.abrir();
		OrcamentoForm tela = new OrcamentoForm();
		tela.setVisible(true);
	}
}

	


