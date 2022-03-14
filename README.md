# Tarefas
Projeto Java JSF com conexão a PostgreSQL
O projeto foi construído no Netbeans 8.2 utilizando a linguagem Java com Framework JSF 2.2. 
O projeto roda em um servidor local GlassFish 4.1.1. 
Foi realizad a persistência conectando a um banco de dados criado no PostgreSQL 9.5. 
No projeto foi criada uma classe java para cada tabela do banco de dados (classes de entidades), incluindo o relacionamento entre as tabelas.
No projeto foi implementada um classe de conexão ao banco de dados, na qual foram criados todos os métodos que acessam o banco diretamento, atrávez de comandos sql. 
Foram implementados dois Controllers (ManagedBean) um para a página cadastrar tarefa e o outro para a página listagem de tarefas. 
Nos controllers os métodos da classe conexão são chamados e as páginas xhtml se conectam aos seus respectivos controllers. 
Infelizmente, ao rodar o projeto ele apresenta um erro em suas páginas xhtml e não executa corretamente e até o momento não tive tempo para identificar a fonte do erro e corrigi-lo por completo. 
