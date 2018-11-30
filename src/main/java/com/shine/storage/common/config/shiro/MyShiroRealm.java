package com.shine.storage.common.config.shiro;

import com.shine.storage.dao.entity.SysPermission;
import com.shine.storage.dao.entity.SysRole;
import com.shine.storage.dao.entity.User;
import com.shine.storage.dao.mapper.PermissionMapper;
import com.shine.storage.dao.mapper.RoleMapper;
import com.shine.storage.dao.mapper.UserInfoMapper;
import com.shine.storage.rest.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年10月14日 19:50
 */
public class MyShiroRealm extends AuthorizingRealm {

    private final Logger log = LoggerFactory.getLogger(MyShiroRealm.class);

    @Resource
    private UserService userService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    /*此处是否应该一如passwordencoder对token中的密码进行加密后再去数据库中进行查询呢？*/


    /*权限配置*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("doGetAuthorizationInfo -------------> 权限认证方法");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo = (User) principalCollection.getPrimaryPrincipal();
        /*查询该用户的角色*/
        List<SysRole> roles = roleMapper.findRolesByUserId(userInfo.getId());
        for (SysRole role : roles) {
            authorizationInfo.addRole(role.getRole());
            /*根据roleid查询该角色对应的权限*/
            List<SysPermission> permissions = permissionMapper.findPermissionsByRoleId(role.getId());
            for (SysPermission permission : permissions) {
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("doGetAuthenticationInfo ------------------> 身份认证方法");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        /*获取登录的账号*/
        // String account = (String) authenticationToken.getPrincipal();
        String account = token.getUsername();
        String pwd = new String(token.getPassword());


        // User user = userService.findByAccountAndPwd(account, pwd);
        User user = userInfoMapper.findUserByAccount(account);
        /*为查询到用户信息，抛出异常*/
        if (user==null)
            throw new AuthenticationException("账号或者密码不正确，请确认后重新登录！");

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialSalt()),
                getName());
        return authenticationInfo;
    }


}
