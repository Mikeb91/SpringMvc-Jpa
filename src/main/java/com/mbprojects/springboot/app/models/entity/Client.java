package com.mbprojects.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "clients")
public class Client implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotEmpty
  @Size(min = 4, max = 50)
  @Column(name = "first_name")
  private String firstName;
  @NotEmpty
  @Size(min = 4, max = 50)
  @Column(name = "last_name")
  private String lastName;
  @NotEmpty
  @Email
  private String email;
  @Column(name = "create_at")
  @Temporal(TemporalType.DATE) //Indicates the  format of the date in the DB
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createAt;

//  @PrePersist                  - This method can be used to populate createAt param automatically
//  public void prePersist(){
//    createAt = new Date();
//  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String nombre) {
    this.firstName = nombre;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String apellido) {
    this.lastName = apellido;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }
}
