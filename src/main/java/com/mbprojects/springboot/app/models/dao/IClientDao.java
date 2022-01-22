package com.mbprojects.springboot.app.models.dao;

import com.mbprojects.springboot.app.models.entity.Client;
import java.util.List;

public interface IClientDao {

  List<Client> findAll();

  void save(Client client);

}
