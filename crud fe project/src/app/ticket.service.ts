import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer.interface';
import { ObjectPiece } from './object-piece.interface';
import { ObjectType } from './object-type.interface';
import { TicketType } from './ticket-type.interface';
import { Ticket } from './ticket.interface';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  private baseUrl="http://localhost:8080/api"

  constructor(private httpClient:HttpClient) { }

  getTicketList(): Observable<Ticket[]>{
    return this.httpClient.get<Ticket[]>(`${this.baseUrl}` + '/ticket/list');
  }

  getTicketTypeList(): Observable<TicketType[]>{
    return this.httpClient.get<TicketType[]>(`${this.baseUrl}`+ '/ticketType/list');
  }

  getObjectTypeList(): Observable<ObjectType[]>{
    return this.httpClient.get<ObjectType[]>(`${this.baseUrl}`+ '/objectType/list');
  }

  getObjectPieceList(): Observable<ObjectPiece[]>{
    return this.httpClient.get<ObjectPiece[]>(`${this.baseUrl}`+ '/objectPiece/list');
  }

  getCustList(): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(`${this.baseUrl}`+ '/customer/list');
  }
  
  createTicket(ticket: Ticket): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}` + '/ticket/create',ticket);
  }

  createCustomer(customer: Customer): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}` + '/customer/create',customer);
  }

  createObject(objectType:ObjectType): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}` + '/objectType/create',objectType);
  }

  createPiece(objectPiece:ObjectPiece): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}` + '/objectPiece/create',objectPiece);
  }

  getTicketById(id:number): Observable<Ticket>{
    return this.httpClient.get<Ticket>(`${this.baseUrl}` + '/ticket/list/' + `${id}`);
  }

  getCustomerById(id:number): Observable<Customer>{
    return this.httpClient.get<Customer>(`${this.baseUrl}` + '/customer/list/' + `${id}`);
  }

  getObjectById(id:number): Observable<ObjectType>{
    return this.httpClient.get<ObjectType>(`${this.baseUrl}` + '/objectType/list/' + `${id}`);
  }

  getPieceById(id:number): Observable<ObjectPiece>{
    return this.httpClient.get<ObjectPiece>(`${this.baseUrl}` + '/objectPiece/list/' + `${id}`);
  }

  updateTicket(ticket: Ticket): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}` + '/ticket/update',ticket);
  }

  updateCustomer(customer:Customer): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}` + '/customer/update',customer);
  }

  updateObject(objectType:ObjectType): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}` + '/objectType/update',objectType);
  }

  updatePiece(objectPiece:ObjectPiece): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}` + '/objectPiece/update',objectPiece);
  }


  deleteTicket(ticket:Ticket):Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}` + '/ticket/delete',ticket);

  }
  
  deleteCustomer(customer:Customer):Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}` + '/customer/delete',customer);

  }

  deleteObject(objectType:ObjectType):Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}` + '/objectType/delete',objectType);

  }

  deletePiece(objectPiece:ObjectPiece):Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}` + '/objectPiece/delete',objectPiece);

  }

  getObjectPieceListByObjectTypeId($event: any): Observable<ObjectPiece[]> {
    return this.httpClient.get<ObjectPiece[]>(`${this.baseUrl}` + '/objectPiece/listByObjectTypeId/' + $event);
  }

}
