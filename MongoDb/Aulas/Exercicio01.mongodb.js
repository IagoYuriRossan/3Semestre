//01 -  Crie a coleção "funcionarios" e insira os seguintes documentos usando o método insertMany
use('Empresa')
const dadosFuncionarios = [
    {
        nome: "João Silva",
        cargo: "Desenvolvedor",
        sexo: "Masculino",
        salario: 5000,
        departamento: "TI",
        dataContratacao: new Date("2023-01-01"),
        projetos: ["Projeto A", "Projeto B"],
        dataCadastro: new Date()
    },
    {
        nome: "Maria Santos",
        cargo: "Analista de Dados",
        sexo: "Feminino",
        salario: 4800,
        departamento: "TI",
        dataContratacao: new Date("2023-06-15"),
        projetos: ["Projeto C"],
        dataCadastro: new Date()
    },
    {
        nome: "Carlos Oliveira",
        cargo: "Desenvolvedor",
        sexo: "Masculino",
        salario: 5100,
        departamento: "TI",
        dataContratacao: new Date("2022-03-10"),
        projetos: ["Projeto B"],
        dataCadastro: new Date()
    },
    {
        nome: "Ana Pereira",
        cargo: "Gerente de Projetos",
        sexo: "Feminino",
        salario: 7500,
        departamento: "Gestão",
        dataContratacao: new Date("2021-09-20"),
        projetos: ["Projeto A", "Projeto C"],
        dataCadastro: new Date()
    },
    {
        nome: "Luis Fernandes",
        cargo: "Contador",
        sexo: "Masculino",
        salario: 4200,
        departamento: "Contabilidade",
        dataContratacao: new Date("2020-11-05"),
        projetos: [],
        dataCadastro: new Date()
    },
    {
        nome: "Luiza Costa",
        cargo: "Analista Financeira",
        sexo: "Feminino",
        salario: 4600,
        departamento: "Financeiro",
        dataContratacao: new Date("2023-04-18"),
        projetos: ["Projeto D"],
        dataCadastro: new Date()
    },
    {
        nome: "João Souza",
        cargo: "Desenvolvedor",
        sexo: "Masculino",
        salario: 4900,
        departamento: "TI",
        dataContratacao: new Date("2023-07-01"),
        projetos: ["Projeto A"],
        dataCadastro: new Date()
    }
]
db.funcionarios.insertMany(dadosFuncionarios)


//02 - Insira um novo funcionário usando o método insertOne(): 
use('Empresa')
db.funcionarios.insertOne({
    nome: "Fernanda Lima",
    cargo: "Designer Gráfico",
    sexo: "Feminino",
    salario: 4500,
    departamento: "Marketing",
    dataContratacao: new Date("2023-08-10"),
    projetos: ["Projeto E", "Projeto F"],
    dataCadastro: new Date()
})


//03 - Aumente o salário de todos os desenvolvedores em mais R$ 100 usando o método updateMany(): 
use('Empresa')
db.funcionarios.updateMany(
    { cargo: { $eq: 'Desenvolvedor' } },
    { $inc: { salario: +100 } }
)


//04 - Adicione o projeto "Projeto C" à lista de projetos do funcionário João Silva usando o método updateOne():
use('Empresa')
db.funcionarios.updateOne(
    { nome: { $eq: 'João Silva' } },
    { $push: { projetos: 'Projeto C' } }
)


//05 - Remova o campo "dataContratacao" de todos os funcionários usando o método updateMany(): 
use('Empresa')
db.funcionarios.updateMany({},
    { $unset: { dataContratacao: "" } })


//06 - Crie um novo campo chamado "bonificacao" e atribua o valor 500 para todos os 
//funcionários do departamento de TI usando o método updateMany():
use('Empresa')
db.funcionarios.updateMany(
    { departamento: { $eq: 'TI' } },
    { $set: { bonificacao: 500 } }
)


// 07 - Remova o registro do funcionário com o nome "João Silva".
use('Empresa')
db.funcionarios.deleteOne({ nome: 'João Silva' })


//08 - Remover todos os registros dos funcionários do departamento de "Contabilidade".
use('Empresa')
db.funcionarios.deleteMany({ departamento: 'Contabilidade' })


//09 - Mostre o nome, sexo e salário de todos os desenvolvedores:
use('Empresa')
db.funcionarios.find(
    { cargo: "Desenvolvedor" },
    { nome: 1, sexo: 1, cargo: 1, _id:0 })


//10 - Encontrar funcionários com salário maior que 4000:
use('Empresa')
db.funcionarios.find(
    { salario: { $gte: 4000 } },
    { nome: 1, salario: 1 })


