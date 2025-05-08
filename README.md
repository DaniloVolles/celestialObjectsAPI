# Celestial Objects API

## Sobre essa API // About this API
A ideia aqui foi desenvolver uma API que implementasse minimamente um sistema
desenvolvido com protocolo SOAP. Embora seja um protocolo já antigo e tenha
sido substituido, na prática, em muitos contextos, pelo REST, ainda tem sua 
relevância sobretudo em aplicações legadas.
Além disso, a ideia é construir também uma api REST de professores que consuma
da api de objetos celestiais.

#### English
###### The idea of this application was to develop an API that implements, at a basic level, a SOAP protocol system build. Although it is an older protocol and has been replaced in many contexts by REST, it is still relevant, specially in legacy applications. Additionally, the main goal is to build another application (a REST API) that consumes this Celestial Objects API.  

### Pontos de melhoria
Como o objetivo foi estudar de forma simples o protocolo SOAP, não houve um
debruçamento profundo na modelagem do negócio, no tratamento de erros, nem na
adequação da api para um estilo de programação mais voltado para boas práticas
no protocolo SOAP. Se você quiser pegar esse sistema e evoluí-lo, recomendo
começar por esses pontos (não necessariamente nessa ordem)
1. Tratamento de erros e exceções mais robusto
2. Melhorar a exposição das respostas via DTO para uma melhor segurança e legibilidade
3. Divisão do arquivo /schemas/celestialObjects.xsd em mais arquivos para melhor organização
4. Separação da lógica de transformação dos objetos que está no endpoint e destiná-lo à service
###### Areas for improvement
###### Since the objective was to study the SOAP protocol in a simple way, there wasn't a deep focus on business modeling, error handling, or implementing the best practices for SOAP-style APIs. If you wish to take this system and evolve it further, I recommend starting with the following areas (not necessarily in this order):
###### 1. More robust error and exception handling
###### 2. Improve response exposure via DTOs for better security and readability
###### 3. Split the /schemas/celestialObjects.xsd file into multiple files for better organization
###### 4. Move the object transformation logic out of the endpoint and into the service layer

### Sobre o modelo
Eu sempre fui apaixonado pelo espaço. E pode até parecer bobo colocar isso aqui, 
mas foi bem divertido sair da minha zona de conforto nos estudos para desenvolver
uma aplicação com esse tema.
Abaixo eu mostro um diagrama de entidade relacionamento das entidades dessa aplicação!
###### I’ve always been passionate about space. And while it might seem silly to include this here, it was genuinely fun to step out of my comfort zone while studying and develop an application with this theme. Below, I show an entity-relationship diagram of the entities in this application!

### Para rodar || How to run it
> Eu rodei e codifiquei essa aplicação 100% em uma distribuição Linux, mas acredito que tudo aqui funcionará da mesma forma no Windows e MacOS

> I developed and tested this application entirely on a Linux distribution, but I believe everything should work the same on Windows and macOS.

1. Certifique-se de cumprir os requisitos abaixo:
- Possuir o Java 21 instalado e com as variáveis de ambiente configuradas corretamente
- Possuir o maven instalado (eu utilizei a versão 3.6.3)
- Possuir o Git (para clonar o repositório) e uma IDE de sua preferência para abrir o programa
- Possuir um banco de dados MongoDB instalado no PC

###### 1. Make sure you meet the following requirements:
###### - Java 21 installed and environment variables properly configured
###### - Maven installed (I used version 3.6.3)
###### - Git (to clone the repository) and an IDE of your choice to open the project
###### - A MongoDB database installed on your machine

2. Clonar o repositório
###### 2. Clone the repository
```bash
$ git clone https://github.com/DaniloVolles/celestialObjectsAPI.git
```
3. Abri-lo na IDE de sua preferência (eu geralmente utilizo o IntelliJ)
###### 3. Open it in your preferred IDE (I usually use IntelliJ)

4. Compile o projeto para verificar a sua integridade
- Esse passo é opcional, mas caso você não o realize não se assuste com os erros, tem diversas classes que são geradas automagicamente a partir do arquivo xsd
###### 4. Compile the project to verify its integrity
###### - This step is optional, but if you skip it, don’t be alarmed by the errors! Several classes are magically auto-generated from the XSD file
```bash
$ mvn clean compile
```
5. Execute o projeto
###### Run the project:
```bash
$ mvn spring-boot:run
```

### Para testar
Basta importar a collection do postman que está em resources que
você conseguirá executar muito bem as requests

###### To test
###### Just import the Postman collection located in the ««resources»» folder, and you’ll be able to execute the requests smoothly.