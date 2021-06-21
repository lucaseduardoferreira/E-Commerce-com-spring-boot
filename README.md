# Avaliação Java - Store Games

Proposta da empresa Supera Tecnologia. 
Nessa API Rest, foi utilizada o framework Spring. Escolhi esse framework, pois facilita a criação de aplicações Java, com poucas ou nenhuma configurações para executar o projeto. Para criar e salvar solicitações HTTP e HTTPs, foi usado a API CLient Postman. 
O arquivo yml dado na proposta foi alterado para data.sql, onde na execução inicial do programa, já é inserido registros de produtos e clientes. Para guardar tais dados, foi usado o banco de dados em memória H2.


## Enpoints
### /produtos
    -Lista todos os produtos ou cadastra um -> localhost:8080/produtos
    -Lista todos os produtos ordenados por qualquer paramento de produto, no caso o exemplo foi por preco descrescente-> localhost:8080/produtos?sort=preco,DESC
    -Detalha um produto por ID - > localhost:8080/produtos/{ID}
    -Exemplo de JSON para cadastrar um prooduto -> 
        {
            "nome" : "Produto 1",
            "preco": "1.00",
            "score": "3",
            "imagem": "produto1.jpg"
        
        }
### /clientes
    -Lista todos os clientes ou cadastra um-> localhost:8080/clientes
    -Lista todos os clientes ordenados por qualquer paramento de produto, no caso o exemplo foi por nome descrescente-> localhost:8080/clientes?sort=preco,DESC
    -Detalha um cliente por ID - > localhost:8080/clientes/{ID}
    -Exemplo JSON para cadastrar um cliente -> 
        {
        "nome": "Cliente 1"
        }
### /pedidos
    Para cadastrar um Pedido, é necessário ter um cliente e pelo menos um produto, não fiz a checagem, se existe tais parametros, logo se tentar inserir um pedido e não existir cliente ou produto, irá gerar erros.
    -Lista todos os pedidos ou cadastra um -> localhost:8080/pedidos
    -Detalha um pedido por ID - > localhost:8080/pedidos/{ID}
    -Exemplo JSON para cadastrar um pedido -> 
    {
        "idCliente": 2,
        
        "itens":[
            {
            "produto": 1,
            "quantidade": 10
            },
             {
            "produto": 2,
            "quantidade": 2
            }
        ]
    }

## Testes
Foi criado testes para o controller, verificando se o código que irá retornar da requisição, é o 201. 
Também foi criado o teste para verificar se a regra de negócio frete maior de 250, seja igual a 0.

## Execução do projeto 
Para executar o projeto, usar o comando mvn spring-boot:run   .






    
    

