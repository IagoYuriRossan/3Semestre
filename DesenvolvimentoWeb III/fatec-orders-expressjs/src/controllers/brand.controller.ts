import { describe } from "node:test";
import { Brand } from "../interfaces/brand.interface";
import { BrandModel } from "../models/brand.models"

export const listAll = async(): Promise<Brand[]> => {
    const brands = await BrandModel.findAll();
    return brands
};


export const create = async (description: string): Promise<Brand> => {
    const brand = await BrandModel.create({ description});
    return brand;
}