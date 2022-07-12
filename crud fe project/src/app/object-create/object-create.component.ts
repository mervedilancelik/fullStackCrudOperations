import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ObjectType } from '../object-type.interface';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-object-create',
  templateUrl: './object-create.component.html',
  styleUrls: ['./object-create.component.css']
})
export class ObjectCreateComponent implements OnInit {
  
objectType:ObjectType={};

  constructor(private ticketService:TicketService,private router:Router) { }

  ngOnInit(): void {
  }

  goObjTypeList(){
    this.router.navigate(['/object-list']);
  }


  saveCustomer(){

    this.ticketService.createObject(this.objectType).subscribe(data =>{
      console.log(data);
      this. goObjTypeList();
     
    },
    error => console.log(error));  
  
  }

  onSubmit(){
    console.log(this.objectType);
    this.saveCustomer();  
  }

}
