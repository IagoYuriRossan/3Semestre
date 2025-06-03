import express from "express"
import {
getMunicipios,
getMunicipioById,
createMunicipio,
updateMunicipio,
deleteMunicipio,
getMunicipiosByDistance
} from "../controllers/municipios.js"
import { validateMunicipio, validateUpdateMunicipio, validateObjectId } from "../middleware/validation.js"
import auth from '../middleware/auth.js'
const router = express.Router()

// Get all municipios
router.get("/", auth, getMunicipios)

// Get municipios by distance
router.get("/nearby", getMunicipiosByDistance)

// Get municipio by ID
router.get("/:id", auth,validateObjectId, getMunicipioById)

// Create new municipio
router.post("/", validateMunicipio, createMunicipio)

// Update municipio
router.put("/:id", validateObjectId, validateUpdateMunicipio, updateMunicipio)

// Delete municipio
router.delete("/:id", validateObjectId, deleteMunicipio)

export default router