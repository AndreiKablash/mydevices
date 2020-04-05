package by.pvt.service;

import by.pvt.pojo.user.AppUser;
import by.pvt.pojo.user.AppUserRole;
import by.pvt.pojo.user.RoleName;
import by.pvt.repository.UserRepository;
import by.pvt.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class UserService {

    private static Logger log = Logger.getLogger("UserService.class");

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public AppUser findUser(Long id){
        return userRepository.findById(id);
    }

    @Transactional
    public boolean saveUser(AppUser user){
        if(user==null
                ||user.getLogin().isEmpty()
                ||user.getFirstName().isEmpty()
                ||user.getLastName().isEmpty()
                ||user.getEmail().isEmpty()
                ||user.getPassword().isEmpty()
                ||userRepository.findUserByEmail(user.getLogin())!=null){
            return false;
        }
        AppUserRole appUserRole = userRoleRepository.findRoleByName(RoleName.USER);
        if(appUserRole==null){
            appUserRole = new AppUserRole();
            appUserRole.setRoleName(RoleName.USER);
            userRoleRepository.save(appUserRole);
        }
        user.setRoles(Set.of(appUserRole));

        //Encoding password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        log.info("Encoded password: " + encodedPassword);
        user.setPassword(encodedPassword);
        log.info("save user" + user.toString());
        userRepository.add(user);
        return true;
    }

    @Transactional
    public boolean deleteUser(AppUser user){
        if (user == null) {
            return false;
        }
        return userRepository.delete(user);
    }

}
