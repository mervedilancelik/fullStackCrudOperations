package com.example.etiyaprojectbe.service;
import com.example.etiyaprojectbe.entity.ObjectPiece;



import java.util.List;


public interface ObjectPieceService {

    ObjectPiece createObjectPiece(ObjectPiece objectPiece);

    ObjectPiece updateObjectPiece(ObjectPiece objectPiece);

    void deleteObjectPiece(ObjectPiece objectPiece);

    List<ObjectPiece> listObjectPiece();

    ObjectPiece ListObjectPieceId(int id);

    List<ObjectPiece> listByObjectTypeId(int id);
}
