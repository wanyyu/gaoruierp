package com.gaorui.service;

import com.gaorui.entity.Sale;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6 0006.
 */
public interface SaleService {
    List<Sale> getAllSale();

    Sale getSale(String saleid);

    boolean insertSale(Sale sale);

    boolean updateSale(Sale sale);

    boolean deleteSale(String saleid);
}
