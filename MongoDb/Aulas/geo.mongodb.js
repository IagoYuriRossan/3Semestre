use('estoque')
db.estados.find()
use('estoque')
db.estados.find().forEach(function(estado){
    db.estados.updateOne(
        {_id: estado._id},
        {$set: {
            local: {
                type: 'Point',
                coordinates: [estado.longitude, estado.latitude]
            }
        },
        $unset: {latitude: "", longitude: ""}
    }
    )
})
use('estoque')
db.estados.find({},{local: 1})

use('estoque')
//criando o indice 2dSphere
db.estados.createIndex({local: '2dsphere'})

use('estoque')
db.estados.find({
    local:{
        $near: {
            $geometry: {
                type: "Point",
                coordinates: [-47.4495,-23.5313]  //Fatec
            },
            $maxDistance: 20000000 //em metros -200km
        }
    }
},{nome:1, _id:0})

use('estoque')
db.estados.find({
    local: {
        $geoWithin: {
            $centerSphere: [[-47.4495, -23.5313],
            2000 / 6378.1]  // raio em radianos
        }
    }
}, {nome:1, _id:0})

/////////////////////////////////////////////////////////////////////////////////////////////
//AGORA COM MUNICIPIOS

use('estoque')
db.municipios.find()

use('estoque')
db.municipios.find().forEach(function(municipio){
    db.municipios.updateOne(
        {_id: municipio._id},
        {$set: {
            local: {
                type: 'Point',
                coordinates: [municipio.longitude, municipio.latitude]
            }
        },
        $unset: {latitude: "", longitude: ""}
    }
    )
})
use('estoque')
db.estados.find({},{local: 1})

use('estoque')
//criando o indice 2dSphere
db.municipios.createIndex({local: '2dsphere'})

use('estoque')
db.municipios.find({
    local:{
        $near: {
            $geometry: {
                type: "Point",
                coordinates: [-47.4495,-23.5313]  //Fatec
            },
            $maxDistance: 2000000 //em metros -200km
        }
    }
},{nome:1, _id:0})

use('estoque')
db.municipios.find({
    local: {
        $geoWithin: {
            $centerSphere: [[-47.4495, -23.5313],
            50 / 6378.1]  // raio em radianos
        }
    }
}, {nome:1, _id:0})