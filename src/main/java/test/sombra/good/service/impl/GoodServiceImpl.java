package test.sombra.good.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import test.sombra.good.dao.GoodDAO;
import test.sombra.good.domain.Good;
import test.sombra.good.service.GoodService;

import java.util.List;

/**
 * Created by Ivan on 25.03.2017.
 */
@Service
public class GoodServiceImpl implements GoodService {

    private final GoodDAO goodDAO;

    @Autowired
    public GoodServiceImpl(GoodDAO goodDAO) {
        Assert.notNull(goodDAO, "goodDAO must not be null");
        this.goodDAO = goodDAO;
    }

    @Override
    public List<Good> getAll() {
        return goodDAO.findAll();
    }

    @Override
    public int add(Good good) {
        return goodDAO.insert(good);
    }

    @Override
    public int edit(Good good) {
        return goodDAO.update(good);
    }

    @Override
    public void delete(Long id) {
        goodDAO.delete(id);
    }

    @Override
    public Good getOne(Long id) {
        return goodDAO.findOneById(id);
    }

}
