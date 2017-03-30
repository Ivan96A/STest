package test.sombra.good.service.impl;

import com.google.common.base.Strings;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import test.sombra.good.dao.GoodDAO;
import test.sombra.good.dao.impl.GoodDAOImpl;
import test.sombra.good.domain.Good;
import test.sombra.good.service.GoodService;
import test.sombra.type.dao.TypeDAO;
import test.sombra.type.dao.impl.TypeDAOImpl;

import java.util.List;

/**
 * Created by Ivan on 25.03.2017.
 */
@Service
public class GoodServiceImpl implements GoodService {

    private final GoodDAO goodDAO;

    private final TypeDAO typeDAO;

    private static final Logger LOGGER = Logger.getLogger(GoodServiceImpl.class);

    @Autowired
    public GoodServiceImpl(GoodDAO goodDAO, TypeDAO typeDAO) {
        Assert.notNull(goodDAO, "goodDAO must not be null");
        this.goodDAO = goodDAO;
        this.typeDAO = typeDAO;
    }

    @Override
    public ResponseEntity<List<Good>> getAll() {
        return new ResponseEntity<>(goodDAO.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Good> add(Good good) {
        if (good == null) {
            LOGGER.warn("cannot be added user because user is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        goodDAO.insert(good);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Good> edit(Good good) {
        if (good == null) {
            LOGGER.warn("cannot be added user because user is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        goodDAO.update(good);
        return new ResponseEntity<>(good, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        if (id <= 0) {
            LOGGER.warn("id cannot be less then 1");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        goodDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Good> getOne(Long id) {
        if (id <= 0) {
            LOGGER.warn("id cannot be less then 1");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(goodDAO.findOneById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Good>> getAllByOrderId(Long id) {
        if (id <= 0) {
            LOGGER.warn("id cannot be less then 1");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(goodDAO.findAllByOrderId(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Good>> getAllByName(String name) {
        if (Strings.isNullOrEmpty(name)) {
            LOGGER.warn("cannot be finding goods because name is null or empty");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(goodDAO.findAllByName(name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Good>> getAllByTypeId(String typeName) {
        if (Strings.isNullOrEmpty(typeName)) {
            LOGGER.warn("typeName is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Long id = typeDAO.findOneByName(typeName).getId();
        return new ResponseEntity<>(goodDAO.findAllByTypeId(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Good>> getAllByNameAndTypeId(String name, String typeName) {
        if (Strings.isNullOrEmpty(name) || Strings.isNullOrEmpty(typeName)) {
            LOGGER.warn("name is null or typeName is null");
        }
        Long id = typeDAO.findOneByName(typeName).getId();
        return new ResponseEntity<>(goodDAO.findAllByNameAndTypeId(name, id), HttpStatus.OK);
    }
}
