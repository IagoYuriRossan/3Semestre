import { ObjectId } from "mongodb"

export const insereUsuario = async(req, res) => {
    req.body.avatar = `https://ui-avatars.com/api/?name=${req.body.nome.replace
    (/ /g,'+')}&background=F00&color=FFF`
    //bcryptjs -> Criptografar o conteudo
    //jsonwebtoken -> Para gerar o JWT
    //npm i bcryptjs jsonwebtoken
}