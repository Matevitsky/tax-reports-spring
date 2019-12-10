package com.matevytskyi.taxreports.service;


import com.matevytskyi.taxreports.entity.Request;

public interface RequestService extends CrudService<Request> {

    boolean deleteByClientID(int clientId);
}
