# ecommerce
Este é um Web Service RESTful CRUD básico simulando um carrinho de compras.

#É recomendado que se utilize um plugin como o postman no browser.

Para sua utilização basta primeiro cadastrar produtos, exemplo:

POST localhost:8080/shop/produtos

{"nome": "sapato", "valor": "100.0"}

Depois listar os produtos cadastrados:

GET localhost:8080/shop/produtos

[
  {
    "id": 1,
    "nome": "sapato", 
    "valor": "100.0"
  }
]

Em seguida incializar o carrinho de compras:

POST localhost:8080/shop/carrinhos

{}

Depois listar o carrinho:

GET localhost:8080/shop/carrinhos

[
  {
    "id": 1,
    "createdAt":1499396851000,
    "updatedAt"1499396851000:
  }
]

Depois adicionar o item:

POST localhost:8080/shop/itens/1/1

{"quantidade": 5}
