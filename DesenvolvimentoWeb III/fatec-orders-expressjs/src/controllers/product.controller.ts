import { IProduct, IProductListFilters } from "../../IProduct";

// Inicializa lista de produtos
const products = [
    {
      id: 1,
      name: "Feijão Carioca",
      brand: "Broto Legal",
      barCode: "98493874849278374989478",
      supplier: "Rede de Distribuição Ltda",
      stockId: 98,
      price: 8.79,
      weight: 1,
      measureUnit: "kg",
    },
    {
      id: 2,
      name: "Arroz",
      brand: "Tio João",
      barCode: "98475834587947857947984",
      supplier: "Rede de Distribuição Ltda",
      stockId: 65,
      price: 29.99,
      weight: 5,
      measureUnit: "kg",
    },
  ];

export const listProducts = (productFilters: IProductListFilters): IProduct[] => {

    const {
        name: nameFilter,
        brand: brandFilter,
        supplier: supplierFilter,
        stockId: stockIdFilter,
      } = productFilters;
    
      const foundProducts = products.filter(
        ({ name, brand, supplier, stockId }) => {
          if (!(nameFilter || brandFilter || supplierFilter || stockIdFilter))
            return true;
    
          let found = true;
    
          if (nameFilter && !name.toUpperCase().includes(nameFilter?.toUpperCase()))
            found = false;
    
          if (
            brandFilter &&
            !brand.toUpperCase().includes(brandFilter?.toUpperCase())
          )
            found = false;
    
          if (
            supplierFilter &&
            !supplier.toUpperCase().includes(supplierFilter?.toUpperCase())
          )
            found = false;
    
          if (stockId !== stockIdFilter) found = false;
    
          return found;
        }
      );
      return foundProducts;
}