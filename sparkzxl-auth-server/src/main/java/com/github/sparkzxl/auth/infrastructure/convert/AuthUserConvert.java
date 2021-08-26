package com.github.sparkzxl.auth.infrastructure.convert;

import com.github.sparkzxl.auth.api.dto.UserDetailInfo;
import com.github.sparkzxl.auth.domain.model.aggregates.AuthUserBasicInfo;
import com.github.sparkzxl.auth.api.dto.StationBasicInfo;
import com.github.sparkzxl.auth.domain.model.aggregates.excel.UserExcel;
import com.github.sparkzxl.auth.api.dto.AuthUserBasicVO;
import com.github.sparkzxl.auth.infrastructure.entity.AuthUser;
import com.github.sparkzxl.auth.infrastructure.entity.CoreOrg;
import com.github.sparkzxl.auth.infrastructure.entity.CoreStation;
import com.github.sparkzxl.auth.api.constant.enums.SexEnum;
import com.github.sparkzxl.auth.interfaces.dto.user.UserQueryDTO;
import com.github.sparkzxl.auth.interfaces.dto.user.UserSaveDTO;
import com.github.sparkzxl.auth.interfaces.dto.user.UserUpdateDTO;
import com.github.sparkzxl.entity.core.AuthUserInfo;
import com.github.sparkzxl.entity.data.RemoteData;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * description: AuthUser对象Convert
 *
 * @author charles.zhou
 * @date 2020-06-05 21:28:06
 */
@Mapper
public interface AuthUserConvert {

    AuthUserConvert INSTANCE = Mappers.getMapper(AuthUserConvert.class);

    /**
     * AuthUser转化为AuthUserInfo
     *
     * @param authUser 用户
     * @return AuthUserInfo
     */
    AuthUserInfo<Long> convertAuthUserInfo(AuthUser authUser);

    /**
     * AuthUser转化为UserDetailInfo
     *
     * @param authUser 用户
     * @return AuthUserInfo
     */
    UserDetailInfo convertUserDetailInfo(AuthUser authUser);

    /**
     * AuthUserSaveDTO转化为 AuthUser
     *
     * @param userSaveDTO AuthUserSaveDTO保存对象
     * @return AuthUser
     */
    @Mappings({
            @Mapping(target = "sex", expression = "java(convertSex(userSaveDTO.getSex()))"),
            @Mapping(target = "org", expression = "java(convertRemoteData(userSaveDTO.getOrgId()))"),
            @Mapping(target = "station", expression = "java(convertRemoteData(userSaveDTO.getStationId()))"),
            @Mapping(target = "nation", expression = "java(convertRemoteData(userSaveDTO.getNation()))"),
            @Mapping(target = "education", expression = "java(convertRemoteData(userSaveDTO.getEducation()))"),
            @Mapping(target = "positionStatus", expression = "java(convertRemoteData(userSaveDTO.getPositionStatus()))"),
    })
    AuthUser convertAuthUser(UserSaveDTO userSaveDTO);

    /**
     * AuthUserUpdateDTO转化为AuthUser
     *
     * @param userUpdateDTO AuthUserUpdateDTO更新对象
     * @return AuthUser
     */
    @Mappings({
            @Mapping(target = "sex", expression = "java(convertSex(userUpdateDTO.getSex()))"),
            @Mapping(target = "org", expression = "java(convertRemoteData(userUpdateDTO.getOrgId()))"),
            @Mapping(target = "station", expression = "java(convertRemoteData(userUpdateDTO.getStationId()))"),
            @Mapping(target = "nation", expression = "java(convertRemoteData(userUpdateDTO.getNation()))"),
            @Mapping(target = "education", expression = "java(convertRemoteData(userUpdateDTO.getEducation()))"),
            @Mapping(target = "positionStatus", expression = "java(convertRemoteData(userUpdateDTO.getPositionStatus()))"),
    })
    AuthUser convertAuthUser(UserUpdateDTO userUpdateDTO);

    /**
     * AuthUserPageDTO转化为AuthUser
     *
     * @param userQueryDTO AuthUserDTO分页查询对象
     * @return AuthUser
     */
    @Mappings({
            @Mapping(target = "sex", expression = "java(convertSex(userQueryDTO.getSex()))"),
            @Mapping(target = "nation", expression = "java(convertRemoteData(userQueryDTO.getNation()))"),
    })
    AuthUser convertAuthUser(UserQueryDTO userQueryDTO);

