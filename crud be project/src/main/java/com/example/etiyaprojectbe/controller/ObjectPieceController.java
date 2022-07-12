package com.example.etiyaprojectbe.controller;

import com.example.etiyaprojectbe.entity.Customer;
import com.example.etiyaprojectbe.entity.ObjectPiece;
import com.example.etiyaprojectbe.entity.ObjectType;
import com.example.etiyaprojectbe.service.ObjectPieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Dış dünyadan gelen objectPiece 'e  ait  istekleri karşılayan sınıf.
 */

@RestController
@RequestMapping("/api/objectPiece")
@CrossOrigin(origins = "http://localhost:4200")
public class ObjectPieceController {

    @Autowired
    ObjectPieceService objectPieceService;

    /**
     * ObjectPiece'ın listelenme isteklerini karşılayan motod
     *
     * @return dönen değer ObjectPiece listesi
     */

    @GetMapping("/list")
    public List<ObjectPiece> getAllObjectPiece() {
        return objectPieceService.listObjectPiece();
    }

    /**
     * ObjectPiece'ın oluşturulması isteklerini karşılayan motod
     *
     * @param objectPiece
     * @return dönen değer yaratılan ObjectPiece nesnesi
     */

    @PostMapping("/create")
    public ObjectPiece create(@RequestBody ObjectPiece objectPiece) {

        return objectPieceService.createObjectPiece(objectPiece);
    }

    /**
     * ObjectPiece'in güncellenme isteklerini karşılayan motod
     *
     * @param objectPiece
     * @return dönen değer güncellenen ObjectPiece'in nesnesi
     */

    @PostMapping("/update")
    public ObjectPiece update(@RequestBody ObjectPiece objectPiece) {
        return objectPieceService.updateObjectPiece(objectPiece);
    }

    /**
     * ObjectPiece'in silinmesi isteklerini karşılayan motod
     *
     * @param objectPiece
     */

    @PostMapping("/delete")
    public void delete(@RequestBody ObjectPiece objectPiece) {

        objectPieceService.deleteObjectPiece(objectPiece);
    }

    /**
     * ObjectPiece'in id bilgisine göre  listelenme isteklerini karşılayan motod
     *
     * @param id
     * @return dönen değer id değerine göre listelenen ObjectPiece'in listesi
     */

    @GetMapping(value = "/list/{id}")
    public ObjectPiece getObjectPieceById(@PathVariable int id) {
        return objectPieceService.ListObjectPieceId(id);
    }

    /**
     * ObjectPiece'in, objectType bilgisine göre  listelenme isteklerini karşılayan motod
     *
     * @param id
     * @return dönen değer objectType değerine göre ObjectPiece listesi
     */

    @GetMapping("listByObjectTypeId/{id}")
    public List<ObjectPiece> listByObjectTypeId(@PathVariable int id) {
        return objectPieceService.listByObjectTypeId(id);
    }
}
