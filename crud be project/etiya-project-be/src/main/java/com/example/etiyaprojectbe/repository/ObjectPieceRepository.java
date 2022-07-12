package com.example.etiyaprojectbe.repository;

import com.example.etiyaprojectbe.entity.ObjectPiece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectPieceRepository  extends JpaRepository<ObjectPiece,Integer> {

    List<ObjectPiece> findAllByObjectType_Id(int id);

}
