import { CreationOptional, DataTypes, Model, Optional } from "sequelize";
import { Brand } from "../interfaces/brand.interface";
import sequelize from "../config/database";

export type BrandCreationalAttributes = Optional<Brand, "id">;

export class BrandModel extends Model<Brand, BrandCreationalAttributes>{
    public id!: number;
    public description!: string;
}

BrandModel.init({
    id:{
        primaryKey: true,
        type: DataTypes.INTEGER,
        autoIncrement: true,
        allowNull: false,
        field: "id_marca",
    },
    description:{
        allowNull: false,
        type: DataTypes.STRING(100),
        field: "descricao",
    }
    },
    {
        tableName: "marca",
        sequelize,
        timestamps: false,
    }
);