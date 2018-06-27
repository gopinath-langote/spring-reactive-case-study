package com.freetimeworks.reactive.casestudy.reactivecasestudy;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("users")
public class User {
    @JsonProperty
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String region;

    @JsonProperty
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    private Long id;

    @JsonProperty
    @Column
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
