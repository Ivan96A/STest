package test.sombra.manufacturer.service;

import test.sombra.manufacturer.domain.Manufacturer;

import java.util.List;

/**
 * Created by Ivan on 23.03.2017.
 */
public interface ManufacturerService {

    List<Manufacturer> getAll();

    int add(Manufacturer manufacturer);

    int update(Manufacturer manufacturer);

    void delete(Long id);

    Manufacturer getOne(Long id);
}
