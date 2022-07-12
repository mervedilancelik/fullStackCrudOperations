import { ObjectType } from './object-type.interface';

export interface ObjectPiece{
    id?: number;
    name?: string;
    descr?: string;
    objectType?: ObjectType;
}