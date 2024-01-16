# Sistema de Gerenciamento de Relatórios
#### Status do projeto: em andamento.
Essa aplicação utiliza dos conceitos do paradigma de Orientação a Objetos e da matriz de interações CRUD (Create, Read, Update e Delete) em um relatório de acompanhamento simples.

#### Execução da aplicação
* Clone o repositório para seu ambiente de trabalho.
* <strong>Back-end</strong>
  * Para subir o container da aplicação em segundo plano:
  ```bash
  docker-compose up -d
  ```
  * Para rodar o projeto Spring Boot:
  ```bash
  mvn spring:boot run
  ```
* <strong>Front-end</strong>
  * Para baixar e instalar as dependências do projeto: 
  ```bash
  npm install
  ```
  * Para rodar a aplicação:
  ```bash
  npm run dev.
  ```
### Objetivos do projeto
* Permitir aos usuários criar, visualizar, atualizar e excluir relatórios de forma intuitiva e eficaz.
* Utilizar banco de dados relacional para armazenar os dados dos relatórios, garantindo a consistência e a confiabilidade das informações.
* Implementar uma camada de segurança sólida para proteger as rotas do sistema, garantindo que apenas usuários autorizados tenham acesso às funcionalidades apropriadas.
* Oferecer uma experiência de usuário dinâmica e com uma interface gráfica agradável.

### Requisitos Funcionais
* <strong>RF1:</strong> O sistema deve permitir que os usuários cadastrarem novos relatórios inserindo dados como título, descrição e anexos.
* <strong>RF2:</strong> Os usuários com permissões adequadas devem ser capazes de atualizar informações em relatórios existentes.
* <strong>RF3:</strong> O sistema deve permitir que os usuários sejam capazes de pesquisar um relatório com base nos critérios de autor ou título.
* <strong>RF4:</strong> O sistema deve oferecer a funcionalidade de exclusão de relatórios, permitindo que os usuários autorizados removam relatórios que não sejam mais necessários.  

### Tecnologias e Ferramentas
* <strong>Back-end: </strong>Java 17, Spring Boot , PostgreSQL, Docker
* <strong>Front-end: </strong>Typescript, Vue.js 3, Vuetify
* <strong>Desenvolvimento: </strong>VS Code, DBeaver e Docker Desktop

