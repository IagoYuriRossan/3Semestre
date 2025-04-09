import express from "express";
import { Request, Response } from "express";
import { IProductListFilters } from "../../IProduct";
import { listProducts } from "../controllers/product.controller";

const router = express.Router();

    /**
     * =======================================================================
     * APIs de Produto
     * =======================================================================
     */

/**
 * Define método Http Get, para busca de produto por id
 *  que responde no path /product/:id
 * cliente: GET http://localhost:3000/product/12
 */
router.get("/:id", (req: Request, res: Response) => {
  const product = products.find((product) => {
    return product.id === Number(req.params.id);
  });

  if (!product) {
    res.status(404).send();
    return;
  }

  // Responde requisição com o produto encontrado
  res.status(200).json(product);
});


/**
 * Define método Http Get, para listagem de produto
 *  que responde no path /product
 * cliente: GET http://localhost:3000/product
 */
router.get("/", (req: Request, res: Response) => {
  /**
   * TODO: implementar busca pelos filtros name, brand, supplier, stockId
   *  TODO: filtros de texto deverão buscar por partes das palavras e ignorar o case,
   *  TODO  ou seja, "banana" deverá retornar "Banana Prata", caso esteja cadastrada
   *  */

  const productFilters = req.query as unknown as IProductListFilters;
  
  const products = listProducts(productFilters);

  res.status(200).json(products);
});


/**
 * Define método Http Post, para cadastro de produto
 *  que responde no path /product
 * cliente: POST http://localhost:3000/product
 */
router.post("/", (req: Request, res: Response) => {
  const product = req.body;
  products.push(product);

  res.status(201).send();
});



/**
 * Define método Http DELETE, para exclusão de produto
 *  que responde no path /product/:id
 * cliente: DELETE http://localhost:3000/product/1
 */
router.delete("/:id", (req: Request, res: Response) => {
  // atribui o id do produto, recebido parâmetro à variável productId
  const productId = Number(req.params.id);

  // percorre a lista de produtos
  products.forEach((product, index) => {
    // testa se o produto atual da iteração é o produto que está sendo excluído, pelo id
    if (product.id === productId) {
      // remove apenas o produto atual da lista "products"
      products.splice(index, 1);

      // retorna status http 204 - "No Content"
      res.status(204).send();
      // encerra execução da função, com return void
      return;
    }
  });

  // retorna status http 404 - "Não encontrado", pois produto não foi localizado
  res.status(404).send();
});



/**
 * Define método Http PUT, para alteração de produto
 *  que responde no path /product/:id
 * cliente: PUT http://localhost:3000/product/1
 */
router.put("/:id", (req: Request, res: Response) => {
  // atribui o id do produto, recebido parâmetro à variável productId
  const productId = Number(req.params.id);
  // atribui o corpo da requisição à variável dataToUpdate
  const dataToUpdate = req.body;

  // percorre a lista de produtos
  products.forEach((product, index) => {
    // testa se o produto atual da iteração é o produto que está sendo atualizado, pelo id
    if (product.id === productId) {
      // se sim, então atualiza o produto atual com os dados já existentes,
      // sobrescritos com os dados recebidos para atualização (uso de spread operator)
      products[index] = { ...product, ...dataToUpdate };

      // retorna status http 204 - "No Content"
      res.status(204).send();
      // encerra execução da função, com return void
      return;
    }
  });

  // retorna status http 404 - "Não encontrado", pois produto não foi localizado
  res.status(404).send();
});

export default router;
