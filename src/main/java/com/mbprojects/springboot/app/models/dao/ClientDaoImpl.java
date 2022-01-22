package com.mbprojects.springboot.app.models.dao;

import com.mbprojects.springboot.app.models.entity.Client;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("clientDaoJpa") //Persistence Component with access to the DATA
public class ClientDaoImpl implements IClientDao{

  @PersistenceContext
  private EntityManager em;

  @Transactional(readOnly = true)
  @Override
  @SuppressWarnings("unchecked")
  public List<Client> findAll() {
    return em.createQuery("from Client").getResultList();
  }

  @Override
  @Transactional
  public void save(Client client) {
    em.persist(client);
  }

}
