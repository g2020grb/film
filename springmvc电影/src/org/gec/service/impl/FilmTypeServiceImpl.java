package org.gec.service.impl;

import org.gec.dao.FilmTypeDao;
import org.gec.dao.FilminfoDao;
import org.gec.entity.Filmtype;
import org.gec.service.FilmTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
/**
 * bean id="filmTypeService" class="org.gec.service.impl.FilmTypeServiceImpl"
 */
@Transactional
public class FilmTypeServiceImpl implements FilmTypeService {
    @Autowired
    private FilmTypeDao filmTypeDao;

    @Autowired
    private FilminfoDao filminfoDao;

    @Override
    public List<Filmtype> findAllTypes() {
        List<Filmtype> types = filmTypeDao.getListByHQL("from Filmtype");
        System.out.println("types------------------:" + types.size());
        return types;
    }

    @Transactional("required")
    public void delete(Integer filminfoId) {
        //先删除跟子类有关系的所有数据
        //filminfoDao.deleteFilm(filminfoId);

        //再删除主表的数据
        //filmTypeDao.delete(filminfoId);
    }
}
