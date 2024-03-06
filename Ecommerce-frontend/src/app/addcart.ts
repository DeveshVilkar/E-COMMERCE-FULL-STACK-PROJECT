export class Addcart {
   private product_id!:number
   private quantity!:number

   constructor(){}

   setProduct_id(id:number){
    this.product_id=id
   }
   getProduct_id(){
    return this.product_id;
   }

   setQuantity(quant:number){
    this.quantity=quant
   }
   getQuantity(){
    return this.getQuantity;
   }
}
