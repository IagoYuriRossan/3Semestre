'use strict';

const { DataTypes } = require('sequelize');
const { ForeignKey } = require('sequelize-typescript');

/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up (queryInterface, Sequelize) {
    await queryInterface.createTable('produtos',{
      id_produto:{
        primaryKey: true,
        allowNull: false,
        autoIncrement: true,
        type: DataTypes.INTEGER,
      },
      nome:{
        allowNull: false,
        type: DataTypes.STRING(100),
      },
      marca:{
        allowNull: false,
        autoIncrement: true,
        type: DataTypes.INTEGER,
        references:{
          model: "marca",
          key: "id_marca",
        },
        onUpdate: "CASCADE",
        onDelete: "CASCADE",
      },
      cod_barras:{
        allowNull: false,
        type: DataTypes.STRING(128),
      },
      id_fornecedor:{
        allowNull: false,
        type: DataTypes.INTEGER,
        ForeignKey: true,
      },
      id_estoque:{
        allowNull: false,
        type: DataTypes.INTEGER,       
      },
      preco:{
        allowNull: false,
        type: DataTypes.FLOAT(14,2), 
      },
      peso:{
        allowNull: false,
        type: DataTypes.FLOAT(14,2),       
      },
      unidade_medida:{
        allowNull: false,
        type: DataTypes.STRING(100),  
      },
    });
  },

  async down (queryInterface, Sequelize) {
    await queryInterface.dropTable('produtos');
  }
};
