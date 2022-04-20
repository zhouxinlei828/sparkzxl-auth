package com.github.sparkzxl.system.admin.domain.service;

import com.github.sparkzxl.system.admin.infrastructure.entity.User;
import com.github.sparkzxl.system.admin.domain.repository.IUserRepository;
import com.github.sparkzxl.system.admin.application.service.IUserService;
import com.github.sparkzxl.system.admin.domain.convert.UserConvert;
import com.github.sparkzxl.system.admin.api.model.vo.UserVO;
import com.github.sparkzxl.system.admin.api.model.dto.UserDTO;
import org.apache.commons.lang3.ObjectUtils;
import com.github.sparkzxl.core.support.ExceptionAssert;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2022-04-20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;

    /**
    * 分页条件查询
    * @author zhouxinlei
    * @since 2022-04-20
    * @param userDTO: 用户信息DTO对象
    * @param page: 分页入参
    * @return Page<UserVO>
    */
    @Override
    public Page<UserVO> page(Page<User> page, UserDTO userDTO) {
        queryPageCheck(userDTO);
        User user = convertPageQueryUser(userDTO);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        buildPageQueryWrapper(user, queryWrapper);
        Page<User> userPage = iUserRepository.page(page, queryWrapper);
        return assignment(convertUserPageVO(userPage));
    }

    /**
     * 分页条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userDTO: 用户信息DTO对象
     */
    private void queryPageCheck(UserDTO userDTO) {

    }

    /**
     * 分页查询模型转换
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userDTO: 用户信息DTO对象
     * @return User
     */
     private User convertPageQueryUser(UserDTO userDTO){
        return UserConvert.INSTANCE.convertUser(userDTO);
    }

    /**
     * 构建分页查询条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param user: 用户信息
     * @param queryWrapper: 查询Wrapper
     */
    private void buildPageQueryWrapper(User user, QueryWrapper<User> queryWrapper) {

    }

    /**
     * 分页,增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userVOPage: 分页显示VO
     * @return Page<User>
     */
    private Page<UserVO> assignment(Page<UserVO> userVOPage) {
        userVOPage.getRecords().forEach(userVO -> {
        });
        return userVOPage;
    }

    /**
     * 分页显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param page: 分页显示VO
     * @return Page<User>
     */
     private Page<UserVO> convertUserPageVO(Page<User> page){
        return UserConvert.INSTANCE.convertUserPageVO(page);
    }

    /**
     * 集合条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userDTO: 用户信息DTO对象
     * @return List<UserVO>
     */
    @Override
    public List<UserVO> list(UserDTO userDTO) {
        queryListCheck(userDTO);
        User user = convertUserListQuery(userDTO);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        buildListQueryWrapper(user, queryWrapper);
        List<User> userList = iUserRepository.list(queryWrapper);
        List<UserVO> userVOList = convertUserVOList(userList);
        return assignment(userVOList);
    }

    /**
     * 集合条件检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userDTO: 用户信息DTO对象
     */
     private void queryListCheck(UserDTO userDTO) {

    }

    /**
    * 列表查询模型转换
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param userDTO: 用户信息DTO对象
    * @return Page<User>
    */
    private User convertUserListQuery(UserDTO userDTO){
        return UserConvert.INSTANCE.convertUser(userDTO);
    }

    /**
    * 构建列表查询条件
    *
    * @author zhouxinlei
    * @since 2022-04-20
    * @param user: 用户信息
    * @param queryWrapper: 查询Wrapper
    */
    private void buildListQueryWrapper(User user, QueryWrapper<User> queryWrapper) {

    }

    /**
     * 列表显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userList: 用户信息列表
     * @return List<UserVO>
     */
     public List<UserVO> convertUserVOList(List<User> userList){
         return UserConvert.INSTANCE.convertUserVOList(userList);
     }

     /**
      * 集合,增强返回参数追加
      *
      * @author zhouxinlei
      * @since 2022-04-20
      * @param userVOList: 用户信息VO列表
      * @return List<User>
      */
     private List<UserVO> assignment(List<UserVO> userVOList) {
        userVOList.forEach(userVO -> {
        });
        return  userVOList;
     }

    /**
     * 单条条件查询
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return UserVO
     */
    @Override
    public UserVO getById(Long id) {
        User user = iUserRepository.getById(id);
        UserVO userVO = convertUserVO(user);
        return assignment(userVO);
    }

    /**
     * 详情显示模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param user: 用户信息
     * @return UserVO
     */
     private UserVO convertUserVO(User user){
        return UserConvert.INSTANCE.convertUserVO(user);
    }

    /**
     * 单条，增强返回参数追加
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userVO: 用户信息VO
     * @return User
     */
    private UserVO assignment(UserVO userVO) {
        return userVO;
    }

    /**
     * 新增
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userDTO: 用户信息DTO对象
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean save(UserDTO userDTO) {
        saveCheck(userDTO);
        User user = convertUserSaveModel(userDTO);
        return iUserRepository.save(user);
    }

    /**
     * 保存检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userDTO: 用户信息DTO对象
     */
    private void saveCheck(UserDTO userDTO) {

    }

    /**
     * 新增模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userDTO: 用户信息DTO对象
     * @return User
     */
     private User convertUserSaveModel(UserDTO userDTO){
        return UserConvert.INSTANCE.convertUser(userDTO);
    }

    /**
     * 修改
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userDTO: 用户信息修改DTO
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean updateById(UserDTO userDTO) {
        updateCheck(userDTO);
        User user = convertUpdateUserModel(userDTO);
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        buildUpdateWrapper(user,lambdaUpdateWrapper);
        return iUserRepository.update(user,lambdaUpdateWrapper);
    }

    /**
     * 更新检查
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userDTO: 用户信息DTO对象
     */
     private void updateCheck(UserDTO userDTO) {

    }

    /**
     * 构建修改条件
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param user: 用户信息
     * @param updateWrapper: 更新Wrapper
     */
    private void buildUpdateWrapper(User user, LambdaUpdateWrapper<User> updateWrapper) {
        // 更新条件以及设值
        updateWrapper.eq(User::getId,user.getId());
    }

    /**
     * 修改模型转换
     *
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userDTO: 用户信息DTO对象
     * @return User
     */
    public User convertUpdateUserModel(UserDTO userDTO){
        if(ObjectUtils.isEmpty(userDTO.getId())){
            ExceptionAssert.failure("id不能为空");
        }
        return UserConvert.INSTANCE.convertUser(userDTO);
    }

    /**
     * 删除
     * @author zhouxinlei
     * @since 2022-04-20
     * @param id: id
     * @return boolean
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public boolean deleteById(Long id) {
        return iUserRepository.removeById(id);
    }

    /**
     * Excel导入
     * @author zhouxinlei
     * @since 2022-04-20
     * @param multipartFile: 文件
     * @return Integer
     */
    @Override
    public Integer importExcel(MultipartFile multipartFile){
        return 0;
    }

    /**
     * Excel导出
     * @author zhouxinlei
     * @since 2022-04-20
     * @param userDTO 用户信息导出DTO
     * @param response http response
     */
     @Override
     public void exportData(UserDTO userDTO, HttpServletResponse response){

    }
}

