import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ObjectType } from '../object-type.interface';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-update-object',
  templateUrl: './update-object.component.html',
  styleUrls: ['./update-object.component.css']
})
export class UpdateObjectComponent implements OnInit {

  id:any;
  objectType:ObjectType={};

  constructor(private ticketService:TicketService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {

    this.id=this.route.snapshot.params['id'];

    this.ticketService.getObjectById(this.id).subscribe(data =>{
      this.objectType=data;

    }, error=>console.log(error)); 
  }

  goobjectTypeList(){
    this.router.navigate(['/object-list']);
  }

  onSubmit(){
    this.ticketService.updateObject(this.objectType).subscribe( data =>{
      this.goobjectTypeList();
    }
    , error => console.log(error));
  }

 


}