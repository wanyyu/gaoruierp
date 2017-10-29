package com.gaorui.service;

import com.gaorui.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
public interface UserService {
    User getUser(String id);
}
