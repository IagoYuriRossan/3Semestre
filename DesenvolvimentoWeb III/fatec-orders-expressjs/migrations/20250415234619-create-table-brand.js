'use strict';

const { DataTypes } = require('sequelize');
const { DataType } = require('sequelize-typescript');

/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up (queryInterface, Sequelize) {
   await queryInterface.createTable('marca',{
    id:{
      primaryKey: true,
      allowNull: false,
      autoIncrement: true,
      type: DataTypes.INTEGER,
    },
    descricao:{
      allowNull: false,
      type: DataTypes.STRING(100)
    }
   });
  },

  async down (queryInterface, Sequelize) {
    await queryInterface.dropTable('marca');
  }
};
