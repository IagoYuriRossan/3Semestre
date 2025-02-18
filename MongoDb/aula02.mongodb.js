//tipos de dados
//string,number, boolean, date, objectID
//Array, object
use ('estoque')
db.categorias.insertOne({nome:'bebidas', ativo:true})

use ('estoque')
//select*from categorias
db.categorias.find()

use('estoque')
db.categorias.insertOne({_id: '123', 
    nome:'sobremesa',
    ativo:true})

use('estoque')
db.categorias.find({}, {_id:1, nome:1})

use('estoque')
db.categorias.insertMany([
    {nome: 'entrada', ativo:true},
    {nome: 'Pães', ativo:false}
])

 use('estoque')
 db.produtos.insertOne({
    _id: '123',
    nome: 'hamburguer gourmet',
    preco: 35.99,
    ingredientes: ['pães', 'carne', 'queijo', 'alface', 'tomate'],
    vegetariano: false,
    dataCadrastro: new Date(),
    calorias:{
        total: 780,
        porcoes: 1
    }
 })

 use('estoque')
 db.produtos.find()

 use('estoque')
 db.produtos.insertOne({abobrinha:"tem"})

 use('estoque')
 db.produtos.drop()



 use('estoque') //validator para coleção
 db.createCollection('produtos',{
    validator: {
        $jsonSchema:{
            'bsonType': 'object',
            'required': ['_id', 'nome', 'preco', 'ingredientes', 'vegetariano', 'dataCadrastro']
        }
    }
 })


 use('estoque')
 db.getCollectionInfos({name:'produtos'})

 use('estoque')//mostrar o erro no insert
 try{
    db.produtos.insertOne({abobrinha:"tem"})
 } catch(err){
    printjson(err)
 }

 use('estoque')
 db.estados.insertMany([
    {sigla:'SP',nome: 'São Paulo', população: 1200000},
    {sigla:'AC',nome: 'Acre', população: 712000},
    {sigla:'RJ',nome: 'Rio de janeiro', população: 2500000},
 ])

 use('estoque')
 db.estados.find({}, //filtros
                 {}  //atributos a serem exibidos
)

use('estoque') //seleciona a sigla SP
db.estados.find({sigla: {$eq: 'SP'}}, {_id:0, nome:1},)

use('estoque')// seleciona todos menos SP
db.estados.find({sigla: {$ne: 'SP'}}, {_id:0, nome:1},)

use('estoque')
///o i = insensitive em caso de uso 
// $ = que termine
//^ = que inicie
db.estados.find({nome: /Paulo/i}, {_id:0, nome:1})

use('estoque')
db.estados.find({população: {$gt: 1200000}})

use('estoque')
db.estados.find({sigla: {$in:['AC', 'RJ']}})

use('estoque')
    db.estados.find({
        $or :  [
            {sigla: {$eq: 'RJ'}},
            {sigla: {$eq: 'AC'}}
        ]
},{_id:0, sigla:1, nome:1})

use('estoque')
db.estados.deleteOne({sigla: 'AC'})
db.estados.deleteOne({sigal: {$eq: 'AC'}})
//delete

use('estoque')
db.estados.deleteMany({nome: /o/i})


use('estoque')
db.estados.updateOne({sigla: {$eq: 'AC'}},
    {$set: {população: 1000, nome: 'Acre2'}}
)
//update


use('estoque')
db.estados.find({sigla: 'AC'})

use('estoque')
db.estados.updateMany({nome: /o/i}),
    {$set: }