package priv.xzhi.security.action01.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import priv.xzhi.security.action01.mapper.UsersMapper;
import priv.xzhi.security.action01.model.entity.Users;

/**
 * @author Xzhi
 * @desc: MyUserDetailsService
 * @date 2020-05-05 22:14
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库尝试读取该用户
        Users user = usersMapper.findByUserName(username);
        // 用户不存在，抛出异常
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        /*
        将数据库形式的 roles 解析为 UserDetails 的权限集
        AuthorityUtils.commaSeparatedStringToAuthorityList 是 Spring Security 提供的，
        该方法用于将逗号隔开的权限集字符串切割成可用权限对象列表。
        当然也可以自己实现，参考 generateAuthorities
         */
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
        return user;
    }

    private List<GrantedAuthority> generateAuthorities(String roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        String[] roleArray = roles.split(",");
        if (StringUtils.isNoneBlank(roles)) {
            for (String role : roleArray) {
                /*
                SimpleGrantedAuthority是GrantedAuthority的一个实现类。Spring Security的权限几乎是用
                SimpleGrantedAuthority生成的，只要注意每种角色对应一个GrantedAuthority即可
                 */
                authorities.add(new SimpleGrantedAuthority(role));
            }
        }
        return authorities;
    }
}
