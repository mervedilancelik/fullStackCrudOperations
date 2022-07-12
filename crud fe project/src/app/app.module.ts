import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TicketListComponent } from './ticket-list/ticket-list.component';
import { from } from 'rxjs';
import { CreateTicketComponent } from './create-ticket/create-ticket.component';
import {FormsModule} from '@angular/forms';
import { UpdateTicketComponent } from './update-ticket/update-ticket.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerCreateComponent } from './customer-create/customer-create.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { ObjectListComponent } from './object-list/object-list.component';
import { ObjectCreateComponent } from './object-create/object-create.component';
import { UpdateObjectComponent } from './update-object/update-object.component';
import { PieceListComponent } from './piece-list/piece-list.component';
import { PieceCreateComponent } from './piece-create/piece-create.component';
import { UpdatePieceComponent } from './update-piece/update-piece.component'

@NgModule({
  declarations: [
    AppComponent,
    TicketListComponent,
    CreateTicketComponent,
    UpdateTicketComponent,
    CustomerListComponent,
    CustomerCreateComponent,
    UpdateCustomerComponent,
    ObjectListComponent,
    ObjectCreateComponent,
    UpdateObjectComponent,
    PieceListComponent,
    PieceCreateComponent,
    UpdatePieceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
