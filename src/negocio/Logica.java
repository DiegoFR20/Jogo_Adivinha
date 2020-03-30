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
		// Variável que recebe a resposta do usuario sobre querer jogar ou não.
		int play = 1;
		// Mostra a mensagem inicial e deposita a resposta do usuário na variável
		// 'play'.
		if ((mensagem.mostraMensagemInicial()) == 0) {
			play = 0;
		} else
			// Encerra o programa caso recebe '1' da mensagem, ou seja, o usuário disse que
			// não quer jogar.
			System.exit(0);
		// Play é a variavel que determina se o usuário quis jogar ou não, se sim, ele
		// rodará todos os laços abaixo até que esta variavel volte a ser 0, ou seja, o
		// usuário não queria jogar mais.
		while (play == 0) {
			// O programa irá executar enquanto tiver animais dentro do Array.
			for (i = 0; i < dao.getAnimais().size(); i++) {
				String animalErrado = listaPalpites.get(i).getNome().toString();
				// listaSim recebe getAnimais() temporariamente e servirá como lista secundária
				// para uma partida.
				// Aqui o programa pergunta sobre a caracteristica do animal no indice atual.
				// 'i' é o indice.
				// Se o usuário responder "Sim", ele avança para a próxima pergunta.
				if ((resposta = mensagem.pergunta(listaPalpites.get(i))) == 0) {
					// Se o usuário responder "Sim", o computador venceu.
					if ((resposta = mensagem.perguntaAnimal(listaPalpites.get(i))) == 0) {
						if ((resposta = mensagem.perguntaNovoJogo("eu venci")) == 0) {
							inicia();
						} else
							// Encerra o programa se o usuário clicar em "Não".
							System.exit(0);
					} else {
						animalErrado = listaPalpites.get(i).getNome().toString();
						String animalCerto;
						String caractCerta;
						// 'animalCerto' recebe o nome do animal que o usuário pensou, ao ser perguntado
						// em 'entrada'.
						if ((animalCerto = mensagem.entrada("Então, qual animal que você pensou?")) != null) {
							String caractTexto = "O que um " + animalCerto + " tem ou faz que " + animalErrado
									+ " não?";
							// 'caractCerta' recebe a caracteristica do animal que o usuário pensou, ao ser
							// perguntado em 'entrada'.
							if ((caractCerta = mensagem.entrada(caractTexto)) != null) {
								// Cria um instância do objeto 'Animal' para ser adicionada na ArrayList de
								// animais.
								Animal animal = new Animal(caractCerta, animalCerto);
								// Adiciona na ArrayList.
								dao.salvar(animal);
								// Pergunta se o usuário deseja jogar novamente.
								if ((resposta = mensagem.perguntaNovoJogo("você venceu!")) == 0) {
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
					if ((animalCerto = mensagem.entrada("Então, qual animal que você pensou?")) != null) {
						String caractTexto = "O que um " + animalCerto + " tem ou faz que um " + animalErrado + " não?";
						// 'caractCerta' recebe a caracteristica do animal que o usuário pensou, ao ser
						// perguntado em 'entrada'.
						if ((caractCerta = mensagem.entrada(caractTexto)) != null) {
							// Cria um instância do objeto 'Animal' para ser adicionada na ArrayList de
							// animais.
							Animal animal = new Animal(caractCerta, animalCerto);
							// Salva na ArrayList.
							dao.salvar(animal);
							// Pergunta se o usuário deseja jogar novamente.
							if ((resposta = mensagem.perguntaNovoJogo("você venceu!")) == 0) {
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