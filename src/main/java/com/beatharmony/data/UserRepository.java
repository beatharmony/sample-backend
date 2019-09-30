package com.beatharmony.data;

import com.beatharmony.model.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface UserRepository extends CrudRepository<User, String> {

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    List<User> findByEmail(String email);

    List<User> findByUsername(String username);
}
