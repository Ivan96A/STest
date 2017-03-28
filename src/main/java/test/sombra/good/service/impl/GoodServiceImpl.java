package test.sombra.good.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import test.sombra.good.dao.impl.GoodDAOImpl;
import test.sombra.good.domain.Good;
import test.sombra.good.service.GoodService;

import java.util.List;

/**
 * Created by Ivan on 25.03.2017.
 */
@Service
public class GoodServiceImpl implements GoodService {

    private final GoodDAOImpl goodDAOImpl;

    private static final Logger LOGGER = Logger.getLogger(GoodServiceImpl.class);

    @Autowired
    public GoodServiceImpl(GoodDAOImpl goodDAOImpl) {
        Assert.notNull(goodDAOImpl, "goodDAO must not be null");
        this.goodDAOImpl = goodDAOImpl;
    }

    @Override
    public ResponseEntity<List<Good>> getAll() {
        return new ResponseEntity<>(goodDAOImpl.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Good> add(Good good) {
        if (good == null) {
            LOGGER.warn("cannot be added user because user is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        goodDAOImpl.insert(good);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Good> edit(Good good) {
        if (good == null) {
            LOGGER.warn("cannot be added user because user is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        goodDAOImpl.update(good);
        return new ResponseEntity<>(good, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        if (id <= 0) {
            LOGGER.warn("id cannot be less then 1");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        goodDAOImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Good> getOne(Long id) {
        if (id <= 0) {
            LOGGER.warn("id cannot be less then 1");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(goodDAOImpl.findOneById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Good>> getAllByOrderId(Long id) {
        if (id <= 0) {
            LOGGER.warn("id cannot be less then 1");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(goodDAOImpl.findAllByOrderId(id), HttpStatus.OK);
    }
}
