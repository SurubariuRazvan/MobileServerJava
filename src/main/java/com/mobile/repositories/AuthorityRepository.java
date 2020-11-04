package com.mobile.repositories;

import com.mobile.domain.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    List<Authority> findByNameIn(List<String> names);
}
