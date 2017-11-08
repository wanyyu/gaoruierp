package com.gaorui.service.impl;

import com.gaorui.dao.ImportDao;
import com.gaorui.entity.Import;
import com.gaorui.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportServiceImpl implements ImportService {

    @Autowired
    private ImportDao importDao;

    @Override
    public List<Import> getAllImport(Import im) {
        return importDao.getAllImport(im);
    }

    @Override
    public Import getImport(String importid) {
        return importDao.getImport(importid);
    }

    @Override
    public boolean insertImport(Import newImport) {
        return importDao.insertImport(newImport);
    }

    @Override
    public boolean updateImport(Import upImport) {
        return importDao.updateImport(upImport);
    }

    @Override
    public boolean deleteImport(String importid) {
        return importDao.deleteImport(importid);
    }


}
