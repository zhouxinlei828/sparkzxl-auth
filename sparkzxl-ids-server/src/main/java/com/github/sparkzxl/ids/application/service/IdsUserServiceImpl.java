package com.github.sparkzxl.ids.application.service;

import com.fujieid.jap.ids.model.UserInfo;
import com.fujieid.jap.ids.service.IdsUserService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * description:
 *
 * @author zhoux
 * @date 2021-08-22 19:20:51
 */
@Service
public class IdsUserServiceImpl implements IdsUserService {

    public List<UserInfo> userInfoList = new LinkedList<>();

    public IdsUserServiceImpl() {
        for (int i = 0; i < 10; i++) {
            UserInfo userInfo = new UserInfo();
            userInfoList.add(userInfo
                    .setId(i + "")
                    .setUsername("test"));
        }
    }

    /**
     * Login with account and password
     *
     * @param username account number
     * @param password password
     * @return UserInfo
     */
    @Override
    public UserInfo loginByUsernameAndPassword(String username, String password, String clientId) {
        return userInfoList.stream().filter(userInfo -> userInfo.getUsername().equals(username)).findFirst().orElse(null);
    }

    /**
     * Get user info by userid.
     *
     * @param userId userId of the business system
     * @return UserInfo
     */
    @Override
    public UserInfo getById(String userId) {
        return userInfoList.stream().filter(userInfo -> userInfo.getId().equals(userId)).findFirst().orElse(null);
    }

    /**
     * Get user info by username.
     *
     * @param username username of the business system
     * @return UserInfo
     */
    @Override
    public UserInfo getByName(String username, String clientId) {
        return userInfoList.stream().filter(userInfo -> userInfo.getUsername().equals(username)).findFirst().orElse(null);
    }
}
