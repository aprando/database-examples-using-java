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

## Configurar pool de conexões no tomcat
* Adicionar a configuração abaixo no server.xml.
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

## Como importar os exemplos no Eclipse
1. Descompactar exemplos em um diretório físico (que será utilizado como WORKSPACE)
2. Abrir o eclipse e escolher a pasta que os projetos foram descompactados.
3. Importar os projetos exemplo
  * Clique no menu superior: File -> Import...
  * Selecione a opção: Maven -> Existing Maven Projects
  * Selecione a pasta que os projetos foram descompactados
  * Next – next – finish...
4. Configurando o Tomcat dentro do eclipse.
  * Adicione o jar mysql-connector-java-5.1.31-bin.jar na pasta <seuDiretorioDeInstalacaoTomcat>/lib
  * Selecione a opção no menu superior: Window -> Show View -> Servers
  * Selecione a opção: create new server...
  * Selecione a opção: Apache -> Tomcat 7
  * Adicione o seu servidor no server runtime, informando o diretório raiz da instalação do Tomcat.
  * Clique em next.
  * Selecione as aplicações exemplo-2 e exemplo-3.
  * Clique em Finish
5. Inicializando o Tomcat.
  * Botão direito em cima do servidor criado, opção “Start” ou “Debug”.
6. Configurando o pool de conexões no tomcat.
  * Clique duas vezes no servidor Tomcat da aba Servers.
  * Selecione a opção “Use Tomcat Installation” dentro da aba “Service Location”.
  * Altere o Deploy path para o endereço <seuDiretorioDeInstalacaoTomcat>/webapps
  * Abrir o arquivo <seuDiretorioDeInstalacaoTomcat>/conf/context.xml
  * Adicionar configuração do pool de conexões abaixo.
