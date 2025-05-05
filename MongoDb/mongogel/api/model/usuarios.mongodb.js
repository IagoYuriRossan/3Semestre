use('test')
db.usuarios.insertOne({
    'nome': 'Maria José',
    'email': 'mariajose@uol.com.br',
    'senha': '123Mudar',
    'ativo': true,
    'tipo': 'Cliente',//ou Admin
    'avatar': 'https://ui-avatars.com/api?name=Iago+Rossan&background=F00&color=FFF'
})

//criando um índice único para o email.
use('test')
db.usuarios.createIndex({'email':1},{unique:true})

//Listando os usuários
use('test')
db.usuarios.find({},{senha:0})