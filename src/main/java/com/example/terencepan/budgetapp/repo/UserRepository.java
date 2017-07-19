package com.example.terencepan.budgetapp.repo;

import com.example.terencepan.budgetapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Terence Pan on 6/28/2017.
 */
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findByUserName(String userName);

}
