package com.mbprojects.springboot.app.models.service;

import com.mbprojects.springboot.app.models.dao.IClientDaoJpaRepository;
import com.mbprojects.springboot.app.models.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class works as a Facade (Facade pattern). This is a single access point
 * and in here can be implemented multiple dao´s through their services interfaces.
 */

@Service
public class ClientServiceImpl implements IClientService {

//  @Autowired
//  private IClientDao clientDao;   //This is for the custom repository

  @Autowired
  private IClientDaoJpaRepository clientDao;

  @Override
  @Transactional(readOnly = true)
  public List<Client> findAll() {
    return clientDao.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Client findOne(Long id) {
    return clientDao.findById(id).orElse(null);
  }

  @Override
  @Transactional
  public void save(Client client) {
    clientDao.save(client);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    clientDao.deleteById(id);
  }
}