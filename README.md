# Sistema de Gerenciamento de Relatórios
#### Status do projeto: em andamento.
Essa aplicação utiliza dos conceitos do paradigma de Orientação a Objetos e da matriz de interações CRUD (Create, Read, Update e Delete) em um relatório de acompanhamento simples.

### Objetivos
* Permitir aos usuários criar, visualizar, atualizar e excluir relatórios de forma intuitiva e eficaz.
* Utilizar banco de dados relacional para armazenar os dados dos relatórios, garantindo a consistência e a confiabilidade das informações.
* Implementar uma camada de segurança sólida para proteger as rotas do sistema, garantindo que apenas usuários autorizados tenham acesso às funcionalidades apropriadas.
* Oferecer uma experiência de usuário dinâmica e com uma interface gráfica agradável.

### Requisitos Funcionais
* <strong>RF1:</strong> O sistema deve permitir que os usuários cadastrarem novos relatórios inserindo dados como título, descrição, data de cadastro e data de atualização.
* <strong>RF2:</strong> Os usuários com permissões adequadas devem ser capazes de atualizar informações em relatórios existentes.
* <strong>RF3:</strong> O sistema deve permitir que os usuários sejam capazes de pesquisar um relatório com base nos critérios de autor ou título.
* <strong>RF4:</strong> O sistema deve oferecer a funcionalidade de exclusão de relatórios, permitindo que os usuários autorizados removam relatórios que não sejam mais necessários.  

### Tecnologias 
* <strong>Back-end: </strong>Java 17, Spring Boot 3.2.0, H2 Database
* <strong>Front-end: </strong>Typescript, Vue.js 3, Vuetify 3

### Diagramas UML (feito com a ferramenta PlantUML)

![image](https://github.com/luisagoncalves/sistema-relatorio/assets/72532673/bf48d633-71ac-48d3-9b06-df1d12d3d93a)
![image](https://github.com/luisagoncalves/sistema-relatorio/assets/72532673/2567620a-345a-44c4-9a0e-068b5339c997)
![image](https://github.com/luisagoncalves/sistema-relatorio/assets/72532673/9b6142bf-21a2-4b30-b2bf-944366f98a60)

