package com.github.sparkzxl.tenant.domain.service;

import com.github.sparkzxl.tenant.domain.repository.ITenantManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-07-03 13:13:52
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ITenantManagerRepository tenantManagerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return tenantManagerRepository.getAuthUserDetail(username);
    }
}
