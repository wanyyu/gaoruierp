package com.gaorui.service;

import com.gaorui.entity.Store;

import java.util.List;

/**
 * Created by Administrator on 2017/11/2 0002.
 */
public interface StoreService {

    List<Store> getAllStroe();

    Store getStore(String storeid);

    boolean updateStore(Store store);

    boolean insertStore(Store store);

    boolean deleteStore(String storeid);

    Store getStoreNum(String merchid);
}
