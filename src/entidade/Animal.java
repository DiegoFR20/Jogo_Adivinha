package entidade;
import java.io.Serializable;

public class Animal implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nome;
	private String caract;
	
	public Animal() {
		super();
	}
	
	public Animal(String caract, String nome) {
		super();
		this.caract = caract;
		this.nome = nome;
	}
	public Animal(String nome) {
		super();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaract() {
		return caract;
	}
	
	public void setCaract(String caract) {
		this.caract = caract;
	}	
	
	@Override
	public String toString() {
		return "\nNome: "+getNome()+"\nCaracteristica: "+getCaract();
	}
}