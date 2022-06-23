package com.github.sparkzxl.system.admin.domain.convert;

import com.github.sparkzxl.system.admin.infrastructure.entity.User;
import com.github.sparkzxl.system.admin.api.model.dto.UserDTO;
import com.github.sparkzxl.system.admin.api.model.vo.UserVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
 * <p>
 * 用户信息 转换类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    /**
     * userDTO转换为User
     *
     * @param userDTO 用户信息DTO对象
     * @return User
     */
    User convertUser(UserDTO userDTO);

    /**
     * User转换为UserVO
     *
     * @param user 用户信息DTO对象
     * @return UserVO
     */
    UserVO convertUserVO(User user);

    /**
     * user列表转换为UserVO列表
     *
     * @param userList 用户信息列表
     * @return List<UserVO>
     */
    List<UserVO> convertUserVOList(List<User> userList);

    /**
     * 用户信息分页对象转换为UserVO分页对象
     *
     * @param userPage 用户信息分页对象
     * @return Page<UserVO>
     */
    Page<UserVO> convertUserPageVO(Page<User> userPage);
}
