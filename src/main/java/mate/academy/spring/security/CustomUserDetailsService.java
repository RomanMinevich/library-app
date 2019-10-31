package mate.academy.spring.security;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.dao.UserDao;
import mate.academy.spring.entity.Role;
import mate.academy.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                getAuthorities(getRoleNames(user.getRoles())));
    }

    private static List<String> getRoleNames(List roles) {
        List<String> names = new ArrayList<>();
        for (Object role : roles) {
            names.add(((Role)role).getName());
        }
        return names;
    }

    private static List<GrantedAuthority> getAuthorities(List<String> roleNames) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String roleName : roleNames) {
            authorities.add(new SimpleGrantedAuthority(roleName));
        }
        return authorities;
    }
}
