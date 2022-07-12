package com.example.etiyaprojectbe.controller;

import com.example.etiyaprojectbe.entity.ObjectType;
import com.example.etiyaprojectbe.service.ObjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Dış dünyadan gelen ObjectType  isteklerini karşılayan sınıf.
 */

@RestController
@RequestMapping("/api/objectType")
@CrossOrigin(origins = "http://localhost:4200")
public class ObjectTypeController {

    @Autowired
    ObjectTypeService objectTypeService;

    /**
     * ObjectType listeleme isteklerini karşılayan motod
     *
     * @return dönen değer ObjectType listesi
     */

    @GetMapping("/list")
    public List<ObjectType> getAllObjectType() {
        return objectTypeService.listObjectType();
    }

    /**
     * ObjectType  oluşturma isteklerini karşılayan motod
     *
     * @param objectType
     * @return dönen değer yaratılan ObjectType nesnesi
     */

    @PostMapping("/create")
    public ObjectType create(@RequestBody ObjectType objectType) {

        return objectTypeService.createObjectType(objectType);
    }

    /**
     * ObjectType güncelleme isteklerini karşılayan motod
     *
     * @param objectType
     * @return önen değer güncellenen ObjectType nesnesi
     */

    @PostMapping("/update")
    public ObjectType update(@RequestBody ObjectType objectType) {
        return objectTypeService.updateObjectType(objectType);
    }

    /**
     * ObjectType  silme isteklerini karşılayan motod
     *
     * @param objectType
     */

    @PostMapping("/delete")
    public void delete(@RequestBody ObjectType objectType) {
        objectTypeService.deleteObjectType(objectType);
    }

    /**
     * ObjectType id bilgisine göre  listeleme isteklerini karşılayan motod
     *
     * @param id
     * @return dönen değer id değerine göre listelenen ObjectType nesnesi
     */

    @GetMapping(value = "/list/{id}")
    public ObjectType getObjectTypeById(@PathVariable int id) {
        return objectTypeService.ListObjectTypeId(id);
    }

}
