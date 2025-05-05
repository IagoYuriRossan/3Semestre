// Importação da biblioteca express
import express from "express";
import productRoutes from "./src/routes/product.routes";
import clientRoutes from "./src/routes/client.routes";
import brandRoutes from "./src/routes/brand.routes";
// Criação da aplicação
const app = express();

// Configura aplicação para receber json no body das requisições
app.use(express.json());

app.use("/product", productRoutes);
app.use("/client", clientRoutes);
app.use("/brand", brandRoutes);


  /**
   * Inicia aplicação na Porta 3000
   *  */
app.listen(3000, () => {
  console.log("Servidor executando na Porta 3000");
});