========================================================================
1. ESPECIFICACOES DO AMBIENTE DE DESENVOLVIMENTO (HARDWARE E SOFTWARE)
========================================================================

Hardware utilizado:
- Notebook: LENOVO modelo 80JE
- Memoria RAM: 7,7 GiB (aprox. 8 GB)
- Memoria Swap: 7,6 GiB
- Armazenamento: SSD SATA 256 GB (OSC)

Sistema Operacional e Ferramentas:
- Sistema Operacional: Xubuntu Linux (ambiente XFCE)
- IDE / Editor: Visual Studio Code (com Language Support for Java by Red Hat e Simple REST Client)
- Controle de Versao: Git

Versoes da Stack e Dependencias:
- Java / Runtime: Java 21 (OpenJDK 21.0.13.1 - /usr/lib/jvm/java-21-openjdk-amd64)
- Framework: Spring Boot 4.2.0 (Spring Web, Spring Data JPA)
- Servidor Embutido: Apache Tomcat 11.0.27
- ORM / Persistencia: Hibernate ORM 7.4.15.Final
- Pool de Conexoes: HikariCP
- Banco de Dados: MySQL Server 8.4.13 (instalacao nativa)
- Driver JDBC: MySQL Connector/J
- Gerenciador de Build: Apache Maven (via Maven Wrapper ./mvnw)

========================================================================
2. PRE-REQUISITOS PARA RODAR O PROJETO
========================================================================

Para clonar e executar esta aplicacao em outra maquina, voce precisara de:
1. JDK 21 (Java Development Kit 21) instalado e configurado na variavel de ambiente JAVA_HOME.
2. MySQL Server 8.0 ou superior rodando localmente na porta 3306.
3. Git instalado para clonar o repositorio.
4. (Opcional) VS Code com extensao Java ou cliente HTTP (curl, Postman, Insomnia, Simple REST Client) para testar os endpoints.

========================================================================
3. CONFIGURACAO DO BANCO DE DADOS (MYSQL)
========================================================================

Antes de iniciar a API, acesse o MySQL como administrador e crie o banco e o usuario dedicado (ou ajuste as credenciais conforme o seu ambiente):

CREATE DATABASE IF NOT EXISTS concessionaria_db;
CREATE USER IF NOT EXISTS 'spring_api'@'localhost' IDENTIFIED BY 'ApiConcessionaria2026';
GRANT ALL PRIVILEGES ON concessionaria_db.* TO 'spring_api'@'localhost';
FLUSH PRIVILEGES;
