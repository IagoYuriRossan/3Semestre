import express from "express";
import { Request, Response } from "express";
import { BrandModel } from "../models/brand.models";
import { listAll, create} from "../controllers/brand.controller";

const router = express.Router();

    /**
     * =======================================================================
     * APIs de Brand
     * =======================================================================
     */

/**
 * Define método Http Get, para busca de brand por id
 *  que responde no path /product/:id
 * brand: GET http://localhost:3000/brand/12
 */
router.get("/", async(req: Request, res: Response) => {
    const brands = await listAll();
    res.json(brands);
});

router.post("/", async(req: Request, res: Response) => {
    const {description} = req.body;
    const brand = await create(description);
})

export default router;
