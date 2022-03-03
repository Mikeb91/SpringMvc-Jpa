package com.mbprojects.springboot.app.models.dao;

import com.mbprojects.springboot.app.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

//As this is extending from JpaRepository it is already a spring component, we don't need to annotate this.
public interface IClientDaoJpaRepository extends JpaRepository<Client, Long> {

}
