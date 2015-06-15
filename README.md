# Exemplos de acesso a banco de dados MySQL utilizando a linguagem JAVA

## Pré-requisitos dos exemplos
* Baixar e instalar JAVA (mínimo 1.5):
  * http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk7-downloads-1880260.html

* Baixar e instalar/descompactar ECLIPSE (for JAVA EE Developers):
  * http://www.eclipse.org/downloads/

* Baixar e instalar/descompactar TOMCAT 7:
  * http://tomcat.apache.org/download-70.cgi

•	Baixar e instalar MYSQL:
  * http://dev.mysql.com/downloads/mysql/
  * http://dev.mysql.com/downloads/windows/

## Resumo rápido
* **Exemplo 1** - Linguagem Java sem frameworks, com uma cadamda DAO realizando o acesso ao banco utilizando espeficificação JDBC. Programa simples com uma classe de ativação main para chamada ao DAO.
* **Exemplo 2** - Sistema Web MVC Java utilizando framework Spring, com uma camada DAO realizando o acesso ao banco utilizando espeficificação JDBC. 
* **Exemplo 3** -  Sistema Web MVC Java utilizando framework Spring, com uma camada DAO utilizando o framework JPA + Hibernate.

## Conceitos básicos
* **Design Patterns**: é uma solução geral reutilizável para um problema que ocorre com frequência dentro de um determinado contexto.
* **Frameworks:** é uma implementação utilizada para resolver um problema comum podendo ser reutilizada em diferentes projetos.
* **DAO:** Data Access Object é um padrão para persistência de dados que permite separar regras de negócio das regras de acesso a banco de dados.
* **MVC:** Model-view-controller é um padrão de arquitetura de software que separa as camadas de apresentação e negócio por um controlador com o intuito de separar responsabilidades e tornar o código coeso e reutilizável.
* **Pool de conexões:** é uma coleção com várias conexões com o banco de dados.
* **Servidor de aplicação:** é um servidor que disponibiliza um ambiente para a instalação e execução de aplicações

## Como importar os exemplos no Eclipse
1. Descompactar exemplos em um diretório físico (que será utilizado como WORKSPACE)
2. Abrir o eclipse e escolher a pasta que os projetos foram descompactados.
![1](https://cloud.githubusercontent.com/assets/66175/8153474/ca1dabe6-1304-11e5-97e7-a008034f133a.png)

3. Importar os projetos exemplo
  * Clique no menu superior: File -> Import... ![3a](https://cloud.githubusercontent.com/assets/66175/8153472/ca1c15d8-1304-11e5-9245-f760d1144aa1.png)
  * Selecione a opção: Maven -> Existing Maven Projects ![3b](https://cloud.githubusercontent.com/assets/66175/8153470/ca1ba1ac-1304-11e5-9f2e-41c44de6b4d4.png)
  * Selecione a pasta que os projetos foram descompactados ![3x](https://cloud.githubusercontent.com/assets/66175/8153475/ca1fd83a-1304-11e5-8b7b-1e98d9d2a597.png)
  * Next – next – finish...
4. Configurando o Tomcat dentro do eclipse.
  * Adicione o jar mysql-connector-java-5.1.31-bin.jar na pasta <seuDiretorioDeInstalacaoTomcat>/lib
  * Selecione a opção no menu superior: Window -> Show View -> Servers ![4b](https://cloud.githubusercontent.com/assets/66175/8153471/ca1c1114-1304-11e5-8fe7-b59dfa830f49.png)
  * Selecione a opção: create new server... ![4c](https://cloud.githubusercontent.com/assets/66175/8153477/d05a915e-1304-11e5-8580-d41a765b007b.png)
  * Selecione a opção: Apache -> Tomcat 7 ![4d](https://cloud.githubusercontent.com/assets/66175/8153478/d075eb98-1304-11e5-9862-fc5e1a594f4a.png)
  * Adicione o seu servidor no server runtime, informando o diretório raiz da instalação do Tomcat. ![4e](https://cloud.githubusercontent.com/assets/66175/8153480/d08991e8-1304-11e5-9a5c-c3add8fa7813.png)
  * Clique em next.
  * Selecione as aplicações exemplo-2 e exemplo-3. ![4g](https://cloud.githubusercontent.com/assets/66175/8153482/d08b37b4-1304-11e5-9b43-665feac0c174.png)
  * Clique em Finish
5. Inicializando o Tomcat.
  * Botão direito em cima do servidor criado, opção “Start” ou “Debug”. ![5a](https://cloud.githubusercontent.com/assets/66175/8153479/d08983c4-1304-11e5-9653-64e4426f58cd.png)
6. Configurando o pool de conexões no tomcat.
  * Clique duas vezes no servidor Tomcat da aba Servers. ![6a](https://cloud.githubusercontent.com/assets/66175/8153481/d089cf1e-1304-11e5-9713-c4c7b841c3e7.png)
  * Selecione a opção “Use Tomcat Installation” dentro da aba “Service Location”.
  * Altere o Deploy path para o endereço <seuDiretorioDeInstalacaoTomcat>/webapps
  * Abrir o arquivo <seuDiretorioDeInstalacaoTomcat>/conf/context.xml
  * Adicionar configuração do pool de conexões abaixo.
```
<Resource auth="Container" 
 driverClassName="com.mysql.jdbc.Driver" 
 maxActive="20" 
 maxIdle="10" 
 maxWait="5000" 
 name="jdbc/example" 
 password="root" 
 type="javax.sql.DataSource" 
 url="jdbc:mysql://192.168.33.10:3306/example_schema" 
 username="root"/>
```
