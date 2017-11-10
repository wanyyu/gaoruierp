package com.gaorui.dao;

import com.gaorui.entity.Sale;

import java.util.List;

/**
 * Created by Administrator on 2017/11/3 0003.
 */
public interface SaleDao {
    List<Sale> getAllSale();

    Sale getSale(String saleid);

    boolean insertSale(Sale sale);

    boolean updateSale(Sale sale);

    boolean deleteSale(String saleid);
}
