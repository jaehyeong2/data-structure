package jaefact.branchtest.business.domain.user;

import jaefact.branchtest.business.domain.BaseTimeEntity;
import jaefact.branchtest.business.domain.seller.Seller;
import jaefact.branchtest.business.dto.user.UserDto;
import lombok.*;
import org.apache.tomcat.jni.Local;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class User extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user_id; // 숫자 영대문자 혼합으로 10글자 이하

    @JoinColumn(name = "seller_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Seller seller;

    private String ssn; // 주민등록번호. 13글자. 암호화

    @Column(name = "car_number")
    private String carNumber; //차량번호

    private String name;
    private String username;
    private String password;
    private String email;

    private String phone; // 하이픈없이 11글자.

    @Enumerated(EnumType.STRING)
    private ActStatus actStatus;

    private String insuranceStatus;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Builder
    public static User create(UserDto dto){
        return builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .carNumber(dto.getCarNumber())
                .phone(dto.getPhone())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
