package com.gaorui.service.impl;

import com.gaorui.dao.ProfferDao;
import com.gaorui.dao.UserDao;
import com.gaorui.entity.Proffer;
import com.gaorui.service.ProfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31 0031.
 */
@Service
public class ProfferServiceImpl implements ProfferService {
    @Autowired
    private ProfferDao profferDao;

    @Override
    public List<Proffer> getAllProffer() {
        return profferDao.getAllProffer();
    }
}
