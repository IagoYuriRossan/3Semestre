import express, { NextFunction, Request, Response } from "express"
import jwt from "jsonwebtoken"

import dotenv from "dotenv";
dotenv.config();

export const authRouter = express.Router();

 /**
 * @swagger
 * /auth:
 *   post:
 *     summary: Autenticação
 *     tags: [Authentication]
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               username:
 *                 type: string
 *                 example: admin
 *               password:
 *                 type: string
 *                 example: admin
 *     responses:
 *       200:
 *         description: Autenticado com sucesso */

authRouter.post("/", (req: Request, res: Response) => {
    const { username, password } = req.body;

    if(username === "admin" && password === "admin"){
        const secret = process.env.AUTH_SECRET || "";
        const token = jwt .sign({ username: "admin"}, secret)
        res.status(200).json({token});
    }
        
    res.status(401).send();
});