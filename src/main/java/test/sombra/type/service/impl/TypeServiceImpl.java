package test.sombra.type.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private static final Logger LOG = LoggerFactory.getLogger(TypeServiceImpl.class);

    @Autowired
    public TypeServiceImpl(TypeDAOImpl typeDAOImpl) {
        Assert.notNull(typeDAOImpl, "dao must not be null");
        this.typeDAOImpl = typeDAOImpl;
    }

    @Override
    public ResponseEntity<List<Type>> getAll() {
        return new ResponseEntity<>(typeDAOImpl.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Type> add(Type type) {
        if (type == null) {
            LOG.warn("type with name='{}' cannot be added because type is null", type.getName());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        typeDAOImpl.insert(type);
        return new ResponseEntity<>(type, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Type> update(Type type) {
        if (type == type) {
            LOG.warn("type with name='{}' cannot be updated because type is null", type.getName());
        }
        typeDAOImpl.update(type);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        if (id <= 0) {
            LOG.warn("id cannot be less then 1");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        typeDAOImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Type> getOne(Long id) {
        if (id <= 0) {
            LOG.warn("id cannot be less then 1");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(typeDAOImpl.findOneById(id), HttpStatus.OK);
    }
}
