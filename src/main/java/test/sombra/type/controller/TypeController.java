package test.sombra.type.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
}
