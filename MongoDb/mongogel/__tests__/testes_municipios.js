/**
 * Testes na API de Municipios
 * 
 */
const request = require('supertest')
const dotenv = require('dotenv')
const { ObjectId } = require('mongodb')
dotenv.config() //carrega os valores do .env

const baseURL = 'http://localhost:3000/api'

describe('API REST de Municipios sem o Token', () => {
    it('GET / Lista todos os municipios s/o token', async() => {
        const response = await request(baseURL)
        .get('/municipios')
        .set('Content-Type', 'application/json')
        .expect(401) // Unauthorized
    })

    it('GET - Listar o municipio pelo ID s/token', async() =>{
        const id = '67cf887b9261b0f74c36a065'
        const response = await request(baseURL)
        .get(`/municipios/${id}`)
        .set('Content-Type', 'application/json')
        .expect(401) // unauthorized
    })
})

    describe('API REST de Municipios com o token', () => {
        let token //armazenarmos o token JWT
        it('POST = Autentica o Usuario', async() => {
            const senha = process.env.SENHA_USUARIO
            const response = await request (baseURL)
            .post('/usuarios/login')
            .set('Content-Type','application/json')
            .send({"email":"iaguin.rossan@fatec.gov.br","senha": senha})
            .expect(200) //OK

            token = response.body.access_token
            expect(token).toBeDefined()  //recebemos o token?
        })

        it('Obter os municipios com o token', async() => {
            const response = await request(baseURL)
            .get('/municipios')
            .set('Content-Type','application/json')
            .set('access-token', token) //inclui o token
            .expect(200) //OK

            const municipios = response.body
            expect(municipios).toBeInstanceOf(Object)
        })
    })