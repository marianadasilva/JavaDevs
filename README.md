# BROADCASTER SYSTEM

Olá! É com muito prazer que apresentamos à vocês o sistema que desenvolvemos em grupo. 
O sistema foi desenvolvido na linguagem **Java** utilizando **Spring** para produzir a REST api de gerenciamento de habilidades e salários de uma emissora de TV, ou seja, de seu corpo artístico.
Os responsáveis pelo o desenvolvimento são: Carlos Mendonça, Jefferson Santos, Leonardo Rodrigues e Mariana da Silva.

<p align="center"> <img src="Insomnia.PNG" /> </p>

# Configuração de ambiente
**É necessário ter instalado na máquina a versão 11 do Java.**

- Para sistema operacional Windows:
>[Link para download](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

- Para sistema operacional Mac OS:
>[Link para download](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

- Para sistema operacional Linux:
>[Link para download](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

Baixe esse repositório para sua área de trabalho ou o local que preferir.

Para visualizar melhor o código desenvolvido, instale uma IDE de sua preferência mas, sugerimos o **Intellij da JetBrains**, utilizamos no desenvolvimento do projeto.

Para sistema operacional Windows:
>[Link para download](https://www.jetbrains.com/idea/download/#section=windows)

Para sistema operacional Mac OS:
>[Link para download](https://www.jetbrains.com/idea/download/#section=mac)

Para sistema operacional Linux:
>[Link para download](https://www.jetbrains.com/idea/download/#section=linux)

Após concluir a instalação, abra o projeto na IDE e aguarde o download das dependências do projeto.

# Executando a aplicação
Para executar a aplicação, clique com o botão direito sobre o arquivo: **JavaDevsApplication** que encontra-se na pasta **com.javadevs.JavaDevs** e pressione **Run**.

# Testando os serviços disponíveis
Para testar os serviços disponíveis, disponibilizei uma Collection do Insonmia para facilitar.

>[Link para download](https://insomnia.rest/download/#windows)

Feito a instalação, importe URL da collection: **Insomnia_2020-11-07.json**.

Tutorial para importação da colletcion no Insomnia:
> **Abrir Insomnia > Pressionar Application > Preferences > Data > Escolher opção From File > Importar o arquivo **Insomnia_2020-11-07.json** que encontra-se na raiz do projeto.**

# Descrição das Rotas


**Logout**

> (POST) Logout  - Realiza o logout da API.

**Login**

> (POST) Login -  Contém 2 atributos (email e password), para realizar a inserção dos dados do User.

**Appointment**

> (POST) Create Appointment - Realiza inserção de valores no atributos actor_id e date.

> (GET) List Appointment -  Realiza a consulta dos dados em lista dos Appointment.

> (DEL) Delete Appointment - Realiza a exclusão dos dados do usuário de acordo com o Id informado.

> (PUT) Update Appointment - Atualiza os atributos status e date do Appointment.

**Admin**

> (GET) Admin Search - Realiza busca de dados para o Admin.
> (GET) Admin List - Realiza a busca de acordo com requisitos informados.

**Session**

> (POST) Admin/ Signup - Realiza o login para o Admin.

> (POST) Actor / Signup - Realiza o login para o Actor.

**Actor**


> (GET) Find by Id Actor - Retorna o ator passado o id como parâmetro.

> (GET) List Actor - Realiza a consulta de todos os atores cadastrados.

> (GET)  Appointments Actor - Realiza a consulta por Id de ator.

> (DEL) Delete Actor  - Realiza a exclusão dos dados do Ator.

> (GET) List All Actor - Realiza a consulta de todos os atores cadastrados.

> (PUT) Update Actor - Atualiza os atributos gender, genre e amount do ator.



Agora sinta-se à vontade para testar a aplicação, todos os endpoints disponíveis só funcionarão com a aplicação rodando, lembre-se disso.

# Outros
A fim de documentar as tarefas produzidas, criamos um board no **Notion** para definirmos o que fariamos.

>[Board público no Notion](https://www.notion.so/42b50322445b4899a662cba42d24e04b?v=688a6d6949e14b66917e923dcc08dbce)

Estamos  à disposição para maiores esclarecimentos.

[![Linkedin Badge](https://img.shields.io/badge/-Carlos-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/carlos-vieira-7b8830197/)](https://www.linkedin.com/in/carlos-vieira-7b8830197/)
[![Gmail Badge](https://img.shields.io/badge/-carlos.m.vieira@accenture.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:carlos.m.vieira@accenture.com)](mailto:carlos.m.vieira@accenture.com)

[![Linkedin Badge](https://img.shields.io/badge/-Jefferson-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/jefferson-yuiti-dos-santos/)](https://www.linkedin.com/in/jefferson-yuiti-dos-santos/)
[![Gmail Badge](https://img.shields.io/badge/-yuiti.santos@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:yuiti.santos@gmail.com)](mailto:yuiti.santos@gmail.com)


[![Linkedin Badge](https://img.shields.io/badge/-Leonardo-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/devleonardorodrigues/)](https://www.linkedin.com/in/devleonardorodrigues/) 
[![Hotmail Badge](https://img.shields.io/badge/-leonardo.rodrigues1994@hotmail.com-blue?style=flat-square&logo=Email&logoColor=white&link=mailto:leonardo.rodrigues1994@hotmail.com/)](mailto:leonardo.rodrigues1994@hotmail.com) 

[![Linkedin Badge](https://img.shields.io/badge/-Mariana-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/mariana-da-silva-61a1a21b3/)](https://www.linkedin.com/in/mariana-da-silva-61a1a21b3/)
[![Gmail Badge](https://img.shields.io/badge/-contactmarianadasilva@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:contactmarianadasilva@gmail.com)](mailto:contactmarianadasilva@gmail.com)
