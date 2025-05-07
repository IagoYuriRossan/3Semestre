import {check, param, validationResult} from 'express-validator'
import { ObjectId } from 'mongodb'
//const db = req

//middleware para verificar os resultados da validação
export const validateRequest = (req, res, next) => {
    const errors = validationResult(req)
    if(!errors.isEmpty()){
        return res.status(400).json({
            error: true,
            message: 'Erro de validação',
            errors: errors.array()
        })
    }
    next()
}
export const validateMunicipio = [
    check('codigo_ibge')
        .notEmpty()
        .withMessage('O código IBGE é obrigatorio')
        .isInt({min: 1000000, max: 9999999})
        .withMessage('O código IBGE deve ser um número inteiro de 7 dígitos'),
    check('nome')
        .notEmpty()
        .withMessage('O nome é obrigatorio')
        .isLength({max:100})
        .withMessage('O nome não pode ter mais ter mais de 100 carac.'),
    check('capital')
        .isBoolean()
        .withMessage('O campo capital deve ser um booleno.'),
    check('local')
        .notEmpty()
        .withMessage('O tipo do local é obrigatório')
        .equals('Point')
        .withMessage('O tipo do lolcal deve ser "POINT"'),
    check('local.coordinates')
        .notEmpty()
        .withMessage('As cordenadas são obrigatórias')
        .isArray({min:2, max:2})
        .withMessage('As coordenadas devem ser um Array com Latitude e Longitude'),
    check('local.coordinates.0')
        .isFloat({min: -180, max:180})
        .withMessage('A Longitude deve estar entre -180 e 180'),
    //aplica as validações
    validateRequest
]

//validações do usuario
export const validateUsuario = [
    check('nome')
        .not().isEmpty().trim().withMessage('É obrigatório informar o nome')
        .isAlpha('pt-BR',{ignore: ' '}).withMessage('Informe apenas Texto')
        .isLength({min:3}).withMessage('Informe no minimo 3 caracteres')
        .isLength({max:100}).withMessage('Informe no maximo 100 Caracteres'),
    check('email')
        .not().isEmpty().trim().withMessage('É obrigatório informar email')
        .isEmail().withMessage('Informe um email válido')
        .isLowercase().withMessage('Não são permitias maiúsculas')
        /*.custom((value, {  })=> {
            return db.collection('usuarios')
                .find({email: {$eq: value}}).toArray()
                .then((email) => {
                //verifica se não existe o ID para garantir que é inclusão
            if(email.length){
                return Promise.reject(`o email ${value} já existe!`)
            }
            })
        })*/,
        check('senha')
            .not().isEmpty().trim().withMessage('A senha é obrigatória')
            .isLength({min:6})
            .withMessage('A senha deve ter no mínimo 6 caracteres')
            .isStrongPassword({
                minlength: 6,
                minLowercase: 1, minUppercase: 1,
                minSymbols: 1, minNumbers: 1,
                minSymbols: 1, minNumbers: 1
            }).withMessage('A senha não e segura. Informe no mínimo 1 caractere maiúsculo, 1 minúsculo, 1 número e 1 caractere especial'),
            check('ativo')
                .default(true)
                .isBoolean().withMessage('O valor deve ser um booleano'),
            check('tipo')
                .default('Cliente')
                .isIn(['Cliente','Admin']).withMessage('O tipo deve ser Admin ou Cliente'),
            check('Avatar')
                .optional({nullable: true})
                .isURL().withMessage('A URL do Avatar é invalida'),
        //Aplica as validações.
        validateRequest
    ]
