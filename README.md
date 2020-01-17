# TwitterWatcher 
Visualizar a aplicação: [App-deployed](https://vast-sierra-24291.herokuapp.com/HashtagController?operacao=lis)

O TwitterWatcher é um aplicativo web que busca Tweets com base em Hashtags préviamente cadastradas. 

O app é composto pelas seguintes funções:
 - Cadastro de Hashtags 
 - Cadastro de Configurações de Busca
 - Consulta de Tweets
 - Buscador automático agendável de Tweets 

### Tecnologias utilizada e requisitos
**IDE**:
 - Eclipse Java EE IDE for Web Developers. Version: Kepler Service Release 2
 - Java version: 1.8.0_231
 - Maven: apache-maven-3.6.3

**APIs**: 
 -	Junit  4.11
 -	Postgresql 9.4.1212
 -	Javax.servlet-api 3.0.1
 -	Twitter4j-core 4.0.7
 
**Banco de dados**: 
 - 	PostgreSQL 9.4

# Funcionalidade do sistema 

## Hashtags

A aba Hashtag exibirá uma lista de Hashtags já cadastradas. À direita de cada hashtag encontram-se links para excluir e alterar a hashtag bem como um link que levará à uma lista de Tweets filtrados por Hashtag. 
No rodapé da lista encontra-se um botão para inclusão de nova Hashtag. 

### Incluindo uma nova Hashtag:

Ao acionar o botão *Novo*, será exibida a tela de inclusão de Hashtag com caixas de texto para os seguintes campos: 

| Campo | Descrição |
| ------ | ------ |
| ID | Identificador unico. Não deve ser preenchido, deve permanecer em 0 (zero). O gerenciador de banco de dados irá incrementar o valor da variável automaticamente. |
| HASHTAG | Incluir Hashtag. |
| STATUS | Apenas valores *True* e *False*. Este campo permite desativar a Hashtag sem que ela precise ser apagada do banco de dados. Uma Hashtag marcada com "false" será ignorada pelo motor de busca. |

### Cadastro de Configurações de Busca:

A aba Configuração exibirá as Configurações de Busca (atualmente o sistema permite apenas uma configuração global). À direita da configuração encontram-se links para excluir e alterar a configuração.  

#### Descrição dos campos: 
| Campo | Descrição |
| ------ | ------ |
| ID | Identificador único. |
| Frequência | Intervalo de tempo dado em minutos, usado pelo motor de busca para agendar as buscas automáticas. |
| ConsumerKey | Chave do usuário da aplicação registrada no twitter developer. |
| ConsumerSecret | Código de segurança do usuário da aplicação registrada no twitter developer. |
| AccessToken | Token de acesso da aplicação registrada no Twitter developer. |
| AccessTokenSecret | Código de segurança do token de acesso da aplicação registrada no Twitter developer. |
| Count | Quantidade de resultados a serem retornados na busca (máximo 100). |
| Language | Idioma dos Tweets buscados ([idiomas diponíveis](https://developer.twitter.com/en/docs/twitter-for-websites/twitter-for-websites-supported-languages/overview)). |
| GeoCodeLatitude | Latitude da localização geográfica à partir da qual se pretende buscar tweets ([obter localização](https://www.google.com/maps/)). |
| GeoCodeLongitude | Longitude da localização geográfica à partir da qual se pretende buscar tweets ([obter localização](https://www.google.com/maps/)). |
| GeoCodeRadius | Raio à partir do ponto geografico da busca. |
| GeoCodeUnit | Unidade de medida do raio da busca (km - Kilometros; mi - Milhas). |
| Since | Data inicial das mensagens  a considerar na busca (AAAA-MM-DD). |
| Until | Data limite das mensagens  a considerar na busca (AAAA-MM-DD). |

A tela de cadastro de configurações de busca conta ainda com botões para interagir com o motor de busca: 

| Campo | Descrição |
| ------ | ------ |
| Start | Inicia o motor de busca. Serão realizadas buscas automáticas para todas as hashtags marcadas com Status *True*, em intervalos de tempo regulares dados pelo campo Frequência. |
| Stop | Parar o motor de busca. |
| Teste | Realiza apenas uma rodada de busca para todas as hashtags (não considera o intervalo de tempo dado por Frequência) |      

### Consulta de Tweets

A aba Tweets exibirá uma lista de todos os Tweets encontrados pelo motor de buscas.  À direita de cada Tweet encontra-se um link para excluir o Tweet. 
No rodapé da lista de Tweets encontra-se um botão exclusão de todos os Tweets. 
É possivel filtrar a lista de Tweets por hashtag a partir da tela de Hashtags (veja descrição do cadastro de Hashtags). 

O sistema conta com uma barra de menu para navegar livremente entre os links citados.

##### Links úteis: 
   [Telas do Sistema](https://github.com/marleiSilveira/TwitterWatcher/blob/master/Telas%20do%20Sistema.pdf).
   [Script DDL](https://github.com/marleiSilveira/TwitterWatcher/blob/master/Twitter-watcher%20Script%20DDL.txt).
   [Script DDL para Testes](https://github.com/marleiSilveira/TwitterWatcher/blob/master/Twitter-watcher%20Script%20DDL%20-%20Inicializando%20o%20DB%20para%20testes%20automatizados.txt).
