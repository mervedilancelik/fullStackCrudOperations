import { Component, OnInit } from '@angular/core';
import { TicketService } from '../ticket.service';
import { Customer } from '../customer.interface';
import { Router } from '@angular/router';


@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  customer:Customer={};


  constructor(private ticketService:TicketService,private router:Router) { }

  ngOnInit(): void {
   
  }

  goCustomerList(){
    this.router.navigate(['/customer-list']);
  }


  saveCustomer(){

    this.ticketService.createCustomer(this.customer).subscribe(data =>{
      console.log(data);
      this. goCustomerList();
     
    },
    error => console.log(error));  
  
  }


  onSubmit(){
    console.log(this.customer);
    this.saveCustomer();
    
  }

}
