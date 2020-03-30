QUAL O PROPOSITO DO JOGO:
Jogo "Adivinhando o Bicho", por Diego Freire
Esse jogo foi feito como um teste técnico para um processo seletivo.

SOBRE O QUE É O JOGO:
O jogo consiste em um Aplicativo tentando adivinhar em qual animal o usuário está pensando.
O jogo vai adicionando em seu banco de animais o animal resposta do usuário, para assim então, na próxima partida, conseguir "palpitar" esse animal.

COMO FUNCIONA O JOGO:
O começo do jogo, o programa pergunta ao usuário se deseja jogar uma partida, irá aparecer uma mensagem com uma pergunta, "Pense em um Animal." e duas alternativas, "Vamos lá!" e "Não, quero sair!".
Caso clique em "Vamos lá!", o programa irá perguntar "O animal que você pensou, é perigoso?", aqui, "é perigoso" seria a primeira caracteristica cadastrada no banco de dados, caso clique em "Não", o usuário é 
perguntado "O animal que você pensou, come banana?", que é a segunda caracteristica cadastrada, caso clique em "Não", o programa perguntará qual animal o usuário pensou, o usuário digitará o nome e será perguntado
sobre uma caracteristica do animal, irá aparecer uma mensagem que o usuário venceu e perguntando se quer jogar denovo, se "Sim", o programa volta a tela inicial, se "Não", o programa se encerra.
Caso o usuário clique em "Sim" sobre a caracteristica que o programa perguntou, irá aparecer uma mensagem perguntando se o animal que o usuário pensou é aquele, se "Sim", o programa vence e a pergunta sobre recomeçar o jogo aparece,
se "Não", o programa pergunta qual animal o usuário estava pensando e depois qual a caracateristica daquele animal.

A LÓGICA DO PROGRAMA:
Em principal, será evocado um método 'inicia()', onde chama um método 'inicia()' em 'Lógica', o método 'inicia()', cria uma lista temporária de palpites, chamada 'listaTemporaria', que recebe uma lista de animais criada de 'DaoImplem'.
Esta 'listaTemporaria' servirá para alimentar uma terceira lista, que se chama 'listaPalpites', esta lista servirá como banco de palpites ainda disponíveis para serem "chutados" pelo programa.
Esta 'listaPalpites' terá um palpite removido desta lista, sempre que um palpite receber uma resposta negativa da mensagem 'pergunta'.
A mensagem pergunta é alimentada com uma caracteristica de um 'animal', o qual é determinado pelo seu índice 'i', o índice 'i' é um contador, ele aumenta para cada loop realizado no primeiro 'for' de 'inicia()'.
O mesmo acontece para a perguntaAnimal, mas esta recebe o nome de um 'animal'.
Todas as respostas positivas de qualquer método de 'mensagem' retornam 0, e as negativas retornam 1, não por serem true ou false, mas por começarem em ordem da esquerda para a direita, sendo assim, a resposta positiva retorna 0, a negativa 
retorna 1 e o "X" para fechar o programa retorna "null".
Caso a resposta para 'perguntaAnimal' seja 1, o programa executa uma parte do código que pergunta a resposta certa ao usuário, pergunta o nome do animal e depois a caracteristica desse animal.
A caracteristica desse animal será comparada com a caracteristica do animal no contador 'i'  anterior, ou seja, se o contador 'i' parou em 2, a caracteristica a ser perguntada aqui será a caracteristica do animal na posição 2 do array, no inicio não
tem 2 no array, logo, o animal a ser perguntado será o 0 ou 1, dependendo da resposta da primeira pergunta, caso seja positiva, será o "tubarão" a ser comparado, caso seja negativa, será o "macaco" a ser comparado, pois "tubarão" foi registrado como
0 no array e "macaco" registrado como 1 no array.
As Strings 'animalCerto' e 'caractCerta' recebem a resposta em String da pergunta 'entrada'.
'dao.salvar' acrescenta o animal correto no Array, ou seja, no banco palavras do programa.
Para cada resposta negativa, o programa remove o palpite de 'listaPalpites', quando esta lista for vazia, ou seja, o método 'listaPalpites.isEmpty()', é verificado, caso positivo, o programa perguntará a resposta certa ao usuário, logo o usuário venceu o jogo.

PROBLEMAS CONHECIDOS:
Há um problema conhecido no prorgama, foram criadas três listas, 'listaPalpites', com os palpites a serem usados no decorrer do programa, 'listaTemporaria' que recebe a lista de animais de 'dao.getAnimais()', e serve para alimentar 'listaPalpites' para cada novo jogo,
'listaTemporaria' recebe uma lista atualizada de 'dao.getAnimais()' e então, envia uma lista atualizada para 'listaPalpites' ao recomeçar o jogo. Porém, há um problema, toda vez em que um animal é removido de 'listaPalpites', também está sendo removido de 'dao.getAnimais().
Logo, lista 'listaPalpites', acaba entrando em um novo jogo apenas com o último animal adicionado
Uma solução está sendo trabalhada.


OBS: Há uma pasta chamada "org" sendo criada no arquivo 'JogoAdivinhaDiegoF.jar', porém, ele é gerado da própria IDE utilizada, não faz parte do projeto.