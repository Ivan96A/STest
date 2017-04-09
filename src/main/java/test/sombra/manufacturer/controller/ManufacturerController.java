package test.sombra.manufacturer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import test.sombra.manufacturer.domain.Manufacturer;
import test.sombra.manufacturer.service.ManufacturerService;

import java.util.List;

/**
 * Created by Ivan on 04.04.2017.
 */
@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        Assert.notNull(manufacturerService, "manufacturerService cannot be null");
        this.manufacturerService = manufacturerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Manufacturer>> getAll() {
        return manufacturerService.getAll();
    }

    @RequestMapping(value = "/{manufacturerName}",
            method = RequestMethod.GET)
    public ResponseEntity<Manufacturer> getOneByName(@PathVariable("manufacturerName") String name) {
        return manufacturerService.getOneByName(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Manufacturer> save(@RequestBody Manufacturer manufacturer) {
        return manufacturerService.add(manufacturer);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST)
    public ResponseEntity<Manufacturer> update(@RequestBody Manufacturer manufacturer) {
        return manufacturerService.update(manufacturer);
    }

    @RequestMapping(value = "/upload",
            method = RequestMethod.POST)
    public ResponseEntity<String> uploadLogo(@RequestParam("file") MultipartFile multipartFile) {
        return manufacturerService.uploadLogo(multipartFile);
    }
}
