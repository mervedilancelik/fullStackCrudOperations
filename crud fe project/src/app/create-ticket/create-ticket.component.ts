import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ticket } from '../ticket.interface';
import { ObjectType } from '../object-type.interface';
import { TicketType } from '../ticket-type.interface';
import { TicketService } from '../ticket.service';
import { ObjectPiece } from '../object-piece.interface';
import { Customer } from '../customer.interface';


@Component({
  selector: 'app-create-ticket',
  templateUrl: './create-ticket.component.html',
  styleUrls: ['./create-ticket.component.css']
})
export class CreateTicketComponent implements OnInit {

  ticket:Ticket = {
    ticketType:{},
    objectType:{},
    objectPiece:{},
    customer:{},
  };

  ticketType:TicketType[]=[];
  objectType:ObjectType[]=[];
  objectPiece:ObjectPiece[]=[];
  customer:Customer[]=[];
  
  constructor(private ticketService:TicketService,private router:Router) { }
  

  ngOnInit(): void {
    this.getTicketType();
    this.getObjectType();
    this.getObjectPiece();
    this.getCustomer();
  }

  private getTicketType()
  {
    this.ticketService.getTicketTypeList().subscribe(data =>{
       this.ticketType=data;
    });
  }

  private getObjectType()
  {
    this.ticketService.getObjectTypeList().subscribe(data =>{
         this.objectType=data;     
      }); 
      
  }
  private getObjectPiece()
  { 
    
    this.ticketService.getObjectPieceList().subscribe(data =>{
         this.objectPiece=data;
         
         
      });    
  }

  private getCustomer()
  {
    this.ticketService.getCustList().subscribe(data =>{
      this.customer=data;       
      });  
  }

  goTicketList(){
    this.router.navigate(['/ticket']);
  }
  
  saveTicket(){
    this.ticketService.createTicket(this.ticket).subscribe(data =>{
      console.log(data);
      this.goTicketList();
    },
    error => console.log(error));  
  }

  onSubmit(){
    console.log(this.ticket);
    this.saveTicket();
  }

  changeTicketType($event: any) {
    this.ticketService.getObjectPieceListByObjectTypeId($event).subscribe(data => {
      this.objectPiece = data;
    })
  }

}