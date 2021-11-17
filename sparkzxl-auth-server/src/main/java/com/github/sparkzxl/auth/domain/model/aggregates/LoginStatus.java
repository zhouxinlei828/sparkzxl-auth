package com.github.sparkzxl.auth.domain.model.aggregates;

import com.github.sparkzxl.core.util.UserAgentUtils;
import com.github.sparkzxl.entity.core.UserAgentEntity;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * description: 登录态
 *
 * @author zhouxinlei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
public class LoginStatus<T> implements Serializable {

    private static final long serialVersionUID = -3124612657759050173L;

    /***
     * 用户id
     */
    private T id;
    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 登录类型
     */
    private Type type;
    /**
     * 登录描述
     */
    private String description;

    private UserAgentEntity userAgentEntity;

    public static <T> LoginStatus success(T id, String account, String name) {
        return LoginStatus.builder()
                .id(id)
                .account(account)
                .name(name)
                .type(Type.SUCCESS)
                .description("登录成功")
                .build().setInfo();
    }


    public static <T> LoginStatus fail(T id, String account, String name, String description) {
        return LoginStatus.builder()
                .id(id)
                .account(account)
                .name(name)
                .type(Type.FAIL)
                .description(description)
                .build().setInfo();
    }

    public static <T> LoginStatus pwdError(T id, String account, String name, String description) {
        return LoginStatus.builder()
                .id(id)
                .account(account)
                .name(name)
                .type(Type.PWD_ERROR)
                .description(description)
                .build().setInfo();
    }

    private LoginStatus setInfo() {
        this.userAgentEntity = UserAgentUtils.getUserAgentEntity();
        return this;
    }

    @Getter
    public enum Type {
        /**
         * 登录态
         */
        SUCCESS,
        PWD_ERROR,
        FAIL
    }

}
