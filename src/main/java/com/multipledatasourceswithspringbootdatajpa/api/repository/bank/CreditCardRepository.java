package com.multipledatasourceswithspringbootdatajpa.api.repository.bank;

import com.multipledatasourceswithspringbootdatajpa.api.model.bank.card.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {
}
