package com.github.sparkzxl.ids.application.service;

import com.fujieid.jap.ids.model.UserInfo;
import com.fujieid.jap.ids.service.IdsUserService;
import com.github.sparkzxl.auth.api.dto.AuthUserBasicVO;
import com.github.sparkzxl.ids.infrastructure.client.UserInfoClient;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserInfoClient userInfoClient;

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
        AuthUserBasicVO authUserBasicInfo = userInfoClient.getUserByUserId(Long.valueOf(userId));
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        userInfo.setUsername(authUserBasicInfo.getAccount());
        userInfo.setName(authUserBasicInfo.getName());
        userInfo.setGender(authUserBasicInfo.getSex());
        userInfo.setPhone_number(authUserBasicInfo.getMobile());
        return userInfo;
    }

    /**
     * Get user info by username.
     *
     * @param username username of the business system
     * @return UserInfo
     */
    @Override
    public UserInfo getByName(String username, String clientId) {
        AuthUserBasicVO authUserBasicInfo = userInfoClient.getUserByUsername(username);
        UserInfo userInfo = new UserInfo();
        userInfo.setId(String.valueOf(authUserBasicInfo.getId()));
        userInfo.setUsername(authUserBasicInfo.getAccount());
        userInfo.setName(authUserBasicInfo.getName());
        userInfo.setGender(authUserBasicInfo.getSex());
        userInfo.setPhone_number(authUserBasicInfo.getMobile());
        return userInfo;
    }
}
