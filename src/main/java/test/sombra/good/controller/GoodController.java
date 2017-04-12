package test.sombra.good.controller;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import test.sombra.good.domain.Good;
import test.sombra.good.domain.GoodDTO;
import test.sombra.good.service.GoodService;

import javax.xml.ws.Response;
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
    public ResponseEntity<List<Good>> getAll(String goodName, String typeName) {
        if (!Strings.isNullOrEmpty(goodName) && !Strings.isNullOrEmpty(typeName)) {
            return goodService.getAllByNameAndTypeId(goodName, typeName);
        } else if (Strings.isNullOrEmpty(goodName) && !Strings.isNullOrEmpty(typeName)) {
            return goodService.getAllByTypeName(typeName);
        } else if (!Strings.isNullOrEmpty(goodName) && Strings.isNullOrEmpty(typeName)) {
            return goodService.getAllByName(goodName);
        } else {
            return goodService.getAll();
        }

    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Good> getOne(@PathVariable("id") Long id) {
        return goodService.getOne(id);
    }

    @RequestMapping(
            value = "/public/{username}",
            method = RequestMethod.GET)
    public ResponseEntity<GoodDTO> getOrderByUsername(@PathVariable("username") String username) {
        return goodService.getGoodDTOByUsername(username);
    }

    @RequestMapping(value = "/upload",
            method = RequestMethod.POST)
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile multipartFile) {
        return goodService.uploadImage(multipartFile);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Good> save(@RequestBody Good good, String typeName, String manufacturerName) {
        return goodService.add(good, typeName, manufacturerName);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST)
    public ResponseEntity<Good> update(@RequestBody Good good, String typeName, String manufacturerName) {
        return goodService.edit(good, typeName, manufacturerName);
    }

}
