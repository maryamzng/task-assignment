package com.example.demo.repository;

import com.example.demo.entity.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountInfo, Long> {

    Optional<AccountInfo> findByAccountNo(String accountNo);
}
