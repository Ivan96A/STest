package test.sombra.manufacturer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ManufacturerServiceImpl implements ManufacturerService{

    private final ManufacturerDAO manufacturerDAO;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerDAO manufacturerDAO) {
        Assert.notNull(manufacturerDAO, "dao must not be null");
        this.manufacturerDAO = manufacturerDAO;
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDAO.findAll();
    }

    @Override
    public int add(Manufacturer manufacturer) {
        return manufacturerDAO.insert(manufacturer);
    }

    @Override
    public int update(Manufacturer manufacturer) {
        return manufacturerDAO.update(manufacturer);
    }

    @Override
    public void delete(Long id) {
        manufacturerDAO.delete(id);
    }

    @Override
    public Manufacturer getOne(Long id) {
        return manufacturerDAO.findOneById(id);
    }
}
