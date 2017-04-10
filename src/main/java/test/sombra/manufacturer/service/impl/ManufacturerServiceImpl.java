package test.sombra.manufacturer.service.impl;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;
import test.sombra.image.ImageService;
import test.sombra.manufacturer.dao.ManufacturerDAO;
import test.sombra.manufacturer.domain.Manufacturer;
import test.sombra.manufacturer.service.ManufacturerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Ivan on 23.03.2017.
 */
@Service
public class ManufacturerServiceImpl implements ManufacturerService {


    private final ManufacturerDAO manufacturerDAO;

    private final ImageService imageService;

    private static final Logger LOG = LoggerFactory.getLogger(ManufacturerServiceImpl.class);

    @Autowired
    public ManufacturerServiceImpl(ManufacturerDAO manufacturerDAO, ImageService imageService) {
        Assert.notNull(manufacturerDAO, "dao must not be null");
        this.manufacturerDAO = manufacturerDAO;
        this.imageService = imageService;
    }

    @Override
    public ResponseEntity<List<Manufacturer>> getAll() {
        return new ResponseEntity<>(manufacturerDAO.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Manufacturer> add(Manufacturer manufacturer) {
        if (manufacturer == null) {
            LOG.warn("cannot be added a manufacturer because manufacturer is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        manufacturerDAO.insert(manufacturer);
        return new ResponseEntity<>(manufacturer, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Manufacturer> update(Manufacturer manufacturer) {
        if (manufacturer == null) {
            LOG.warn("cannot be updated a manufacturer because manufacturer is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(Strings.isNullOrEmpty(manufacturer.getLogo())) {
            manufacturer.setLogo(manufacturerDAO.findOneByName(manufacturer.getName()).getLogo());
        }
        manufacturerDAO.update(manufacturer);
        return new ResponseEntity<>(manufacturer, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        if (id <= 0) {
            LOG.warn("id cannot be less then 1");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        manufacturerDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Manufacturer> getOne(Long id) {
        if (id <= 0) {
            LOG.warn("id cannot be less then 1");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(manufacturerDAO.findOneById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Manufacturer> getOneByName(String name) {
        if (Strings.isNullOrEmpty(name)) {
            LOG.warn("name is null or empty");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(manufacturerDAO.findOneByName(name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> uploadLogo(MultipartFile multipartFile) {
        if (multipartFile == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        boolean result = imageService.uploadImage(multipartFile);
        if (result) return new ResponseEntity<>(multipartFile.getOriginalFilename(), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
