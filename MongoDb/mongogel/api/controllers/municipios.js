import { ObjectId } from "mongodb"

// Get all municipios with optional pagination and sorting
export const getMunicipios = async (req, res) => {
try {
  const { page = 1, limit = 10, nome, sort, order = "asc" } = req.query
  const skip = (page - 1) * limit

  const query = {}
  if (nome) {
    query.nome = { $regex: nome, $options: "i" }
  }

  const db = req.app.locals.db

  // Configuração de ordenação
  const sortOptions = {}
  if (sort) {
    sortOptions[sort] = order.toLowerCase() === "desc" ? -1 : 1
  } else {
    // Ordenação padrão por nome se nenhuma for especificada
    sortOptions.nome = 1
  }

  const municipios = await db
    .collection("municipios")
    .find(query)
    .sort(sortOptions)
    .skip(Number.parseInt(skip))
    .limit(Number.parseInt(limit))
    .toArray()

  const total = await db.collection("municipios").countDocuments(query)

  res.status(200).json({
    data: municipios,
    pagination: {
      total,
      page: Number.parseInt(page),
      limit: Number.parseInt(limit),
      pages: Math.ceil(total / limit),
    },
  })
} catch (error) {
  console.error("Erro ao buscar municípios:", error)
  res.status(500).json({ error: true, message: "Falha ao buscar municípios" })
}
}

// Get municipio by ID
export const getMunicipioById = async (req, res) => {
try {
  const { id } = req.params
  const db = req.app.locals.db

  const municipio = await db.collection("municipios").findOne({
    _id: new ObjectId(id),
  })

  if (!municipio) {
    return res.status(404).json({ error: true, message: "Município not found" })
  }

  res.status(200).json(municipio)
} catch (error) {
  console.error("Error fetching municipio:", error)
  res.status(500).json({ error: true, message: "Failed to fetch municipio" })
}
}

// Create new municipio
export const createMunicipio = async (req, res) => {
try {
  const { codigo_ibge, nome, capital, codigo_uf, local } = req.body
  const db = req.app.locals.db

  // Check if municipio with same IBGE code already exists
  const existingMunicipio = await db.collection("municipios").findOne({ codigo_ibge })
  if (existingMunicipio) {
    return res.status(409).json({
      error: true,
      message: "Município with this IBGE code already exists",
    })
  }

  const newMunicipio = {
    codigo_ibge,
    nome,
    capital,
    codigo_uf,
    local,
  }

  const result = await db.collection("municipios").insertOne(newMunicipio)

  res.status(201).json({
    _id: result.insertedId,
    ...newMunicipio,
  })
} catch (error) {
  console.error("Error creating municipio:", error)
  res.status(500).json({ error: true, message: "Failed to create municipio" })
}
}

// Update municipio
export const updateMunicipio = async (req, res) => {
try {
  const { id } = req.params
  const updateData = req.body
  const db = req.app.locals.db

  // If updating codigo_ibge, check if it conflicts with another municipio
  if (updateData.codigo_ibge) {
    const existingMunicipio = await db.collection("municipios").findOne({
      codigo_ibge: updateData.codigo_ibge,
      _id: { $ne: new ObjectId(id) },
    })

    if (existingMunicipio) {
      return res.status(409).json({
        error: true,
        message: "Another município already has this IBGE code",
      })
    }
  }

  const result = await db.collection("municipios").updateOne({ _id: new ObjectId(id) }, { $set: updateData })

  if (result.matchedCount === 0) {
    return res.status(404).json({ error: true, message: "Município not found" })
  }

  const updatedMunicipio = await db.collection("municipios").findOne({
    _id: new ObjectId(id),
  })

  res.status(200).json(updatedMunicipio)
} catch (error) {
  console.error("Error updating municipio:", error)
  res.status(500).json({ error: true, message: "Failed to update municipio" })
}
}

// Delete municipio
export const deleteMunicipio = async (req, res) => {
try {
  const { id } = req.params
  const db = req.app.locals.db

  const result = await db.collection("municipios").deleteOne({
    _id: new ObjectId(id),
  })

  if (result.deletedCount === 0) {
    return res.status(404).json({ error: true, message: "Município not found" })
  }

  res.status(200).json({ message: "Município deleted successfully" })
} catch (error) {
  console.error("Error deleting municipio:", error)
  res.status(500).json({ error: true, message: "Failed to delete municipio" })
}
}

// Get municipios by distance from a point
export const getMunicipiosByDistance = async (req, res) => {
try {
  const { latitude, longitude, distance = 100, page = 1, limit = 10 } = req.query
  
  // Validar parâmetros
  if (!latitude || !longitude) {
    return res.status(400).json({ 
      error: true, 
      message: "Latitude e longitude são obrigatórios" 
    })
  }
  
  const lat = parseFloat(latitude)
  const lng = parseFloat(longitude)
  const maxDistance = parseFloat(distance) * 1000 // Converter km para metros
  const skip = (parseInt(page) - 1) * parseInt(limit)
  
  // Validar valores
  if (isNaN(lat) || lat < -90 || lat > 90) {
    return res.status(400).json({ 
      error: true, 
      message: "Latitude deve ser um número entre -90 e 90" 
    })
  }
  
  if (isNaN(lng) || lng < -180 || lng > 180) {
    return res.status(400).json({ 
      error: true, 
      message: "Longitude deve ser um número entre -180 e 180" 
    })
  }
  
  if (isNaN(maxDistance) || maxDistance <= 0) {
    return res.status(400).json({ 
      error: true, 
      message: "Distância deve ser um número positivo" 
    })
  }
  
  const db = req.app.locals.db
  
  // Usar o operador $geoNear para encontrar municípios próximos
  const geoNearPipeline = [
    {
      $geoNear: {
        near: {
          type: "Point",
          coordinates: [lng, lat] // MongoDB usa [longitude, latitude]
        },
        distanceField: "distanceFromUser",
        maxDistance: maxDistance,
        spherical: true,
        distanceMultiplier: 0.001 // Converter metros para km
      }
    },
    {
      $skip: skip
    },
    {
      $limit: parseInt(limit)
    }
  ]
  
  // Executar a consulta
  const municipios = await db.collection("municipios").aggregate(geoNearPipeline).toArray()
  
  // Contar o total de resultados (sem paginação)
  const countPipeline = [
    {
      $geoNear: {
        near: {
          type: "Point",
          coordinates: [lng, lat]
        },
        distanceField: "distanceFromUser",
        maxDistance: maxDistance,
        spherical: true
      }
    },
    {
      $count: "total"
    }
  ]
  
  const countResult = await db.collection("municipios").aggregate(countPipeline).toArray()
  const total = countResult.length > 0 ? countResult[0].total : 0
  
  res.status(200).json({
    data: municipios,
    pagination: {
      total,
      page: parseInt(page),
      limit: parseInt(limit),
      pages: Math.ceil(total / parseInt(limit))
    }
  })
} catch (error) {
  console.error("Erro ao buscar municípios por distância:", error)
  res.status(500).json({ 
    error: true, 
    message: "Falha ao buscar municípios por distância",
    details: error.message
  })
}
}