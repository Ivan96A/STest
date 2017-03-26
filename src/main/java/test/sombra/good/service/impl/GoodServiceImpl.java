package test.sombra.good.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public GoodServiceImpl(GoodDAOImpl goodDAOImpl) {
        Assert.notNull(goodDAOImpl, "goodDAO must not be null");
        this.goodDAOImpl = goodDAOImpl;
    }

    @Override
    public List<Good> getAll() {
        return goodDAOImpl.findAll();
    }

    @Override
    public int add(Good good) {
        return goodDAOImpl.insert(good);
    }

    @Override
    public int edit(Good good) {
        return goodDAOImpl.update(good);
    }

    @Override
    public void delete(Long id) {
        goodDAOImpl.delete(id);
    }

    @Override
    public Good getOne(Long id) {
        return goodDAOImpl.findOneById(id);
    }

    @Override
    public List<Good> getAllByOrderId(Long id) {
        return goodDAOImpl.findAllByOrderId(id);
    }
}
