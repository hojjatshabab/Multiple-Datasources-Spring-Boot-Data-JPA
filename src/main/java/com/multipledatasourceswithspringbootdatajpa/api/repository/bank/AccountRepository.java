package com.multipledatasourceswithspringbootdatajpa.api.repository.bank;

import com.multipledatasourceswithspringbootdatajpa.api.model.bank.account.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
