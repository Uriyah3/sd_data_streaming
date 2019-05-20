package com.streaming.wiki.repository;

import com.streaming.wiki.entities.Wikipedia_Entries;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface Wikipedia_Entries_Repository extends PagingAndSortingRepository<Wikipedia_Entries, Integer> {
}
