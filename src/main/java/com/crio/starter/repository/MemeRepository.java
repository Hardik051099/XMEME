package com.crio.starter.repository;

import java.util.List;
import java.util.Optional;
import com.crio.starter.data.MemesEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MemeRepository extends MongoRepository<MemesEntity,String> {
    @Query(value = "{}", sort = "{_id:-1}")
    Optional<List<MemesEntity>> findLatest100Memes(Pageable pageable);
    Optional<MemesEntity> findByNameAndCaptionAndUrl(String name, String caption, String url);
    Optional<MemesEntity> findMemeById(String id);
}
