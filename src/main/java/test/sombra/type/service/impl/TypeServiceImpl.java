package test.sombra.type.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import test.sombra.type.dao.impl.TypeDAOImpl;
import test.sombra.type.domain.Type;
import test.sombra.type.service.TypeService;

import java.util.List;

/**
 * Created by Ivan on 23.03.2017.
 */
@Service
public class TypeServiceImpl implements TypeService {

    private final TypeDAOImpl typeDAOImpl;

    @Autowired
    public TypeServiceImpl(TypeDAOImpl typeDAOImpl) {
        Assert.notNull(typeDAOImpl, "dao must not be null");
        this.typeDAOImpl = typeDAOImpl;
    }

    @Override
    public List<Type> getAll() {
        return typeDAOImpl.findAll();
    }

    @Override
    public int add(Type type) {
        return typeDAOImpl.insert(type);
    }

    @Override
    public int update(Type type) {
        return typeDAOImpl.update(type);
    }

    @Override
    public void delete(Long id) {
        typeDAOImpl.delete(id);
    }

    @Override
    public Type getOne(Long id) {
        return typeDAOImpl.findOneById(id);
    }
}
