package com.thinktionary.thinktionary_backend.repository;

import com.thinktionary.thinktionary_backend.entity.PageCollection;
import com.thinktionary.thinktionary_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageCollectionRepository extends JpaRepository<PageCollection, Long> {

    List<PageCollection> findByOwnerId(Long ownerId);

}
