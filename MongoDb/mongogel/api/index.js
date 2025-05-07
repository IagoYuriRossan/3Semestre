import 'dotenv/config'
import express from 'express'
import cors from 'cors'//importa o módulo cors
import {connectToDatabase} from './config/db.js'
import municipiosRoutes from './routes/municipios.js'
import usuariosRoutes from './routes/usuarios.js'

const app = express()
app.use(cors())//Habilita o CORS Cross-Origin resource Sharing
const PORT = process.env.PORT || 3000
app.use(express.json()) // parse do JSON
//rota publica
app.use('/', express.static('public'))
//Rotas do app
app.use('/api/municipios', municipiosRoutes)
app.use('/api/usuarios', usuariosRoutes)
//define o favicon
app.use('/favicon.ico', express.static('public/images/logo.png'))
//start the server
connectToDatabase(app).then(() => {
    app.listen(PORT,() => { 
        console.log(`Servidor rodando na porta ${PORT}!`)
    })
})
//listen


