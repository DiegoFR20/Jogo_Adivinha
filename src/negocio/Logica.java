package negocio;
import java.util.List;
import dao.DaoImplem;
import entidade.Animal;
import visao.Mensagem;

public class Logica {
	DaoImplem dao = new DaoImplem();
	List<Animal> listaTemporaria = dao.getAnimais();
	List<Animal> listaPalpites = listaTemporaria;
	//Inicia o jogo
	public void inicia() {
		Mensagem mensagem = new Mensagem();
		listaPalpites = listaTemporaria;
		int resposta;
		int i = 0;
		// Vari�vel que recebe a resposta do usuario sobre querer jogar ou n�o.
		int play = 1;
		// Mostra a mensagem inicial e deposita a resposta do usu�rio na vari�vel
		// 'play'.
		if ((mensagem.mostraMensagemInicial()) == 0) {
			play = 0;
		} else
			// Encerra o programa caso recebe '1' da mensagem, ou seja, o usu�rio disse que
			// n�o quer jogar.
			System.exit(0);
		// Play � a variavel que determina se o usu�rio quis jogar ou n�o, se sim, ele
		// rodar� todos os la�os abaixo at� que esta variavel volte a ser 0, ou seja, o
		// usu�rio n�o queria jogar mais.
		while (play == 0) {
			// O programa ir� executar enquanto tiver animais dentro do Array.
			for (i = 0; i < dao.getAnimais().size(); i++) {
				String animalErrado = listaPalpites.get(i).getNome().toString();
				// listaSim recebe getAnimais() temporariamente e servir� como lista secund�ria
				// para uma partida.
				// Aqui o programa pergunta sobre a caracteristica do animal no indice atual.
				// 'i' � o indice.
				// Se o usu�rio responder "Sim", ele avan�a para a pr�xima pergunta.
				if ((resposta = mensagem.pergunta(listaPalpites.get(i))) == 0) {
					// Se o usu�rio responder "Sim", o computador venceu.
					if ((resposta = mensagem.perguntaAnimal(listaPalpites.get(i))) == 0) {
						if ((resposta = mensagem.perguntaNovoJogo("eu venci")) == 0) {
							inicia();
						} else
							// Encerra o programa se o usu�rio clicar em "N�o".
							System.exit(0);
					} else {
						animalErrado = listaPalpites.get(i).getNome().toString();
						String animalCerto;
						String caractCerta;
						// 'animalCerto' recebe o nome do animal que o usu�rio pensou, ao ser perguntado
						// em 'entrada'.
						if ((animalCerto = mensagem.entrada("Ent�o, qual animal que voc� pensou?")) != null) {
							String caractTexto = "O que um " + animalCerto + " tem ou faz que " + animalErrado
									+ " n�o?";
							// 'caractCerta' recebe a caracteristica do animal que o usu�rio pensou, ao ser
							// perguntado em 'entrada'.
							if ((caractCerta = mensagem.entrada(caractTexto)) != null) {
								// Cria um inst�ncia do objeto 'Animal' para ser adicionada na ArrayList de
								// animais.
								Animal animal = new Animal(caractCerta, animalCerto);
								// Adiciona na ArrayList.
								dao.salvar(animal);
								// Pergunta se o usu�rio deseja jogar novamente.
								if ((resposta = mensagem.perguntaNovoJogo("voc� venceu!")) == 0) {
									//Reinicia o jogo.
									inicia();
								} else
									System.exit(0);
							}
						}
					}
				}
				//Remove o item da lista de palpites.
				listaPalpites.remove(i);
				if (listaPalpites.isEmpty()) {
					String animalCerto;
					String caractCerta;
					if ((animalCerto = mensagem.entrada("Ent�o, qual animal que voc� pensou?")) != null) {
						String caractTexto = "O que um " + animalCerto + " tem ou faz que um " + animalErrado + " n�o?";
						// 'caractCerta' recebe a caracteristica do animal que o usu�rio pensou, ao ser
						// perguntado em 'entrada'.
						if ((caractCerta = mensagem.entrada(caractTexto)) != null) {
							// Cria um inst�ncia do objeto 'Animal' para ser adicionada na ArrayList de
							// animais.
							Animal animal = new Animal(caractCerta, animalCerto);
							// Salva na ArrayList.
							dao.salvar(animal);
							// Pergunta se o usu�rio deseja jogar novamente.
							if ((resposta = mensagem.perguntaNovoJogo("voc� venceu!")) == 0) {
								//Reinicia o jogo.
								inicia();
							} else
								System.exit(0);
						}
					}
				}
			}
		}
	}
}