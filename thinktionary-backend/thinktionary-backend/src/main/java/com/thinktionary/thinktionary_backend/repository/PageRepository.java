package com.thinktionary.thinktionary_backend.repository;

import com.thinktionary.thinktionary_backend.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
}
