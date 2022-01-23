package com.mbprojects.springboot.app.models.dao;

import com.mbprojects.springboot.app.models.entity.Client;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository("clientDaoJpa") //Persistence Component with access to the DATA
public class ClientDaoImpl implements IClientDao{

  @PersistenceContext
  private EntityManager em;

  @Override
  @SuppressWarnings("unchecked")
  public List<Client> findAll() {
    return em.createQuery("from Client").getResultList();
  }

  @Override
  public Client findOne(Long id) {
    return em.find(Client.class, id);
  }

  @Override
  public void save(Client client) {
    if(client.getId() != null && client.getId() > 0){
      em.merge(client);
    } else {
      em.persist(client);
    }
  }

  @Override
  public void delete(Long id) {
    em.remove(findOne(id));
  }

}
