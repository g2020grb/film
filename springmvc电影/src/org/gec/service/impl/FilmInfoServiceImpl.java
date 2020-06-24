package org.gec.service.impl;

import org.gec.dao.FilminfoDao;
import org.gec.entity.Filminfo;
import org.gec.service.FilmInfoService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FilmInfoServiceImpl implements FilmInfoService {
    @Autowired
    private FilminfoDao filminfoDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Filminfo> findAllInfo(Filminfo filminfo) {

        return filminfoDao.findAllFilmInfo(filminfo);
    }

    @Transactional("required")
    @Override
    public void save(Filminfo filminfo) {
        filminfoDao.save(filminfo);
    }

}
