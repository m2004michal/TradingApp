package com.tradingApp.tradingApp.service;

import com.tradingApp.tradingApp.dto.BalancesResponse;
import com.tradingApp.tradingApp.model.UserEntity;
import com.tradingApp.tradingApp.repository.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {



    private final UserEntityRepository userEntityRepository;
    private final AuthService authService;
    public BalancesResponse getBalances(long id) {
        UserEntity userEntity = userEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no user with given id found"));
        if (authService.isLoggedUserSameAsProvided(userEntity))
            return BalancesResponse.builder()
                    .escrowBalance(userEntity.getEscrowBalance())
                    .balance(userEntity.getBalance())
                    .securityBalance(userEntity.getSecurityBalance())
                    .build();
        else
            throw new RuntimeException("Currently logged userEntity doesnt matchh id of user which balances you're trying" +
                    "to check");
    }


    public Integer getLevel(long id) {
        UserEntity userEntity = userEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no user with given id found"));
        return userEntity.getLevel();
    }

    public String getProfilePictureUrl(long id) {
        UserEntity userEntity = userEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no user with given id found"));
        return userEntity.getProfilePictureUrl();
    }
}
