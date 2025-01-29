package com.projeto.avabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.avabank.model.RegPixKey;

public interface RegPixKeyRepository extends JpaRepository<RegPixKey,Long>{

		RegPixKey findByUserId (Long userId);
}
