package test.sombra.type.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.sombra.type.domain.Type;
import test.sombra.type.service.TypeService;

import java.util.List;

/**
 * Created by Ivan on 29.03.2017.
 */
@RestController
@RequestMapping(value = "/type")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Type>> getAll() {
        return typeService.getAll();
    }

    @RequestMapping(value = "/{typeName}",
            method = RequestMethod.GET)
    public ResponseEntity<Type> getTypeByName(@PathVariable("typeName") String name) {
        return typeService.getOneByName(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Type> save(@RequestBody Type type) {
        return typeService.add(type);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST)
    public ResponseEntity<Type> update(@RequestBody Type type) {
        return typeService.update(type);
    }

    @RequestMapping( value = "/id/{typeId}",
            method = RequestMethod.GET)
    public ResponseEntity<Type> getOne(@PathVariable("typeId") Long id) {
        return typeService.getOne(id);
    }
}
