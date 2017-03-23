package test.sombra.type.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import test.sombra.type.dao.TypeDAO;
import test.sombra.type.domain.Type;
import test.sombra.type.service.TypeService;

import java.util.List;

/**
 * Created by Ivan on 23.03.2017.
 */
@Service
public class TypeServiceImpl implements TypeService {

    private final TypeDAO typeDAO;

    @Autowired
    public TypeServiceImpl(TypeDAO typeDAO) {
        Assert.notNull(typeDAO, "dao must not be null");
        this.typeDAO = typeDAO;
    }

    @Override
    public List<Type> getAll() {
        return typeDAO.findAll();
    }

    @Override
    public int add(Type type) {
        return typeDAO.insert(type);
    }

    @Override
    public int update(Type type) {
        return typeDAO.update(type);
    }

    @Override
    public void delete(Long id) {
        typeDAO.delete(id);
    }

    @Override
    public Type getOne(Long id) {
        return typeDAO.findOneById(id);
    }
}
