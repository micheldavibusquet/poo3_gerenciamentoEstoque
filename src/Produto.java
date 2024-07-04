import java.io.Serializable;

import javax.swing.JOptionPane;

public class Produto implements Serializable {
	
	private int codigo;
	private String nome;
	private int quantidade;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return this.codigo + " - " + this.nome + " - " + this.quantidade;
	}
	

}
