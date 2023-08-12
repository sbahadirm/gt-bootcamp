package com.garantitech.gtbootcamp.general;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 *   2. create_date
 *   3. update_date
 *   4. created_by
 *   5. updated_by
 * @author bahadirmemis
 */
@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {

  private LocalDateTime create_date;
  private LocalDateTime update_date;

  private Long created_by;

  private Long updated_by;

}
