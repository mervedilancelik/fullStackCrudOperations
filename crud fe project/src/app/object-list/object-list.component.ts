import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ObjectType } from '../object-type.interface';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-object-list',
  templateUrl: './object-list.component.html',
  styleUrls: ['./object-list.component.css']
})
export class ObjectListComponent implements OnInit {

  objectType:ObjectType[]=[];

  constructor(private ticketServise:TicketService,private router:Router) { }

  ngOnInit(): void {
    this.getObjectTypeList();
  }


 private getObjectTypeList()
  {
   this.ticketServise.getObjectTypeList().subscribe(data =>{
    this.objectType=data;
  });  
}

updateObjectType( objectType:ObjectType){
  this.router.navigate(['update-object/',objectType.id])
}



deleteObjectType(objectType:ObjectType){

  this.ticketServise.deleteObject(objectType).subscribe(data =>{
    console.log(data);
    this.getObjectTypeList();

 }); 

}
 



}
