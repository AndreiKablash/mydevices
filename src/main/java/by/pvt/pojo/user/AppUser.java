package by.pvt.pojo.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class AppUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    @OneToMany
    private Set<AppUserRole> roles;

}
