use('estoque')
const estados = [
	{
		"codigo_uf": 11,
		"uf": "RO",
		"nome": "Rondônia",
		"latitude": -10.83,
		"longitude": -63.34
	},
	{
		"codigo_uf": 12,
		"uf": "AC",
		"nome": "Acre",
		"latitude": -8.77,
		"longitude": -70.55
	},
	{
		"codigo_uf": 13,
		"uf": "AM",
		"nome": "Amazonas",
		"latitude": -3.47,
		"longitude": -65.1
	},
	{
		"codigo_uf": 14,
		"uf": "RR",
		"nome": "Roraima",
		"latitude": 1.99,
		"longitude": -61.33
	},
	{
		"codigo_uf": 15,
		"uf": "PA",
		"nome": "Pará",
		"latitude": -3.79,
		"longitude": -52.48
	},
	{
		"codigo_uf": 16,
		"uf": "AP",
		"nome": "Amapá",
		"latitude": 1.41,
		"longitude": -51.77
	},
	{
		"codigo_uf": 17,
		"uf": "TO",
		"nome": "Tocantins",
		"latitude": -9.46,
		"longitude": -48.26
	},
	{
		"codigo_uf": 21,
		"uf": "MA",
		"nome": "Maranhão",
		"latitude": -5.42,
		"longitude": -45.44
	},
	{
		"codigo_uf": 22,
		"uf": "PI",
		"nome": "Piauí",
		"latitude": -6.6,
		"longitude": -42.28
	},
	{
		"codigo_uf": 23,
		"uf": "CE",
		"nome": "Ceará",
		"latitude": -5.2,
		"longitude": -39.53
	},
	{
		"codigo_uf": 24,
		"uf": "RN",
		"nome": "Rio Grande do Norte",
		"latitude": -5.81,
		"longitude": -36.59
	},
	{
		"codigo_uf": 25,
		"uf": "PB",
		"nome": "Paraíba",
		"latitude": -7.28,
		"longitude": -36.72
	},
	{
		"codigo_uf": 26,
		"uf": "PE",
		"nome": "Pernambuco",
		"latitude": -8.38,
		"longitude": -37.86
	},
	{
		"codigo_uf": 27,
		"uf": "AL",
		"nome": "Alagoas",
		"latitude": -9.62,
		"longitude": -36.82
	},
	{
		"codigo_uf": 28,
		"uf": "SE",
		"nome": "Sergipe",
		"latitude": -10.57,
		"longitude": -37.45
	},
	{
		"codigo_uf": 29,
		"uf": "BA",
		"nome": "Bahia",
		"latitude": -13.29,
		"longitude": -41.71
	},
	{
		"codigo_uf": 31,
		"uf": "MG",
		"nome": "Minas Gerais",
		"latitude": -18.1,
		"longitude": -44.38
	},
	{
		"codigo_uf": 32,
		"uf": "ES",
		"nome": "Espírito Santo",
		"latitude": -19.19,
		"longitude": -40.34
	},
	{
		"codigo_uf": 33,
		"uf": "RJ",
		"nome": "Rio de Janeiro",
		"latitude": -22.25,
		"longitude": -42.66
	},
	{
		"codigo_uf": 35,
		"uf": "SP",
		"nome": "São Paulo",
		"latitude": -22.19,
		"longitude": -48.79
	},
	{
		"codigo_uf": 41,
		"uf": "PR",
		"nome": "Paraná",
		"latitude": -24.89,
		"longitude": -51.55
	},
	{
		"codigo_uf": 42,
		"uf": "SC",
		"nome": "Santa Catarina",
		"latitude": -27.45,
		"longitude": -50.95
	},
	{
		"codigo_uf": 43,
		"uf": "RS",
		"nome": "Rio Grande do Sul",
		"latitude": -30.17,
		"longitude": -53.5
	},
	{
		"codigo_uf": 50,
		"uf": "MS",
		"nome": "Mato Grosso do Sul",
		"latitude": -20.51,
		"longitude": -54.54
	},
	{
		"codigo_uf": 51,
		"uf": "MT",
		"nome": "Mato Grosso",
		"latitude": -12.64,
		"longitude": -55.42
	},
	{
		"codigo_uf": 52,
		"uf": "GO",
		"nome": "Goiás",
		"latitude": -15.98,
		"longitude": -49.86
	},
	{
		"codigo_uf": 53,
		"uf": "DF",
		"nome": "Distrito Federal",
		"latitude": -15.83,
		"longitude": -47.86
	}
]
db.estados.insertMany(estados)

use('estoque')
db.estados.find().count()

use('estoque')
db.estados.find({},{uf:1,nome:1, _id:0})
          .sort({nome:1})  //ORDENAÇÃO
          .limit(5) // limita o retorno de n registros
          .skip(5) // "Pula" n registros

use('estoque')
db.municipios.find().count() //5570

use('estoque')
db.municipios.find().limit(5)

use('estoque')
db.estados.find({codigo_uf:52 })

use('estoque')
db.municipios.aggregate([
    {$lookup: {
        from: 'estados',
        localField: 'codigo_uf',
        foreignField: 'codigo_uf',
        as: 'estado'
    }}
])

use('estoque')
db.estados.aggregate([
    {$lookup: {
        from: 'municipios',
        localField: 'codigo_uf',
        foreignField: 'codigo_uf',
        as: 'listaMunicipios'
    }}
])

use('estoque')
db.estados.aggregate([
    {$match: {nome: /São Paulo/i}},
    {$lookup: {
        from: 'municipios',
        localField: 'codigo_uf',
        foreignField: 'codigo_uf',
        as: 'listaMunicipios'
    }}
])