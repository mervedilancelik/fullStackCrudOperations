import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TicketService } from '../ticket.service';
import { ObjectType } from '../object-type.interface';
import { ObjectPiece } from '../object-piece.interface';


@Component({
  selector: 'app-piece-create',
  templateUrl: './piece-create.component.html',
  styleUrls: ['./piece-create.component.css']
})
export class PieceCreateComponent implements OnInit {
  
  objectPiece:ObjectPiece={
    objectType: {}
  };
  objectType:ObjectType[]=[];
  id: number = 0;

  constructor(private ticketService:TicketService,private router:Router) { }

  ngOnInit(): void {
    this.getObjectType();
  }

  private getObjectType()
  {
    this.ticketService.getObjectTypeList().subscribe(data =>{
         this.objectType=data;
        
      }); 

    }

     
    goPieceList(){
      this.router.navigate(['/piece-list']);
    } 
  savePiece(){
    let objectType: ObjectType = {
      id: this.id
    }
    this.objectPiece.objectType = objectType;
    this.ticketService.createPiece(this.objectPiece).subscribe(data =>{
      console.log(data);

      this.ticketService
      this.goPieceList();

      
     
    },
    error => console.log(error));  
  
     }

      onSubmit(){

        console.log(this.objectPiece);
        this.savePiece();
      }
  
}
