export class Cartitems {
    id!: number;
    quantity!: number; 
    product!: {
      id: number;
      name: string;
      imageurl: string;
      price: number;
      description: string;
    };
}
