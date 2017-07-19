package com.example.terencepan.budgetapp.repo;

import com.example.terencepan.budgetapp.model.SavedSearches;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Terence Pan on 6/28/2017.
 */
public interface SavedSearchRepository extends CrudRepository<SavedSearches, Long> {
    List<SavedSearches> findByUserId(String userId);
}
