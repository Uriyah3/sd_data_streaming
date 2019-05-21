package com.streaming.wiki.repositories;

import com.streaming.wiki.models.Wikipedia_Entries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Wikipedia_Entries_Repository extends JpaRepository<Wikipedia_Entries, Long> {
}
