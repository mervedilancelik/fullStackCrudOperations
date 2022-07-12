import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ticket } from '../ticket.interface';
import { TicketService } from '../ticket.service';


@Component({
  selector: 'app-ticket-list',
  templateUrl: './ticket-list.component.html',
  styleUrls: ['./ticket-list.component.css']
})
export class TicketListComponent implements OnInit {

  ticket: Ticket[] = [];

  constructor(private ticketService:TicketService,private router:Router) { }

  ngOnInit(): void {
 
    this.getTicket();
 
  }
    private getTicket()
    {
      this.ticketService.getTicketList().subscribe(data =>{
         this.ticket=data;

      });  
}


updateTicket(ticket:Ticket){
  if (ticket) {
    this.router.navigate(['update-ticket/', ticket.id])
  }
}

deleteTicket(ticket: Ticket){

  this.ticketService.deleteTicket(ticket).subscribe(data =>{
    console.log(data);
    this.getTicket();

 });  

}

}
