package org.main.cacheseries.repo;

import org.main.cacheseries.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User,String> {

    User findByEmail(String email);
}
