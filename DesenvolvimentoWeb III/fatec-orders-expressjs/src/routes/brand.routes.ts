import express, { NextFunction, response } from "express";
import { Request, Response } from "express";
import { BrandModel } from "../models/brand.models";
import { listAll, create} from "../controllers/brand.controller";
import jwt  from "jsonwebtoken";

import { AuthorizeMiddleware } from "../middlewares/authorize.middleware";

const router = express.Router();


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

router.get("/", async(req: Request, res: Response) => {
    const brands = await listAll();
    res.json(brands);
});

router.post("/",
    createBrandMiddleware, async(req: Request, res: Response) => {
    const {description} = req.body;
    const brand = await create(description);
    res.json(brand);
})

export default router;
