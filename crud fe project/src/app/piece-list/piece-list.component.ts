import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ObjectPiece } from '../object-piece.interface';
import { ObjectType } from '../object-type.interface';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-piece-list',
  templateUrl: './piece-list.component.html',
  styleUrls: ['./piece-list.component.css']
})
export class PieceListComponent implements OnInit {

    objectPiece:ObjectPiece[]=[];
    objectType:ObjectType[]=[]

  constructor(private ticketService:TicketService,private router:Router) { }

 
  ngOnInit(): void {
 
    this.getPiece();
 
  }
    private getPiece()
    {
      this.ticketService.getObjectPieceList().subscribe(data =>{
         this.objectPiece=data;

      });  
}


updateObjectPiece(objectPiece:ObjectPiece){
  this.router.navigate(['update-piece/',objectPiece.id])
}



deleteObjectPiece(objectPiece:ObjectPiece){

  this.ticketService.deletePiece(objectPiece).subscribe(data =>{
    console.log(data);
    this.getPiece();

 }); 


}

}
