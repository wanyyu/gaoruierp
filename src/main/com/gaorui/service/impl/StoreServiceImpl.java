package com.gaorui.service.impl;

import com.gaorui.dao.StoreDao;
import com.gaorui.entity.Store;
import com.gaorui.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreDao storeDao;

    @Override
    public List<Store> getAllStroe() {
        return storeDao.getAllStroe();
    }

    @Override
    public Store getStore(String storeid) {
        return storeDao.getStore(storeid);
    }

    @Override
    public boolean updateStore(Store store) {
        return storeDao.updateStore(store);
    }

    @Override
    public boolean insertStore(Store store) {
        return storeDao.insertStore(store);
    }

    @Override
    public boolean deleteStore(String storeid) {
        return storeDao.deleteStore(storeid);
    }

    @Override
    public Store getStoreNum(String merchid) {
        return storeDao.getStoreNum(merchid);
    }
}
