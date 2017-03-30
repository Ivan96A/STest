package test.sombra.manufacturer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import test.sombra.manufacturer.dao.ManufacturerDAO;
import test.sombra.manufacturer.domain.Manufacturer;
import test.sombra.manufacturer.service.ManufacturerService;

import java.util.List;

/**
 * Created by Ivan on 23.03.2017.
 */
@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerDAO manufacturerDAO;

    private static final Logger LOG = LoggerFactory.getLogger(ManufacturerServiceImpl.class);

    @Autowired
    public ManufacturerServiceImpl(ManufacturerDAO manufacturerDAO) {
        Assert.notNull(manufacturerDAO, "dao must not be null");
        this.manufacturerDAO = manufacturerDAO;
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
        if(manufacturer == null) {
            LOG.warn("cannot be updated a manufacturer because manufacturer is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
}
