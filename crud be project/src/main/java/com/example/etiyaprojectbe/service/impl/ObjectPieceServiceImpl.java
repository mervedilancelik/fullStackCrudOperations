package com.example.etiyaprojectbe.service.impl;

import com.example.etiyaprojectbe.entity.ObjectPiece;
import com.example.etiyaprojectbe.exception.ResourceNotFoundException;
import com.example.etiyaprojectbe.repository.ObjectPieceRepository;
import com.example.etiyaprojectbe.service.ObjectPieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ObjectPiece ile ilgili süreçlerin  yönetildiği sınıf
 */


@Service
public class ObjectPieceServiceImpl implements ObjectPieceService {


    @Autowired
    ObjectPieceRepository objectPieceRepository;

    /**
     * ObjectPiece'lerin yartıldığı sınıf
     *
     * @param objectPiece
     * @return dönen değer yaratılan ObjectPiece nesnesi
     */

    @Override
    public ObjectPiece createObjectPiece(ObjectPiece objectPiece) {
        return objectPieceRepository.save(objectPiece);
    }

    /**
     * ObjectPiece'lerin güncellendiği metod
     *
     * @param objectPiece
     * @return dönen değer güncellenen ObjectPiece nesnesi
     */

    @Override
    public ObjectPiece updateObjectPiece(ObjectPiece objectPiece) {
        return objectPieceRepository.save(objectPiece);
    }

    /**
     * ObjectPiece'lerin silindiği metod
     *
     * @param objectPiece
     */
    @Override
    public void deleteObjectPiece(ObjectPiece objectPiece) {
        objectPieceRepository.delete(objectPiece);
    }

    /**
     * Tüm ObjectPiece'lerin listelendiği method
     *
     * @return dönen değer ObjectPiece listesi
     */
    @Override
    public List<ObjectPiece> listObjectPiece() {
        return objectPieceRepository.findAll();
    }

    /**
     * ObjectPiece'leri id bilgisine göre  listeleyen motod
     *
     * @param id
     * @return dönen değer id değerine göre listelenen ObjectPiece'in listesi
     */

    @Override
    public ObjectPiece ListObjectPieceId(int id) {

        ObjectPiece objectPiece;
        Optional<ObjectPiece> result = objectPieceRepository.findById(id);

        if (result.isPresent()) {
            objectPiece = result.get();
        } else {

            throw new ResourceNotFoundException("ObjectPiece bulunamadı " + id);
        }

        return objectPiece;

    }

    /**
     * ObjectPiece'i, objectType bilgisine göre  listeleyen motod
     *
     * @param id
     * @return dönen değer objectType değerine göre ObjectPiece listesi
     */

    @Override
    public List<ObjectPiece> listByObjectTypeId(int id) {
        return objectPieceRepository.findAllByObjectType_Id(id);
    }
}
