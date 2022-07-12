package com.example.etiyaprojectbe.service;
import com.example.etiyaprojectbe.entity.ObjectType;

import java.util.List;

public interface ObjectTypeService {

    ObjectType createObjectType(ObjectType objectType);

    ObjectType updateObjectType(ObjectType objectType);

    void deleteObjectType(ObjectType objectType);

    List<ObjectType> listObjectType();

    ObjectType  ListObjectTypeId(int id);


}
