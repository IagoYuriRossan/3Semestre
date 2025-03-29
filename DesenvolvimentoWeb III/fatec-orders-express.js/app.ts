//importação da biblioteca express
import express, { Request, Response } from "express";

//criação da aplicação
const app = express();

//configura aplicação para receber json no body das requisições
app.use(express.json());  ///

const products =[
    {
        id:1,
        name: "Feijão Carioca",
        brand: "Broto Legal",
        barCode: "98872531232101211238",
        supplier: "Rede de Distribuição Ltda",
        stockId: 98,
        price: 8.79,
        weight: 1,
        measureUnit: "Kg",
    },
    {
        id: 2,
        name: "Arroz",
        brand: "Tio João",
        barCode: "9328179803311239091",
        supplier: "Rede de Distribuição Ltda",
        stockId: 65,
        price: 29.99,
        weight: 5,
        measureUnit: "Kg",
    },
    {
        id:3,
        name: "Sucrilhos Radical",
        brand: "Kellogs",
        arCode: "90812872132132558e1",
        supplier: "Rede de Distribuição Ltda",
        stockId: 74,
        price: 10.00,
        weight: 0.5,
        measureUnit: "Kg"
    },
    {
        id:4,
        name: "Fanta Laranja",
        brand: "Coca-Cola",
        barCode: "90213135435356455658e1",
        supplier: "Rede de Distribuição Ltda",
        stockId: 41,
        price: 6.00,
        weight: 0.6,
        measureUnit: "Kg"
    }
]

// Define o método Http Get que responde np path / product/:id
app.get("/product/:id", (req: Request, res: Response) => {
    console.log(req.params.id);

    const product = products.find((product) => {
        return product.id === Number(req.params.id)
    })

    if(!product){
        res.status(404).json({});
        return;
    }

    res.status(200).json(product);
});

// Define o método Http Get que responde np path / product
app.get("/product", (req: Request,res: Response) => {
    console.log(req.query);
    res.status(200).json(products);
});

app.post("/product", (req: Request,res: Response) => {
    const product = req.body;
    products.push(product);
    res.status(201).send();
});                                 


// Novo método DELETE para excluir um produto por ID
app.delete("/product/:id", (req: Request, res: Response) => {
    const productId = Number(req.params.id);
 
    // Encontrar o índice do produto que queremos excluir
    const index = products.findIndex((product) => product.id === productId);
 
    // Se o produto não for encontrado, retorna 404
    if (index === -1) {
        res.status(404).json({ message: "Produto não encontrado" });
    }
 
    // Remove o produto do array
    products.splice(index, 1);
 
    // Retorna a confirmação de exclusão
    res.status(200).json({ message: "Produto deletado com sucesso" });
});

// Novo metodo PUT para alterar os produtos que quisermos
app.put("/product/:id", (req: Request, res: Response) => {
    const productId = Number(req.params.id);
    const alterar = req.body; // pega o corpo da requisição
    
    // Encontrar o índice do produto que queremos excluir
    const index = products.findIndex((alterar) => alterar.id === productId);

    // Se o produto não for encontrado, retorna 404
    if (index === -1) {
        res.status(404).json({ message: "Produto não encontrado" });
    }

    //Realiza a alteração
    products[index] = alterar;

    // Retorna a confirmação de alteração
    res.status(200).json({ message: "Produto alterado com sucesso" });
})

//Inicia aplicaçao na porta 3000
app.listen(3000, () => {
    console.log("Servidor executando na porta 3000");
});

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// CLIENTES

const clientes = [
    {
        id: 1,
        name: 'Iago Rossan',
        document: 50941408841,
        zipCode: 18103185,
        phone: '1599284-9046',
        email: 'iagorossanzao@gmail.com'
    },
    {
        id: 2,
        name: 'José Nauro',
        document: 41409927649,
        zipCode: 17105195,
        phone: '1599284-9046',
        email: 'iagorossanzao@gmail.com'
    }
]

// Define o método Http Get que responde np path / client/:id
app.get("/client/:id", (req: Request, res: Response) => {
    console.log(req.params.id);

    const client = clientes.find((client) => {
        return client.id === Number(req.params.id)
    })

    if(!client){
        res.status(404).send("Cliente não encontrado");
        return;
    }

    res.status(200).json(client);
});


// Define o método Http Get que responde np path / client
app.get("/client", (req: Request,res: Response) => {
    console.log(req.query);
    res.status(200).json(clientes);
});

//Define o método Http Post que responde no path / client
app.post("/client", (req: Request,res: Response) => {
    const client = req.body;
    clientes.push(client);
    res.status(201).send();
}); 


// Novo método DELETE para excluir um cliente por ID
app.delete("/client/:id", (req: Request, res: Response) => {
    const clientId = Number(req.params.id);
 
    // Encontrar o índice do produto que queremos excluir
    const index = clientes.findIndex((client) => client.id === clientId);
 
    // Se o produto não for encontrado, retorna 404
    if (index === -1) {
        res.status(404).json({ message: "Cliente não encontrado" });
    }
 
    // Remove o produto do array
    clientes.splice(index, 1);
 
    // Retorna a confirmação de exclusão
    res.status(200).json({ message: "Cliente deletado com sucesso" });
});


    // Novo metodo PUT para alterar os clientes que quisermos
app.put("/client/:id", (req: Request, res: Response) => {
    const clientId = Number(req.params.id);
    const alterarClient = req.body; // pega o corpo da requisição
    
    // Encontrar o índice do cliente que queremos excluir
    const index = clientes.findIndex((alterarClient) => alterarClient.id === clientId);

    // Se o cliente não for encontrado, retorna 404
    if (index === -1) {
        res.status(404).json({ message: "cliente não encontrado" });
    }

    //Realiza a alteração
    clientes[index] = alterarClient;

    // Retorna a confirmação de alteração
    res.status(200).json({ message: "Cliente alterado com sucesso" });
})