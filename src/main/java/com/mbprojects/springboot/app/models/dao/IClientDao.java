package com.mbprojects.springboot.app.models.dao;

import com.mbprojects.springboot.app.models.entity.Client;
import java.util.List;

public interface IClientDao {

  List<Client> findAll();

  Client findOne(Long id);

  void save(Client client);

  void delete(Long id);

}
