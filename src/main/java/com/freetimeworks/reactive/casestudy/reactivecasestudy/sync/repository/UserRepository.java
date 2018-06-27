package com.freetimeworks.reactive.casestudy.reactivecasestudy.sync.repository;

import com.freetimeworks.reactive.casestudy.reactivecasestudy.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile(value = {"sync"})
public interface UserRepository extends CassandraRepository<User, Object> {

    List<User> getByRegion(String id);
}