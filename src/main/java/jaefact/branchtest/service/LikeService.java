package jaefact.branchtest.service;

import jaefact.branchtest.domain.likes.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final LikesRepository likesRepository;
}
