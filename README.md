# Sistema de Gerenciamento de Relatórios

Essa aplicação utiliza dos conceitos do paradigma de Orientação a Objetos e das operações de criação, leitura, atualização e deleção em um relatório.

Na camada de apresentação, foi desenvolvido duas telas simples para que o usuário possa interagir de forma intuitiva com o sistema. Já as regras da aplicação, foram modeladas em classes e serviços que utilizam dos métodos HTTP para receber e entregar os dados ao usuário.

## Requisitos Funcionais
* <strong>RF1:</strong> O sistema deve permitir o cadastro, a visualização, a atualização e a exclusão de relatórios.
* <strong>RF2:</strong> O sistema deve permitir a pesquisa de um ou mais relatórios com base no título ou descrição do relatório.
  
## Tecnologias e Ferramentas
* <strong>Back-end: </strong>Java 17, Spring Boot 3, H2 Database, Swagger
* <strong>Front-end: </strong>Typescript, Vue.js 3, Vuetify
* <strong>Desenvolvimento: </strong>IntelliJ IDEA e WebStorm
  
## Execução da aplicação
- Clone o projeto

```bash
  git clone https://github.com/luisagoncalves/sistema-relatorio.git
```

### Back-end

- Entre no diretório do projeto
```bash
  cd sistema-relatorio/backend
```
- Execute a aplicação
```bash
  mvn spring-boot:run
```
- URL para documentação da API no Swagger: http://localhost:8080/

### Front-end

- Entre no diretório do projeto
```bash
  cd sistema-relatorio/frontend
```
- Instale as dependências do projeto: 
  ```bash
  npm install
  ```
- Execute a aplicação
  ```bash
  npm run dev
  ```


