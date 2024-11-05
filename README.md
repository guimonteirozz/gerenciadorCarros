
# Gerenciador de Carros
O projeto Gerenciador de Carros é uma API RESTful desenvolvida para o gerenciamento de carros e usuários, com foco em funcionalidades de CRUD. Ele foi implementado com Java, utilizando o Spring Boot como framework, e um banco de dados PostgreSQL. O sistema permite o controle de acesso por usuários e administradores, além de recursos como geração de QR Codes, envio de notificações por e-mail, e a criptografia de senhas.


## Stack utilizada

**Front-end:** React

**Back-end:** Java 17, Spring Boot

**Banco de Dados:** PostgreSQL

**Documentação da API:** Swagger


## Funcionalidades

- **CRUD de Carros:** Cadastro, leitura, atualização e exclusão de informações de carros.
- **CRUD de Usuários:** Cadastro, leitura, atualização e exclusão de informações de usuários.
- **Autenticação e Autorização:** Controle de acesso para usuários logados, com restrições de operação para usuários comuns.
- **Notificações por E-mail**: Envio de e-mail de notificação no cadastro de novos usuários.
- **Resumo das Informações de Carros**: Visualização de detalhes resumidos de cada carro, incluindo nome, preço, ano, marca, cidade e placa.
- **Geração de QR Code**: Criação de QR Codes contendo informações detalhadas dos carros, com acesso pelo usuário e administrador.
- **Criptografia de Senhas**: Armazenamento seguro de senhas criptografadas no banco de dados.
- **Relatórios para Administradores**: Permite ao administrador baixar um relatório com 10 informações detalhadas dos carros cadastrados.



## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/guimonteirozz/gerenciadorcarros.git
```

Entre no diretório do projeto

```bash
  cd gerenciadorcarros
```

Execute o projeto

```bash
  ./mvnw spring-boot:run      # Para Linux/macOS
    mvnw.cmd spring-boot:run  # Para Windows
```
> **Aviso:** Se você não possui o Maven instalado localmente, o wrapper do Maven (**mvnw** para Linux/macOS ou **mvnw.cmd** para Windows) está incluído no repositório. Ele baixa todas as dependências especificadas no **pom.xml** automaticamente.

## Aviso Prévio

**Para executar este projeto localmente, é necessário ter o PostgreSQL instalado e configurado.** Se você ainda não possui o PostgreSQL, faça o download e instale-o seguindo as instruções no [site oficial](https://www.postgresql.org/download/).

### Configuração da Conexão com o Banco de Dados

1. Após instalar o PostgreSQL, crie um banco de dados chamado `gerenciadorcarros`.
   
2. No arquivo `src/main/resources/application.properties`, atualize as credenciais para refletirem as configurações locais do PostgreSQL:

```bash 
spring.datasource.url=jdbc:postgresql://localhost:5432/gerenciador_de_carros
spring.datasource.username=user_name # seu usuario ou usuario do banco
spring.datasource.password=senha # senha do banco
```

### Acesse a documentação da API no Swagger:
```bash
http://localhost:8080/swagger-ui.html
```

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.


## Licença

Este projeto está licenciado sob a [MIT License](https://choosealicense.com/licenses/mit/)

