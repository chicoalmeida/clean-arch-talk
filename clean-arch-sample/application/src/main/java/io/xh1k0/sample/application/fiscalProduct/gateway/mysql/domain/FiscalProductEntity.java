package io.xh1k0.sample.application.fiscalProduct.gateway.mysql.domain;


import io.xh1k0.sample.domain.fiscalProduct.usecase.CreateFiscalProductUseCase.FiscalProduct;
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
public class FiscalProductEntity {

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

  public FiscalProduct toDomain() {
    return FiscalProduct.builder()
        .id(this.id)
        .itemId(this.itemId)
        .sellerSku(this.sellerSku)
        .sellerId(this.sellerId)
        .ean(this.ean)
        .ncm(this.ncm)
        .cest(this.cest)
        .originType(this.originType)
        .originDetail(this.originDetail)
        .cost(this.cost)
        .taxRuleId(this.taxRuleId)
        .description(this.description)
        .build();
  }

  public static FiscalProductEntity fromDomain(final FiscalProduct fiscalProduct) {
    return FiscalProductEntity.builder()
        .id(fiscalProduct.getId())
        .itemId(fiscalProduct.getItemId())
        .sellerSku(fiscalProduct.getSellerSku())
        .sellerId(fiscalProduct.getSellerId())
        .ean(fiscalProduct.getEan())
        .ncm(fiscalProduct.getNcm())
        .cest(fiscalProduct.getCest())
        .originType(fiscalProduct.getOriginType())
        .originDetail(fiscalProduct.getOriginDetail())
        .cost(fiscalProduct.getCost())
        .taxRuleId(fiscalProduct.getTaxRuleId())
        .description(fiscalProduct.getDescription())
        .build();
  }
}

