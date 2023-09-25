package csd.week5.user;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import csd.week5.ticket.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

/* Implementations of UserDetails to provide user information to Spring Security, 
e.g., what authorities (roles) are granted to the user and whether the account is enabled or not
*/
public class User implements UserDetails{
    private static final long serialVersionUID = 1L;

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    
    @NotNull(message = "Username should not be null")
    @Size(min = 5, max = 20, message = "Username should be between 5 and 20 characters")
    private String username;
    
    @NotNull(message = "Password should not be null")
    @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;

    @NotNull(message = "Authorities should not be null")
    // We define two roles/authorities: ROLE_USER or ROLE_ADMIN
    private String authorities;

    @NotNull(message = "Email should not be null")
    @Size(min = 8, message = "Email should be at least 8 characters")
    private String email;

    @NotNull(message = "Credit card number should not be null")
    @Size(min = 8, message = "Credit card number should be 8 digits")
    private String credit_card_num;

    @NotNull(message = "Address should not be null")
    @Size(min = 8, message = "Address should be at least 8 characters")
    private String address;

    @NotNull(message = "Phone number should not be null")
    @Size(min = 8, message = "Phone number should be at least 8 characters")
    private String phone_num;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ticket> tickets;

    public User(String username, String password, String authorities, String email, String credit_card_num, String address, String phone_num){
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.email = email;
        this.credit_card_num = credit_card_num;
        this.address = address;
        this.phone_num = phone_num;
    }


    /* Return a collection of authorities (roles) granted to the user.
    */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(authorities));
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
        return true;
    }
}