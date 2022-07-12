package com.example.etiyaprojectbe.service.impl;

import com.example.etiyaprojectbe.entity.ObjectType;
import com.example.etiyaprojectbe.exception.ResourceNotFoundException;
import com.example.etiyaprojectbe.repository.ObjectTypeRepository;
import com.example.etiyaprojectbe.service.ObjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ObjectType ile ilgili süreçlerin  yönetildiği sınıf
 */

@Service
public class ObjectTypeServiceImpl implements ObjectTypeService {

    @Autowired
    ObjectTypeRepository objectTypeRepository;

    /**
     * ObjectType'ların yaartıldığı sınıf
     *
     * @param objectType
     * @return dönen değer yaratılan ObjectType nesnesi
     */

    @Override
    public ObjectType createObjectType(ObjectType objectType) {
        return objectTypeRepository.save(objectType);
    }

    /**
     * ObjectType'ların güncellendiği metod
     *
     * @param objectType
     * @return dönen değer güncellenen ObjectType nesnesi
     */
    @Override
    public ObjectType updateObjectType(ObjectType objectType) {
        return objectTypeRepository.save(objectType);
    }

    /**
     * ObjectType'ların silindiği metod
     *
     * @param objectType
     */
    @Override
    public void deleteObjectType(ObjectType objectType) {
        objectTypeRepository.delete(objectType);
    }

    /**
     * Tüm ObjectType'ların listelendiği method
     *
     * @return önen değer ObjectType listesi
     */
    @Override
    public List<ObjectType> listObjectType() {
        return objectTypeRepository.findAll();
    }

    /**
     * ObjectType'ları id bilgisine göre  listeleyen motod
     *
     * @param id
     * @return dönen değer id değerine göre listelenen ObjectType nesnesi
     */

    @Override
    public ObjectType ListObjectTypeId(int id) {

        ObjectType objectType;

        Optional<ObjectType> result = objectTypeRepository.findById(id);

        if (result.isPresent()) {
            objectType = result.get();
        } else {

            throw new ResourceNotFoundException("ObjectType bulunamadı" + id);
        }
        return objectType;
    }


}
