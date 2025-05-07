import express from 'express'
import { insereUsuario } from '../controllers/usuarios.js'
import { validateUsuario } from '../middleware/validations.js'

const router = express.Router()
//Cria novo usuário
router.post('/', validateUsuario, insereUsuario)

export default router