package com.bank.account.repository;

import com.bank.account.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountAuditRepository extends JpaRepository<Audit, Long> {
}