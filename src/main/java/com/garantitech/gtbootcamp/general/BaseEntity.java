package com.garantitech.gtbootcamp.general;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author bahadirmemis
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable, Cloneable, BaseEntityModel{

  @Embedded
  private BaseAdditionalFields baseAdditionalFields;
}
