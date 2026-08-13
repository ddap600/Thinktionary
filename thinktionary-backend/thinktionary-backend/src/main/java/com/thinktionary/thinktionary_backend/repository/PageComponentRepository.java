package com.thinktionary.thinktionary_backend.repository;

import com.thinktionary.thinktionary_backend.entity.PageComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageComponentRepository extends JpaRepository<PageComponent, Long> {
}
