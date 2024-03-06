import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductListComponent } from './product-list/product-list.component';
import { SaveproductComponent } from './saveproduct/saveproduct.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import { ForgetComponent } from './forget/forget.component';

const routes: Routes = [
  {path:'product', component:ProductListComponent},
  {path:'', redirectTo:'home',pathMatch:'full'},
  {path:'saveproduct', component:SaveproductComponent},
  {path:'loginuser',component:LoginUserComponent},
  {path:'cart',component:CartComponent},
  {path:'home',component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
