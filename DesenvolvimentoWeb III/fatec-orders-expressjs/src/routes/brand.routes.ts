import express, { NextFunction, response } from "express";
import { Request, Response } from "express";
import { listAll, create} from "../controllers/brand.controller";
import { AuthorizeMiddleware } from "../middlewares/authorize.middleware";

const router = express.Router();

router.use(AuthorizeMiddleware);

const logger = (req: Request, res: Response, next:NextFunction) => {
    console.log("LOGGED");
    next();
};

const createBrandMiddleware = (
    req: Request,
    res: Response,
    next: NextFunction,
) => {
    console.log("Descrição: ", req.body.description);
    next();
};


router.use(logger);


router.use(AuthorizeMiddleware)
/**
* @swagger
* /brand:
*  get:
*   summary: Lista todas as marcas
*   tags: [Brand]
*   security:
*   - TokenAuth: []
*   responses:
*     200:
*       description: Lista de marcas
*       content:
*         application/json:
*           schema:
*             type: array
*             items:
*                $ref: '#/components/schemas/Brand'
*/

router.get("/", async(req: Request, res: Response) => {
    const brands = await listAll();
    res.json(brands);
});



 /**
 * @swagger
 * /brand:
 *   post:
 *     summary: Cadastro de marca
 *     tags: [Brand]
 *     security:
 *       - TokenAuth: []
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *          schema:
 *           type: object
 *           properties:
 *             description:
 *               type: string
 *               example: "Fandangos"
 *         description: Marca
 *     responses:
 *       201:
 *         description: Marca cadastrada com sucesso
 */
router.post("/",
    createBrandMiddleware, async(req: Request, res: Response) => {
    const {description} = req.body;
    const brand = await create(description);
    res.json(brand);
})

 /**
 * @swagger
 * /brand/{id}:
 *   get:
 *     summary: Busca uma marcar por ID
 *     tags: [Brand]
 *     security:
 *       - TokenAuth: []
 *     parameters:
 *       - in: path
 *         name: id
 *         required: true
 *         description: ID da marca  que será buscada
 *         schema:
 *           type: number
 *     responses:
 *       200:
 *         description: Marca localizada
 *         content:
 *           application/json:
 *             schema:
 *               $ref: '#/components/schemas/Brand'
 */

export default router;
