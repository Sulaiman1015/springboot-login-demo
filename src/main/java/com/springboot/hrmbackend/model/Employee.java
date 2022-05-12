package com.springboot.hrmbackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;



/*@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter*/
@Entity
@Table(name = "emplist")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  //@Column(name="name")
  private String name;
  //@Column(name="sex")
  private String sex;
  //@Column(name="age")
  private Integer age;
  //@Column(name="phone")
  private String phone;
  //@Column(name="email")
  private String email;
  //@Column(name="address")
  private String address;
  //@Column(name="join_date")
  private Date join_date;

  public Employee() {
  }

  public Employee(String name, String sex, Integer age, String phone, String email, String address, Date join_date) {
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.phone = phone;
    this.email = email;
    this.address = address;
    this.join_date = join_date;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getJoin_date() {
    return join_date;
  }

  public void setJoin_date(Date join_date) {
    this.join_date = join_date;
  }

}
