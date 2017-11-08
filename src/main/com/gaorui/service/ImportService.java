package com.gaorui.service;

import com.gaorui.entity.Import;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26 0026.
 */
public interface ImportService {
   List<Import> getAllImport(Import im);

   Import getImport(String importid);

   boolean insertImport(Import newImport);

   boolean updateImport(Import upImport);

   boolean deleteImport(String importid);
}
