import express from 'express'
import { createMunicipio, getMunicipiosById } from '../controllers/municipios.js'
import { validateMunicipio } from '../middleware/validations.js'

const router = express.Router()

//GET Municipio by id
router.get('/:id', getMunicipiosById)

//POST Cria um novo municipio
router.post('/', validateMunicipio, createMunicipio)
export default router