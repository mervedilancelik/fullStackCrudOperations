import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer.interface';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

 customer:Customer[]=[];

  constructor(private ticketService:TicketService,private router:Router) { }

  ngOnInit(): void {

    this.getCust();
  }

   private getCust()
  {
     this.ticketService.getCustList().subscribe(data =>{
      this.customer=data;

   });  
  }

  updateCustomer(customer:Customer){
      
      this.router.navigate(['update-customer/',customer.id])
      
  }


    deleteCustomer(customer:Customer){

    this.ticketService.deleteCustomer(customer).subscribe(data =>{
      console.log(data);
      this.getCust();
  
   }); 

  }
}