    /**
     * 转换sex枚举
     *
     * @param sex 性别
     * @return SexEnum
     */
    default SexEnum convertSex(Integer sex) {
        if (ObjectUtils.isNotEmpty(sex)) {
            return SexEnum.getEnum(sex);
        }
        return null;
    }

    /**
     * 转换AuthUserBasicVO
     *
     * @param authUserBasicInfo 用户信息
     * @return AuthUserBasicVO
     */
    @Mapping(target = "sex", expression = "java(convertSex(authUserBasicInfo.getSex()))")
    AuthUserBasicVO convertAuthUserBasicVO(AuthUserBasicInfo authUserBasicInfo);

    /**
     * 转换AuthUser为AuthUserBasicInfo
     *
     * @param authUser 用户实体类
     * @return AuthUserBasicInfo
     */
    @Mappings({
            @Mapping(target = "org", ignore = true),
            @Mapping(target = "station", expression = "java(buildStation(authUser.getStation()))")
    })
    AuthUserBasicInfo convertAuthUserBasicInfo(AuthUser authUser);

    /**
     * 转换excel
     *
     * @param authUser 用户
     * @return UserExcel
     */
    @Mappings({
            @Mapping(target = "sex", expression = "java(convertSex(authUser.getSex()))"),
            @Mapping(target = "nation", expression = "java(convertNation(authUser.getNation()))"),
            @Mapping(target = "education", expression = "java(convertNation(authUser.getEducation()))"),
            @Mapping(target = "positionStatus", expression = "java(convertNation(authUser.getPositionStatus()))"),
            @Mapping(target = "orgName", expression = "java(convertOrg(authUser.getOrg()))"),
            @Mapping(target = "stationName", expression = "java(convertStation(authUser.getStation()))")
    })
    UserExcel convertUserExcel(AuthUser authUser);

    /**
     * 批量转换excel
     *
     * @param authUserList 用户列表
     * @return List<UserExcel>
     */
    List<UserExcel> convertUserExcels(List<AuthUser> authUserList);

    /**
     * 转换岗位
     *
     * @param station 组织
     * @return String
     */
    default String convertStation(RemoteData<Long, CoreStation> station) {
        if (ObjectUtils.isNotEmpty(station) && ObjectUtils.isNotEmpty(station.getData())) {
            return station.getData().getName();
        }
        return null;
    }

    /**
     * 转换组织
     *
     * @param org 组织
     * @return String
     */
    default String convertOrg(RemoteData<Long, CoreOrg> org) {
        if (ObjectUtils.isNotEmpty(org) && ObjectUtils.isNotEmpty(org.getData())) {
            return org.getData().getLabel();
        }
        return null;
    }

    /**
     * 转换性别
     *
     * @param sex 性别
     * @return String
     */
    default String convertSex(SexEnum sex) {
        if (ObjectUtils.isNotEmpty(sex)) {
            return sex.getDesc();
        }
        return null;
    }

    /**
     * 转换民族
     *
     * @param nation 性别
     * @return String
     */
    default String convertNation(RemoteData<String, String> nation) {
        if (ObjectUtils.isNotEmpty(nation) && StringUtils.isNotEmpty(nation.getData())) {
            return nation.getData();
        }
        return null;
    }

    /**
     * 构建职位
     *
     * @param station 职位实体类
     * @return StationBasicInfo
     */
    default StationBasicInfo buildStation(RemoteData<Long, CoreStation> station) {
        if (ObjectUtils.isNotEmpty(station) && ObjectUtils.isNotEmpty(station.getData())) {
            StationBasicInfo stationBasicInfo = new StationBasicInfo();
            stationBasicInfo.setId(station.getKey());
            stationBasicInfo.setName(station.getData().getName());
            return stationBasicInfo;
        }
        return null;
    }


    /**
     * 转换RemoteData
     *
     * @param key 主键
     * @return RemoteData
     */
    default RemoteData convertRemoteData(Object key) {
        if (ObjectUtils.isNotEmpty(key)) {
            return new RemoteData<>(key);
        }
        return null;
    }

}
