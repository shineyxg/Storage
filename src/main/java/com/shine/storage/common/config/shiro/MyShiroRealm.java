package com.shine.storage.common.config.shiro;

import com.shine.storage.dao.dto.SysPermissionDTO;
import com.shine.storage.dao.dto.SysRoleDTO;
import com.shine.storage.dao.dto.UserInfoDTO;
import com.shine.storage.dao.mapper.PermissionMapper;
import com.shine.storage.dao.mapper.RoleMapper;
import com.shine.storage.dao.mapper.UserInfoMapper;
import com.shine.storage.rest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年10月14日 19:50
 */

@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    //private final Logger log = LoggerFactory.getLogger(MyShiroRealm.class);

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
        // User userInfo = (User) principalCollection.getPrimaryPrincipal();

        Session session = SecurityUtils.getSubject().getSession();
        UserInfoDTO user = (UserInfoDTO) session.getAttribute("USER_SESSION");
        /*查询该用户的角色*/
        // List<SysRole> roles = roleMapper.findRolesByUserId(userInfo.getId());
        List<SysRoleDTO> roles = user.getRoleList();
        for (SysRoleDTO role : roles) {
            authorizationInfo.addRole(role.getRole());
            /*根据roleid查询该角色对应的权限*/
            // List<SysPermission> permissions = permissionMapper.findPermissionsByRoleId(role.getId());
            List<SysPermissionDTO> permissions = role.getPermissions();
            for (SysPermissionDTO permission : permissions) {
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
        UserInfoDTO user = userInfoMapper.findUserInfoByAccount(account);
        /*为查询到用户信息，抛出异常*/
        if (user == null)
            throw new UnknownAccountException("账号或者密码不正确，请确认后重新登录！");

        if (3 == user.getState().getIndex())
            throw new LockedAccountException();

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialSalt()),
                getName());
        /*获取session*/
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("USER_SESSION", user);

        return authenticationInfo;
    }


}
