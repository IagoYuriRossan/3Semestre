import { ObjectId } from "mongodb"
import bcrypt from 'bcryptjs'
import jwt from 'jsonwebtoken'

export const insereUsuario = async (req, res) => {
    try {
        req.body.avatar = `https://ui-avatars.com/api/?name=${req.body.nome.replace(/ /g, '+')}&background=F00&color=FFF`
        
        // Criptografia da senha
        const salt = await bcrypt.genSalt(10)
        req.body.senha = await bcrypt.hash(req.body.senha, salt)

        // Inserção no banco de dados
        const db = req.app.locals.db
        const result = await db.collection('usuarios').insertOne(req.body)

        res.status(201).send(result)
    } catch (err) {
        console.error("Erro ao inserir usuário:", err)
        res.status(400).json({ erro: err.message || "Erro desconhecido" })
    }
}


export const efetuaLogin = async (req, res) => {
    const { email, senha} = req.body
    try{
        const db = req.app.locals.db
        //Verificar se o email existe no MongoDB
        let usuario = await db.collection('usuarios').find({email}).limit(1).toArray()
        //Se o array estiver vazio, é porque não tem...
        if(!usuario.length){
            return res.status(404).json({
                errors: [{
                    value: `${email}`,
                    msg: `O email ${email} não está cadastrado`,
                    param: 'email'
                }]
            })
        }
        //Verificando a senha...
        const isMatch = await bcrypt.compare(senha, usuario[0].senha)
        if (!isMatch)
            return res.status(403).json({//forbidden
                errors: [{
                    value: 'senha',
                    msg: 'A senha informada está incorreta',
                    param: 'senha'
                }]
        })
        //Se tudo ok, iremos gerar o token JWT
        jwt.sign(
            {usuario: {id: usuario[0]._id}},
            process.env.SECRET_KEY,
            {expiresIn: process.env.EXPIRES_IN},
            (err, token) => {
                if(err) throw err
                res.status(200).json({
                    access_token: token,
                    msg: 'Login efetuado com sucesso'
                })
            }
        )
    } catch (e){
        console.error(e)
    }
}