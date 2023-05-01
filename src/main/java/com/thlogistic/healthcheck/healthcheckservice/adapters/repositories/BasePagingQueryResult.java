package com.thlogistic.healthcheck.healthcheckservice.adapters.repositories;

import lombok.Data;

@Data
public class BasePagingQueryResult<T> {
    Long total;
    Integer totalPage;

    T data;
}
