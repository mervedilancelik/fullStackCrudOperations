import { Time } from '@angular/common';
import { Timestamp } from 'rxjs';
import { Customer } from './customer.interface';
import { ObjectPiece } from './object-piece.interface';
import { ObjectType } from './object-type.interface';
import { TicketType } from './ticket-type.interface';

export interface Ticket {
    id?: number;
    ticketType: TicketType;
    objectType: ObjectType;
    objectPiece: ObjectPiece;
    customer: Customer;
    descr?: string;
    maintenanceDate?:Date;

}




