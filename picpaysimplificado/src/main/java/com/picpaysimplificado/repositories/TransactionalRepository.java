package com.picpaysimplificado.repositories;

import com.picpaysimplificado.domain.transactional.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionalRepository extends JpaRepository<Transaction, Long> {
}
