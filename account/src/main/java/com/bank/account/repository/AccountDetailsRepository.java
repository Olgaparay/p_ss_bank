package com.bank.account.repository;

import com.bank.account.entity.AccountDetails;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.jpa.repository.JpaRepository;

@Timed("controller: getUnsecuredData")
@Timed("controller: createAuthToken")
@Timed("repository: findUserByProfileId")
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {
}