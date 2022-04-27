# Tarefas
Projeto Java JSF e JSP com conexão a PostgreSQL
O projeto foi construído no Netbeans 8.2 utilizando a linguagem Java com Framework JSF 2.2. 
O projeto roda em um servidor local GlassFish 4.1.1. 
Foi realizad a persistência conectando a um banco de dados criado no PostgreSQL 9.5. 
No projeto foi criada uma classe java para a tabela do banco de dados (classes de entidade).
No projeto foi implementada um classe de conexão ao banco de dados e uma classe TarefaDao na qual foram criados todos os métodos que acessam o banco diretamento, atrávez de comandos SQL. 
Foram implementados dois Controllers (ManagedBean) um para a página pesquisar tarefa (página JSF) e o outro para as páginas  de listagem e cadastro de de tarefas (páginas JSP). 
Nos controllers os métodos da classe conexão são chamados e as páginas xhtml se conectam aos seus respectivos controllers. 


OBS: As classes.java estão divididas em 4 pacotes no projeto (controller, dao, model e util).
