import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../customer.interface';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  id:any;
  customer:Customer={};

  constructor(private ticketService:TicketService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {

    this.id=this.route.snapshot.params['id'];

    this.ticketService.getCustomerById(this.id).subscribe(data =>{
      this.customer=data;

    }, error=>console.log(error)); 
  }

  goCustomerList(){
    this.router.navigate(['/customer-list']);
  }

  onSubmit(){
    this.ticketService.updateCustomer(this.customer).subscribe( data =>{
      this.goCustomerList();
    }
    , error => console.log(error));
  }

 


}
