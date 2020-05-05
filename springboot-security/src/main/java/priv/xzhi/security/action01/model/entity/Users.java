package priv.xzhi.security.action01.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import lombok.Data;


/**
 * @author Xzhi
 * @desc: Users
 * @date 2020-05-05 21:58
 */

@Data
@TableName(value = "users")
public class Users implements Serializable, UserDetails {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    /**
     * 用户是否可用，1：是；0：否
     */
    @TableField(value = "enable")
    private boolean enable;

    /**
     * 用户角色，多个角色之间用逗号隔开
     */
    @TableField(value = "roles")
    private String roles;

    private List<GrantedAuthority> authorities;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWORD = "password";

    public static final String COL_ENABLE = "enable";

    public static final String COL_ROLES = "roles";

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }
}