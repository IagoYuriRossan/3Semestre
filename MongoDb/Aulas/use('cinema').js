use('cinema')
db.filmes.insertOne({
    "titulo": "Guerra nas Estrelas",
    "ano": 1978,
    "diretor": "George Lucas",
    "Classificação": "⭐⭐⭐⭐⭐",
    "tituloJp": "スター・ウォーズ"
})

use('cinema')
db.filmes.insertOne({
    "titulo": "Guerra nas Estrelas II",
    "ano": 1981,
    "diretor": "George Lucas",
    "Classificação": "⭐⭐⭐",
})

use('cinema')
db.filmes.find({}{}) //select * from filmes

use('cinema')
db.filmes.find({},{titulo:1, ano:1, _id:0})
//select titulo, ano filmes

use('cinema')
db.filmes.find({ano:1978}, {titulo:1, diretor:1, _id:0})
//select titulo diretor frim filmes where ano = 1978