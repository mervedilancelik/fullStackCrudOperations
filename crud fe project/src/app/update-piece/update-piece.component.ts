import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ObjectPiece } from '../object-piece.interface';
import { ObjectType } from '../object-type.interface';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-update-piece',
  templateUrl: './update-piece.component.html',
  styleUrls: ['./update-piece.component.css']
})
export class UpdatePieceComponent implements OnInit {
  id:any;
  objectPiece:ObjectPiece={
  objectType: {}
  };
  
  objectType:ObjectType[]=[];

  constructor(private ticketService:TicketService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    let pieceId=this.route.snapshot.params['id'];
    this.ticketService.getPieceById(pieceId).subscribe(data =>{
      this.objectPiece=data;
      this.id=this.objectPiece.objectType?.id;
      
    }, error=>console.log(error)); 
   
    this.getObjectType();

  }

  private getObjectType()
  {
    this.ticketService.getObjectTypeList().subscribe(data =>{
         this.objectType=data;
        
      }); 

    }

    onSubmit(){
      let objectType: ObjectType = {
        id: this.id
      }
      this.objectPiece.objectType = objectType;
    
      this.ticketService.updatePiece(this.objectPiece).subscribe( data =>{
        this.goPieceUpdateList(); 
      }
      , error => console.log(error));
    }
  
    goPieceUpdateList(){
      this.router.navigate(['/piece-list']);
    }

}
