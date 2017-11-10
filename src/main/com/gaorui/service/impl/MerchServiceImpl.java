package com.gaorui.service.impl;

import com.gaorui.dao.MerchDao;
import com.gaorui.dao.ProfferDao;
import com.gaorui.entity.Merch;
import com.gaorui.service.MerchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31 0031.
 */
@Service
public class MerchServiceImpl implements MerchService {
    @Autowired
    private MerchDao merchDao;
    @Override
    public List<Merch> getAllMerch() {
        return merchDao.getAllMerch();
    }
}
