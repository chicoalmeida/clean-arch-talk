package io.xh1k0.sample.mvcsample.domain;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
public class FiscalProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String itemId;
  private String sellerSku;
  private Long sellerId;
  private Long ean;
  private Long ncm;
  private Long cest;
  private String originType;
  private String originDetail;
  private Long cost;
  private Long taxRuleId;
  private String description;
  @CreatedDate
  private Instant createdAt;
  @LastModifiedDate
  private Instant updatedAt;
}

