package visao;
import javax.swing.JOptionPane;
import entidade.Animal;

public class Mensagem {
		
		String titulo = "Adivinhando o bicho";
		Object[] simNao = {"Sim", "N�o"};
	
	public Mensagem() {
	}
	
	//Manda uma mensagem inicial perguntando se o usu�rio quer jogar ou n�o.
	public int mostraMensagemInicial() {
		String mensagemInicial = "Pense em um animal.";
		Object[] opcaoInicio = {"Vamos l�!", "N�o, quero sair!"};
		int numero = JOptionPane.showOptionDialog(null, mensagemInicial, titulo , JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcaoInicio, opcaoInicio[0]);
		
		return numero;
	}
	
	//Aqui o programa manda uma mensagem perguntando se a caracteristica do animal do usu�rio � a mesma do palpite
	public int pergunta(Animal animal) {
		StringBuilder string = new StringBuilder();
		String qPensou = "O animal que voc� pensou, ";
		string.append(qPensou+animal.getCaract()+"?");
		int resposta = JOptionPane.showOptionDialog(null, string, titulo, JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, simNao, simNao[0]);		
		
		return resposta;
	}
	
	//Aqui o programa manda uma mensagem perguntando o animal que o usu�rio pensou
	public int perguntaAnimal(Animal animal) {
		StringBuilder string = new StringBuilder();
		String qPensou = "O animal que voc� pensou, � ";
		string.append(qPensou+animal.getNome().toString()+" ?");
		int resposta = JOptionPane.showOptionDialog(null, string, titulo, JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, simNao, simNao[0]);		
		
		return resposta;
	}
	
	//Aqui manda uma pergunta sobre o animal que o usu�rio pensou, o nome do animal e depois a caracteristica.
	public String entrada(String mensagem) {
		String entradaDados = JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
		return entradaDados;
	}
	
	//Aqui pergunta ao usuario se deseja jogar novamente.
	public int perguntaNovoJogo(String vencedor) {
		String venci = "Ent�o, "+vencedor+" Quer jogar denovo ?";
		int numero = JOptionPane.showOptionDialog(null, venci, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, simNao, simNao[0]);
		
		return numero;
	}
}