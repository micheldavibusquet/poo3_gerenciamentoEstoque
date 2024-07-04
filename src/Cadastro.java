import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cadastro extends JFrame {
	
	private JPanel panel;
	private JTextField textFieldCodigo;
	private JTextField textFieldNome;
	private JTextField textFieldQuantidade;
	
	public Cadastro() {
		setTitle("Cadastro de Produto");
		setLayout(new FlowLayout());
		
		this.panel = new JPanel();
		this.panel.setLayout(new FlowLayout());
		this.panel.setPreferredSize(new Dimension(500, 500));
		add(panel);
		
		criarTextFieldCodigo("Código do Produto");
		criarTextFieldNome("Nome do Produto");
		criarTextFieldQuantidade("Quantidade");
		
		criarBotao("Salvar", new ButtonSalvarArquivoTextoHandler());
		criarBotao("Voltar", new ButtonVoltarHandler());
		
		setSize(new Dimension(500, 500));
		setPreferredSize(new Dimension(500, 500));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void criarLabel(String texto) {
		JLabel label = new JLabel(texto);
		label.setPreferredSize(new Dimension(400, 40));
		this.panel.add(label);
	}
	
	private void criarTextFieldCodigo(String texto) {
		criarLabel(texto);
		this.textFieldCodigo = new JTextField();
		this.textFieldCodigo.setPreferredSize(new Dimension(400, 40));
		this.panel.add(this.textFieldCodigo);
	}
	
	private void criarTextFieldNome(String texto) {
		criarLabel(texto);
		this.textFieldNome = new JTextField();
		this.textFieldNome.setPreferredSize(new Dimension(400, 40));
		this.panel.add(this.textFieldNome);
	}
	
	private void criarTextFieldQuantidade(String texto) {
		criarLabel(texto);
		this.textFieldQuantidade = new JTextField();
		this.textFieldQuantidade.setPreferredSize(new Dimension(400, 40));
		this.panel.add(this.textFieldQuantidade);
	}
	
	private Produto criarProduto() {
		Produto produto = new Produto();
		produto.setCodigo(Integer.parseInt(this.textFieldCodigo.getText()));
		produto.setNome(this.textFieldNome.getText());
		produto.setQuantidade(Integer.parseInt(this.textFieldQuantidade.getText()));
		return produto;
	}
	
	private void criarBotao(String label, ActionListener handler ) {
		JButton button = new JButton(label);
		button.addActionListener(handler);
		button.setPreferredSize(new Dimension(100, 40));
		this.panel.add(button);
	}
	
	private class ButtonSalvarArquivoTextoHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Produto produto = criarProduto();
			ArquivoUtils.salvarTxt(produto);
			JOptionPane.showMessageDialog(null, "produto salvo em arquivo TXT!");
		}
		
	}
	
	private class ButtonVoltarHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
		
	}
	

}
