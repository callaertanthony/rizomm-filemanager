package com.rizomm.filemanager.business.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@Data
@NoArgsConstructor
public class User {

  @Id
  private Long id;

  @NonNull
  private String name;

  @Email
  private String email;

  @NotNull
  @Enumerated(EnumType.STRING)
  private AuthProvider provider;

  private String providerId;

}
