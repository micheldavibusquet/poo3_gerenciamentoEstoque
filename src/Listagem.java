import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Listagem extends JFrame{
	
	private JPanel panel;
	private JList<Produto> listProdutos;
	private JList<Produto> listCriticos;
	private DefaultListModel<Produto> listProdutoModel;
		
	public Listagem() {
		setTitle("Listagem de Produtos");
		setLayout(new FlowLayout());
		
		this.panel = new JPanel();
		this.panel.setLayout(new FlowLayout());
		this.panel.setPreferredSize(new Dimension(500, 500));
		add(this.panel);
		
		criarBotao("Produtos", new ButtonCarregarArquivoTextoHandler());
		criarBotao("Crítico", new ButtonCarregarCriticoHandler());
		criarBotao("Voltar", new ButtonVoltarHandler());
		
		criarList();
		
		setSize(new Dimension(500, 500));
		setPreferredSize(new Dimension(500, 500));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void criarBotao(String label, ActionListener handler ) {
		JButton button = new JButton(label);
		button.addActionListener(handler);
		button.setPreferredSize(new Dimension(100, 40));
		this.panel.add(button);
	}
	
	private void criarList() {
		listProdutoModel = new DefaultListModel<Produto>();
		listProdutos = new JList<Produto>(listProdutoModel);
		listProdutos.setPreferredSize(new Dimension(400, 300));
		JScrollPane scrollPane = new JScrollPane(listProdutos);
		scrollPane.setPreferredSize(new Dimension(400, 300));
		panel.add(scrollPane);
	}
	
	private class ButtonVoltarHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			
		}		
	}
	
	private class ButtonCarregarArquivoTextoHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			listProdutoModel.clear();
			List<Produto> produtos = ArquivoUtils.carregarTxt();
			listProdutoModel.addAll(produtos);
		}
		
	}
	
	private class ButtonCarregarCriticoHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			listProdutoModel.clear();
			List<Produto> produtos = ArquivoUtils.carregarTxt();
			
			listProdutoModel.addAll(produtos);
		}
		
	}
	
}
