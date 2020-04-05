package by.pvt.security;

import by.pvt.pojo.user.AppUser;
import by.pvt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class AuthenticationService implements UserDetailsService {

    private static Logger log = Logger.getLogger("AuthenticationService.class");

    @Autowired
    UserRepository appUserRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser;
        if(userName.contains("@")){
            appUser = appUserRepo.findUserByEmail(userName);
        }else{
            appUser = appUserRepo.findUserByLogin(userName);
        }
        log.info("Searching for username=" + userName + " found: " + appUser);
        if (appUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = new User(appUser.getEmail(),
                appUser.getPassword(),
                appUser.getRoles().stream()
                        .map(appRole -> new SimpleGrantedAuthority("ROLE_" + appRole.getRoleName().name()))
                        .collect(Collectors.toSet())
        );
        log.info("Returned user=" + user);
        return user;
    }
}
