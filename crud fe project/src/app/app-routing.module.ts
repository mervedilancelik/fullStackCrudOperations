import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateTicketComponent } from './create-ticket/create-ticket.component';
import { CustomerCreateComponent } from './customer-create/customer-create.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { ObjectCreateComponent } from './object-create/object-create.component';
import { ObjectListComponent } from './object-list/object-list.component';
import { PieceCreateComponent } from './piece-create/piece-create.component';
import { PieceListComponent } from './piece-list/piece-list.component';
import { TicketListComponent } from './ticket-list/ticket-list.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { UpdateObjectComponent } from './update-object/update-object.component';
import { UpdatePieceComponent } from './update-piece/update-piece.component';
import { UpdateTicketComponent } from './update-ticket/update-ticket.component';

const routes: Routes = [
  {path: 'ticket', component:TicketListComponent},
  {path: 'create-ticket', component:CreateTicketComponent},
  {path:'customer-list',component:CustomerListComponent},
  {path:'customer-create',component:CustomerCreateComponent},
  {path: '', redirectTo: 'ticket', pathMatch: 'full'},
  {path: 'update-ticket/:id',component:UpdateTicketComponent},
  {path:'update-customer/:id',component:UpdateCustomerComponent},
  {path:'update-object/:id',component:UpdateObjectComponent},
  {path:'update-piece/:id',component:UpdatePieceComponent},
  {path:'object-list',component:ObjectListComponent},
  {path:'piece-list',component:PieceListComponent},
  {path:'object-create',component:ObjectCreateComponent},
  {path:'piece-create',component:PieceCreateComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
