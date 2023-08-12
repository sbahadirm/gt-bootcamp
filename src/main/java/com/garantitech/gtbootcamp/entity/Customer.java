package com.garantitech.gtbootcamp.entity;

import com.garantitech.gtbootcamp.enums.EnumStatus;
import com.garantitech.gtbootcamp.general.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 1. id,
 * 2. create_date
 * 3. update_date
 * 4. created_by
 * 5. updated_by
 *
 *
 * @author bahadirmemis
 */
@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer")
  @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ", allocationSize = 1)
  private Long id;

  @Column(name = "name", length = 50, nullable = false)
  private String name;

  @Column(name = "surname", length = 50, nullable = false)
  private String surname;

  @Column(name = "USERNAME", length = 20, nullable = false)
  private String username;

  @Column(name = "PASSWORD", length = 400, nullable = false)
  private String password;

  @Column(name = "EMAIL", length = 50, nullable = false)
  private String email;

  @Column(name = "PHONE_NUMBER", length = 15, nullable = false)
  private String phoneNumber;

  //@Temporal(TemporalType.DATE)
  //@Column(name = "BIRTH_DATE1")
  //private Date birthDate1;

  @Column(name = "BIRTH_DATE")
  private LocalDate birthDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "STATUS", length = 30)
  private EnumStatus status;
}
