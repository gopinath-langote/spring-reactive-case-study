package com.freetimeworks.reactive.casestudy.reactivecasestudy.reactive.repository;

import com.freetimeworks.reactive.casestudy.reactivecasestudy.User;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@Profile(value = {"reactive"})
public interface UserRepository extends ReactiveCassandraRepository<User, Object> {

    @Async
    Flux<User> getByRegion(String region);

}
