package test.sombra.good.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.sombra.good.domain.Good;
import test.sombra.good.service.GoodService;

import java.util.List;

/**
 * Created by Ivan on 28.03.2017.
 */

@RestController
@RequestMapping(value = "/good")
public class GoodController {

    private final GoodService goodService;

    @Autowired
    public GoodController(GoodService goodService) {
        Assert.notNull(goodService, "goodService must not be null");
        this.goodService = goodService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Good>> getAll(String goodName, String typeId) {
        if(goodName != null && typeId != null) {
            return goodService.getAllByNameAndTypeId(goodName, typeId);
        } else if(goodName == null && typeId != null) {
            return goodService.getAllByTypeId(typeId);
        }else if(goodName != null && typeId == null) {
            return goodService.getAllByName(goodName);
        }else {
            return goodService.getAll();
        }

    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Good> getOne(@PathVariable("id")  Long id) {
        return goodService.getOne(id);
    }

}