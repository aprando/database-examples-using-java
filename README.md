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
