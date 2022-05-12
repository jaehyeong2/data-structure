package jaefact.branchtest.business.repository.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jaefact.branchtest.business.domain.user.QUser;
import jaefact.branchtest.business.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

import static jaefact.branchtest.business.domain.user.QUser.user;

@RequiredArgsConstructor
@Repository
public class UserRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public User findByEmail(String email){
        User user = queryFactory
                .selectFrom(QUser.user)
                .where(QUser.user.email.eq(email))
                .fetchOne();

        if (user == null)
            throw new NoSuchElementException("조회 실패");
        return user;
    }

    public User findByCarNumber(String carNumber){
        User user = queryFactory.selectFrom(QUser.user)
                .where(QUser.user.carNumber.eq(carNumber))
                .fetchOne();

        if (user == null)
            throw new NoSuchElementException("조회 실패");
        return user;
    }

    public User findByPhone(String phone){
        User user = queryFactory.selectFrom(QUser.user)
                .where(QUser.user.phone.eq(phone))
                .fetchOne();

        if (user == null)
            throw new NoSuchElementException("조회 실패");
        return user;
    }
}
