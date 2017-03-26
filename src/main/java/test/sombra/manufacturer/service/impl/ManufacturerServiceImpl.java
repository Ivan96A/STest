package test.sombra.manufacturer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import test.sombra.manufacturer.dao.impl.ManufacturerDAOImpl;
import test.sombra.manufacturer.domain.Manufacturer;
import test.sombra.manufacturer.service.ManufacturerService;

import java.util.List;

/**
 * Created by Ivan on 23.03.2017.
 */
@Service
public class ManufacturerServiceImpl implements ManufacturerService{

    private final ManufacturerDAOImpl manufacturerDAOImpl;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerDAOImpl manufacturerDAOImpl) {
        Assert.notNull(manufacturerDAOImpl, "dao must not be null");
        this.manufacturerDAOImpl = manufacturerDAOImpl;
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDAOImpl.findAll();
    }

    @Override
    public int add(Manufacturer manufacturer) {
        return manufacturerDAOImpl.insert(manufacturer);
    }

    @Override
    public int update(Manufacturer manufacturer) {
        return manufacturerDAOImpl.update(manufacturer);
    }

    @Override
    public void delete(Long id) {
        manufacturerDAOImpl.delete(id);
    }

    @Override
    public Manufacturer getOne(Long id) {
        return manufacturerDAOImpl.findOneById(id);
    }
}