//11 - Encontrar funcionários contratados em 2023: (Dica utilize o new Date() na comparação.
use('Empresa')
db.funcionarios.find({ dataCadastro: { $gte: new Date('2023') } })


//12 - Encontrar funcionários que trabalham no "Projeto A" ou no "Projeto B":
use('Empresa')
db.funcionarios.find({ projetos: { $in: ['Projeto A', 'Projeto B'] } }, { nome: 1, projetos: 1 })
// OOOOOUUU
use('Empresa')
db.funcionarios.find({ $or: [{ projetos: 'Projeto A' }, { projetos: 'Projeto B' }] }, { nome: 1, projetos: 1 })

// Passo 13 - Encontrar funcionários que não trabalham no "Projeto B":
use('Empresa')
db.funcionarios.find({projetos: {$not: {$eq: "Projeto B"}}})

// Passo 14 - Mostrar o nome, salário, departamento e sexo apenas dos funcionários do sexo
// feminino:
use('Empresa')
db.funcionarios.find(
    {sexo: {$eq: 'Feminino'}},
    {_id: 0, nome: 1, sexo: 1, departamento: 1, salario: 1}
)

// Passo 15 - Encontrar funcionários contratados antes de 2023 e com salário menor que 5000:
use('Empresa')
db.funcionarios.find({
    $and: [
    {dataContratacao: {$lte: new Date('2023-01-01')}},
    {salario: {$lt: 5000}}
]})

// Passo 16 - Encontrar funcionários que trabalham em mais de um projeto: (Dica utilize o operador
// $size)
use('Empresa')
db.funcionarios.find({projetos: {$size: 2}})
// $expr

// Passo 17 - Encontrar funcionários cadastrados nos últimos 30 dias:
use('Empresa')
let diaLimite = new Date()
diaLimite.setDate(diaLimite.getDate() - 30)
db.funcionarios.find({dataCadastro: {$gte: diaLimite}})

// Passo 18 - Encontrar funcionários cujo nome começa com "João":
use('Empresa')
db.funcionarios.find({nome: /^joão/i})

// Passo 19 - Encontrar funcionários cujo nome termina com "Silva":
use('Empresa')
db.funcionarios.find({nome: /silva$/i})

// Passo 20 - Encontrar funcionários cujo nome contenha Luis ou Luiz:
use('Empresa')
db.funcionarios.find({$or: [{nome: /luis/i}, {nome: /luiz/i}]})
////OUUUUUUU
use('Empresa')
db.funcionarios.find({$or: [{nome: /luis/i}|{nome: /luiz/i}]})

// Passo 21 - Encontrar todos os desenvolvedores do departamento de TI com salário maior que 4500:
use('Empresa')
db.funcionarios.find({$and: [{departamento: "TI"},
    {salario: {$gte: 4500}}]})

// Passo 22 - - Encontrar todos os funcionários que não são desenvolvedores e que foram contratados em 2023:
use('Empresa')
db.funcionarios.find({$and: [
    {cargo: {$not: /desenvolvedor/i}},
    {dataContratacao: {$gt: new Date('2023-01-01'), $lt: new Date('2023-12-31')}}
]})

// Passo 23 - Encontrar funcionários que trabalham no "Projeto A" ou no "Projeto B" e que tenham salário menor ou igual a 5000:
use('Empresa')
db.funcionarios.find({$and: [
    {$or: [{projetos: 'Projeto A'}, {projetos: 'Projeto B'}]},
    {salario: {$lte: 5000}}
]})

// Passo 24 - Encontrar funcionários que não sejam do departamento de TI e que não trabalhem no "Projeto A":
use('Empresa')
db.funcionarios.find({$and: [
    {departamento: {$not: /ti/i}},
    {projetos: {$not: /projeto a/i}}
]})

// Passo 25 - Encontrar funcionários que sejam do sexo feminino ou que tenham sido contratados antes de 2023:
use('Empresa')
db.funcionarios.find({$or: [
    {sexo: {$eq: /feminino/i}},
    {dataContratacao: {$lt: new Date('2023-01-01')}}
]})

// Passo 26 - Encontrar funcionários que são desenvolvedores ou analistas, com salário maior que 4000 e contratados a partir de 2023.
use('Empresa')
db.funcionarios.find({$and: [
    {$or: [
        {cargo: {$eq: "Desenvolvedor"}},
        {cargo: /^analista/i}
    ]},
    {salario: {$gt: 4000}},
    {dataContratacao: {$gte: new Date('2023-01-01')}}
]})

use('Empresa')
db.funcionarios.find()