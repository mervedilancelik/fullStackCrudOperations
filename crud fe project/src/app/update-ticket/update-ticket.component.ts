import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Customer } from '../customer.interface';
import { ObjectPiece } from '../object-piece.interface';
import { ObjectType } from '../object-type.interface';
import { TicketType } from '../ticket-type.interface';
import { Ticket } from '../ticket.interface';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-update-ticket',
  templateUrl: './update-ticket.component.html',
  styleUrls: ['./update-ticket.component.css']
})
export class UpdateTicketComponent implements OnInit {

  id:any;
  ticket:Ticket ={
    ticketType:{},
    objectType:{},
    objectPiece:{},
    customer:{},
  };
  
  ticketType:TicketType[]=[];
  objectType:ObjectType[]=[];
  objectPiece:ObjectPiece[]=[];
  customer:Customer[]=[];


  constructor(private ticketService:TicketService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];

 
    this.ticketService.getTicketById(this.id).subscribe(data =>{
      this.ticket=data;

    }, error=>console.log(error)); 
   

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

 
   onSubmit(){
    this.ticketService.updateTicket(this.ticket).subscribe( data =>{
      this.goToTicketList();
    }
    , error => console.log(error));
  }

  goToTicketList(){
    this.router.navigate(['/ticket']);
  }


  changeTicketType($event: any) {
    this.ticketService.getObjectPieceListByObjectTypeId($event).subscribe(data => {
      this.objectPiece = data;
    })
  }


  }


