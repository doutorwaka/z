# 💰 Z - Plataforma Social
Este repositório contêm o *backend* e o *frontend* da aplicação construída na [Semana Fullstack Masterclass do Dr. Waka](http://doutorwaka.tech/semana-fullstack-masterclass-2).

Para assistir as vídeo aulas da construção do projeto, basta acessar [aulas](http://doutorwaka.tech/semana-fullstack-masterclass-2).

## Sobre o projeto
O ```Z``` é uma plataforma social baseada do [Twitter](https://twitter.com) que foi construída com o objetivo de ensinar os fundamentos de desenvolvimento *fullstack*. Para tal, o projeto foi dividido em duas partes: o (1) *frontend*, criado utilizando [NextJS](https://nextjs.org/), [TailwindCSS](https://tailwindcss.com/) e [Shadcn-ui](https://ui.shadcn.com/); e o (2) *backend*, criado utilizando [Java](https://www.java.com/pt-BR/), [Spring Framework](https://spring.io/) e [MySQL](https://www.mysql.com/).

As principais funcionalidades da plataforma original foram mantidas e várias outras foram cortadas para mantermos o escopo reduzido do projeto e forcarmos nos principais pontos.

## Arquitetura geral

A arquitetura geral do projeto é como ilustrado na imagem abaixo:

Note que utilizaremos o ```Github``` como servidor de identidade e faremos a autenticação do usuário utilizando [next-auth](https://next-auth.js.org/). O usuário será efetivamente criado em nosso *backend* caso seja seu primeir acesso a plataforma.

## Domínio do problema

O domínio do problema segue o esquema da imagem abaixo:

Uma vez que estamos tratando de uma plataforma social que é um clone do [Twitter](https://twitter.com) em um escopo reduzido, abordaremos os seguintes casos de uso:

1. Um **perfil** pode postar ***tweets***;
2. Um **perfil** pode curtir ***tweets***;
3. Um **perfil** pode descurtir ***tweets***;
4. Um **perfil** pode seguir outros **perfis**;
5. Um **perfil** irá visualizar os ***tweets*** de outros **perfis** que ele segue na página inicial;
6. Um **perfil** pode procurar por outros **perfis**;
7. As visualizações de um **tweet** serão contabilizadas;

## Backend
O *backend* do sistema foi construído utilizando ```JAVA``` e ```Spring Framework```. Para gerenciar as dependências da aplicação foi utilizado ```Gradle```.

A aplicação foi construída seguindo o modelo de camadas **MVC**, conforme ilustrado pela figura abaixo:

Para o **backend**, uma **API Rest** foi construída, disponibilizando diversos ***endpoints*** que possibilitam a correta execução dos casos de uso descritos na seção anterior.

Abaixo serão listados os principais ***endpoints*** disponibilizados pela **API**:

1. **GET /profiles/{login}** - Retorna o perfil com **{login}** se existir

2. **POST /profiles/create** - Cria um perfil caso ainda não exista
   ```
    {
      "name":string,
      "login":string,
      "email":string
    }
    ```
3. **POST /profiles/{login}/follow** - Faz com que o perfil {login} siga o perfil passado no **body**
   ```
    {
      "followed": string
    }
    ```
4. **POST /profiles/{login}/unfollow** - Faz com que o perfil {login} deixe de seguir o perfil passado no **body**
   ```
    {
      "followed": string
    }
    ```
5. **POST /profiles/search** - Busca perfis que cujos **login** contenha o valor passado no **body**
   ```
    {
      "login": string
    }
    ```
6. **POST /tweets/create** - Cria um **tweet** para o perfil passado no **body**
   ```
    {
      "author_login": string,
      "content": string
    }
    ```
7. **GET /tweets/{id}/like** - Adiciona um like ao **tweet** com **{id}**

8. **GET /tweets/{id}/unlike** - Remove um like ao **tweet** com **{id}**

9. **GET /tweets/{id}/view** - Adiciona uma visualização ao **tweet** com **{id}**

10. **GET /tweets/{login}/list** - Retorna uma lista de **tweets** do perfil com **{login}**

11. **GET /tweets/{login}/follows/list** - Retorna uma lista de **tweets** dos perfis que o perfil com **{login}** segue

## Frontend
O *frontend* foi desenvolvido utilizando `HTML`, `Tailwind`, `React` e `NextJS` com `Typescript`. Para a construção da interface, foi utilizado ainda `Shadcn-ui` como biblioteca.

A autenticação do usuário foi feita utilizando `next-auth` e `Github` como servidor de identidade. A proteção das rotas foi feita utilizando ```middleware``` do ```NextJS```.

Várias técnicas de ```client side``` e ```server side``` foram utilizadas para garantir a melhor experiência do usuário.

Contudo, devido a limitação de tempo e redução do escopo do projeto, várias otimizações não foram feitas. Por exemplo, a paginação dos **tweets** não foi implementada, o que pode causar problemas de performance em perfis com muitos **tweets**, ou ainda a busca por perfis é realizada a cada vez que o usuário digita uma letra, o que pode causar problemas de performance e aumentar muito a quantidade de ***requests*** ao ***backend***.

## Para mais informações
Se quiser mais informações sobre o projeto, por favor me contate em [https://www.doutorwaka.com/contact](https://www.doutorwaka.com/contact).

## Mais sobre o autor

Olá! Tudo bem? Eu me chamo José Eurípedes, tenho 35 anos e sou doutor em Ciência da Computação. Escrevi minhas primeiras linhas de código com 13 anos e hoje tenho uma grande paixão em ensinar tudo o que aprendi nessa minha caminhada de 22 anos de experiência.

Para saber mais sobre mim, basta acessar minhas redes sociais:
  - [Meu Curso de Programação](https://www.doutorwaka.com/)
  - [YouTube](https://www.youtube.com/@doutorwaka)
  - [Instagram](https://instagram.com/doutorwaka)
  - [TikTok](https://www.tiktok.com/@doutorwaka)
  - [Site Pessoal](https://www.doutorwaka.com/)
