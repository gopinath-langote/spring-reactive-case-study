package com.freetimeworks.reactive.casestudy.reactivecasestudy.async.repository;

import com.freetimeworks.reactive.casestudy.reactivecasestudy.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
@Profile(value = {"async"})
public interface UserRepository extends CassandraRepository<User, Long> {

    @Async
    CompletableFuture<List<User>> getByRegion(String region);

}