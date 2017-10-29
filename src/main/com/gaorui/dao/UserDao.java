package com.gaorui.dao;

import com.gaorui.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
public interface UserDao {
    public User getUser(String id);
}
