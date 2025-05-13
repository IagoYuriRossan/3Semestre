import bcrypt from "bcryptjs"
import jwt from "jsonwebtoken"

export const insereUsuario = async(req, res) => {
    req.body.avatar = `https://ui-avatars.com/api/?name=${req.body.nome.replace
    (/ /g,'+')}&background=F00&color=FFF`
    //bcryptjs -> Criptografar o conteudo
    //jsonwebtoken -> Para gerar o JWT
    //npm i bcryptjs jsonwebtoken

    const salt = await bcrypt.genSalt(10) //10 rodadas de processamento do hash
    req.body.senha = await bcrypt.hash(req.body.senha, salt)
    //salvando o usuário...

    const db = req.app.locals.db
    await db.collection('usuarios')
        .insertOne(req.body)
        .then(result => res.status(201).send(result)
            .catch(err => res.status(400).json(err))
        )
}

export const efetuaLogin = async (req, res) => {
        const { email, senha} = req.body
        console.log(req.body)
        try{
            const db = req.app.locals.db
            //verificar se o email existe no MongoDB
            let usuario = await db.collection('usuarios').find({email}).limit(1).toArray()
            //Se o array estiver vazio, é porque não tem...
            if(!usuario.length){
                return res.status(404).json({
                    errors:[{
                        value: `${email}`,
                        msg: `O email ${email} não está cadastrado`,
                        param: 'email'
                    }]
                })
            }
            //Verificando a senha...
            const isMatch = await bcrypt.compare(senha, usuario[0].senha)
            if (!isMatch)
                return res.status(403).json({//forbiden
                    errors: [{
                        value: 'senha',
                        msg: 'A senha informada está incorreta',
                        param: 'senha'
                    }]
                })
                //se tudo ok, iremos gerar o token JWT
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
        }catch (e){
            console.error(e)
        }
}