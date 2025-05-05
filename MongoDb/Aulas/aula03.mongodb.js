use('estoque')
const usuarios = [{nome: 'josé', idade: 22, sexo: 'M', hobbies:['surf', 'animes']},
                  {nome: 'Maria', idade: 24, sexo: 'F', hobbies:['judô','volley']}
]
db.usuarios.insertMany(usuarios)

use('estoque')
db.usuarios.find()

use('estoque')
db.usuarios.updateOne({nome: {$eq:'Maria'}},
    {$set: {nome: 'Maria Silva'}}
)

// Para incrementar ou decrementar um valor na alteração
db.usuarios.insertMany({},
    {$inc: {idade: +1}}
)

//$push  - Adiciona um novo elemento a um array
use('estoque')
db.usuarios.updateOne({nome: 'José'},
    {$push: {hobbies: 'Fotografia'}}
)

use('estoque')
db.usuarios.updateOne({nome: 'José'},
    {$set: {hobbies: 'Fotografia'}}
)

// $pull - Remove o elemento do Array
use('estoque')
db.usuarios.updateOne({sexo: {$eq: 'F'}},
    {$pull: {hobbies: 'judô'}}
)