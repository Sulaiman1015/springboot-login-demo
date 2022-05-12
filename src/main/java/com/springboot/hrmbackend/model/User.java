package com.springboot.hrmbackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userlist")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //@Column(name = "id", unique = true, nullable = false)
  private Long id;

  //@Column(name="name",length = 20)
  private String rolename;

  //@Column(name="username",length = 20)
  private String username;

  //@Column(name="password",length = 20)
  private String password;

}
