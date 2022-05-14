package jaefact.branchtest.business.repository.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import static jaefact.branchtest.business.domain.rider.QRider.rider;

import jaefact.branchtest.business.domain.rider.QRider;
import jaefact.branchtest.business.domain.rider.Rider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Repository
public class RiderRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public Rider findByEmail(String email){
        Rider rider = queryFactory
                .selectFrom(QRider.rider)
                .where(QRider.rider.email.eq(email))
                .fetchOne();

        if (rider == null)
            throw new NoSuchElementException("조회 실패");
        return rider;
    }

    public Rider findByCarNumber(String carNumber){
        Rider rider = queryFactory.selectFrom(QRider.rider)
                .where(QRider.rider.carNumber.eq(carNumber))
                .fetchOne();

        if (rider == null)
            throw new NoSuchElementException("조회 실패");
        return rider;
    }

    public Rider findByPhone(String phone){
        Rider rider = queryFactory.selectFrom(QRider.rider)
                .where(QRider.rider.phone.eq(phone))
                .fetchOne();

        if (rider == null)
            throw new NoSuchElementException("조회 실패");
        return rider;
    }
}
