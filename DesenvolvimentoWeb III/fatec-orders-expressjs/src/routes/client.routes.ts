import express from "express";
import { Request, Response } from "express";
const router = express.Router();

/**
 * =======================================================================
 * APIs de Cliente
 * =======================================================================
 */

// Inicializa lista de clientes
const clients = [
    {
      id: 1,
      name: "João Rezende da Silva",
      document: "256214785478",
      zipCode: "74025140",
      phone: "12992541257",
      email: "joao.rezende@gmail.com",
    },
  ];
  
  /**
   * Define método Http Get, para busca de cliente por id
   *  que responde no path /client/:id
   * cliente: GET http://localhost:3000/client/12
   *
   */
  router.get("/client/:id", (req: Request, res: Response) => {
    const client = clients.find((client) => {
      return client.id === Number(req.params.id);
    });
  
    if (!client) {
      res.status(404).send();
      return;
    }
  
    // Responde requisição com o cliente encontrado
    res.status(200).json(client);
  });
  
  /**
   *
   * Define método Http Post, para cadastro de cliente
   *  que responde no path /client
   *
   * cliente: POST http://localhost:3000/client
   *
   */
  router.post("/client", (req: Request, res: Response) => {
    const client = req.body;
    clients.push(client);
  
    res.status(201).send();
  });
  
  /**
   *
   * Define método Http DELETE, para exclusão de cliente
   *  que responde no path /client/:id
   *
   * cliente: DELETE http://localhost:3000/client/1
   *
   */
  router.delete("/client/:id", (req: Request, res: Response) => {
    // atribui o id do cliente, recebido parâmetro à variável clientId
    const clientId = Number(req.params.id);
  
    // percorre a lista de clientes
    clients.forEach((client, index) => {
      // testa se o cliente atual da iteração é o cliente que está sendo excluído, pelo id
      if (client.id === clientId) {
        // remove apenas o cliente atual da lista "clients"
        clients.splice(index, 1);
  
        // retorna status http 204 - "No Content"
        res.status(204).send();
        // encerra execução da função, com return void
        return;
      }
    });
  
    // retorna status http 404 - "Não encontrado", pois cliente não foi localizado
    res.status(404).send();
  });
  
  /**
   *
   * Define método Http PUT, para alteração de cliente
   *  que responde no path /client/:id
   *
   * cliente: PUT http://localhost:3000/client/1
   *
   */
  router.put("/client/:id", (req: Request, res: Response) => {
    // atribui o id do cliente, recebido parâmetro à variável clientId
    const clientId = Number(req.params.id);
    // atribui o corpo da requisição à variável dataToUpdate
    const dataToUpdate = req.body;
  
    // percorre a lista de clientes
    clients.forEach((client, index) => {
      // testa se o cliente atual da iteração é o cliente que está sendo atualizado, pelo id
      if (client.id === clientId) {
        // se sim, então atualiza o cliente atual com os dados já existentes,
        // sobrescritos com os dados recebidos para atualização (uso de spread operator)
        clients[index] = { ...client, ...dataToUpdate };
  
        // retorna status http 204 - "No Content"
        res.status(204).send();
        // encerra execução da função, com return void
        return;
      }
    });
  
    // retorna status http 404 - "Não encontrado", pois cliente não foi localizado
    res.status(404).send();
    
  });

  const productFilters = req.query as unknown as IProductListFilters;
  export default router;