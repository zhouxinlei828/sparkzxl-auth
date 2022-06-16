package com.github.sparkzxl.auth.api.dto;

import com.github.sparkzxl.core.tree.TreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * description: 组织基本信息
 *
 * @author charles.zhou
 * @since 2020-08-17 11:39:25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrgBasicInfo extends TreeNode<OrgBasicInfo, Long> implements Serializable {

    private static final long serialVersionUID = 4655524026041174419L;

}
