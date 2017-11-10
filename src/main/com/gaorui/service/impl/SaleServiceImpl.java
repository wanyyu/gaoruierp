package com.gaorui.service.impl;

import com.gaorui.dao.SaleDao;
import com.gaorui.entity.Sale;
import com.gaorui.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6 0006.
 */
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleDao saleDao;

    @Override
    public List<Sale> getAllSale() {
        return saleDao.getAllSale();
    }

    @Override
    public Sale getSale(String saleid) {
        return saleDao.getSale(saleid);
    }

    @Override
    public boolean insertSale(Sale sale) {
        return saleDao.insertSale(sale);
    }

    @Override
    public boolean updateSale(Sale sale) {
        return saleDao.updateSale(sale);
    }

    @Override
    public boolean deleteSale(String saleid) {
        return saleDao.deleteSale(saleid);
    }
}
