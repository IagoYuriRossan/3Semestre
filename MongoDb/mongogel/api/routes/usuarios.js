import express from 'express'
import { efetuaLogin, insereUsuario } from '../controllers/usuarios.js'
import { validateUsuario } from '../middleware/validations.js'

const router = express.Router()
//Cria novo usuário
router.post('/', validateUsuario, insereUsuario)

//valida o login
router.post('/login', efetuaLogin)

export default router