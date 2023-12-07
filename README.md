# GereAulas: aplicativo de gerenciamento de aulas de reforço
Um aplicativo capaz de organizar, gerenciar e facilitar o dia a dia de professores de aulas particulares.

## Índice

1. [Visão Geral](#visão-geral)
2. [Como Usar](#como-usar)
   - [Pré-requisitos](#pré-requisitos)
   - [Instalação](#instalação)
3. [Contribuição](#contribuição)
4. [Contato](#contato)

## Visão Geral

Um aplicativo capaz de organizar, gerenciar e facilitar o dia a dia de professores de aulas particulares, também beneficiando alunos e seus responsáveis ao centralizar num único lugar as informações sobre as aulas.
Para a disciplina de Desenvolvimento Web II, a proposta é de criação de uma Rest API, que está disponível em ```https://api-gereaulas.onrender.com```

### Pré-requisitos

Este projeto usa [PostgreSQL](https://www.postgresql.org/), então se você quiser executar localmente vai precisar ter instalado ou, sugiro, usar Docker.   
JDK 17 instalado: Certifique-se de ter o Java Development Kit (JDK) 17 instalado em seu sistema.   
Maven instalado: Certifique-se de ter o Maven instalado em seu sistema.   

### Instalação
#### Clonar ou Baixar o Projeto:

Clone o projeto do repositório ou faça o download do código-fonte em um arquivo zip.
Navegar até o Diretório do Projeto:

Abra um terminal ou prompt de comando e navegue até o diretório onde o projeto foi clonado ou descompactado.

#### Compilar o Projeto:

Execute o seguinte comando para compilar o projeto:
```mvn clean install```

#### Executar o Projeto:

Após a conclusão da compilação, execute o aplicativo Spring Boot com o seguinte comando:
```mvn spring-boot:run```

#### Acesso à API:

Acesse a API no navegador ou em uma ferramenta de teste de API. Por padrão, a aplicação estará disponível em http://localhost:8081

#### Observações:
Certifique-se de que as dependências do banco de dados PostgreSQL estejam configuradas corretamente no arquivo application.properties ou application.yml do seu projeto.

## Contribuição

[![Rita de Cássia Lino Lopes](https://avatars.githubusercontent.com/u/41452534?v=4)](https://github.com/ritallopes)

## Contato

[![LinkedIn: Rita Lopes](https://media.licdn.com/dms/image/D4D03AQFLOH64ibOQJQ/profile-displayphoto-shrink_400_400/0/1689729681995?e=1707350400&v=beta&t=-CGUcTjxRWUgfEj5xXDqK5BC9wweRLXDd_OKaL6UnQI)](https://www.linkedin.com/in/ritallopes/)
