package org.gec.dao;

import org.gec.entity.Filminfo;

import java.util.List;

public interface FilminfoDao extends BaseDao<Filminfo>{
    List<Filminfo> findAllFilmInfo(Filminfo filminfo);
}
