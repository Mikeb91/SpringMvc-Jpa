package com.mbprojects.springboot.app.models.service;

import com.mbprojects.springboot.app.models.entity.Client;
import java.util.List;

public interface IClientService {

  List<Client> findAll();

  Client findOne(Long id);

  void save(Client client);

  void delete(Long id);

}
