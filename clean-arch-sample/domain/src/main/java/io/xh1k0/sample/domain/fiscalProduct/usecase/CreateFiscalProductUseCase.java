package io.xh1k0.sample.domain.fiscalProduct.usecase;

import io.xh1k0.sample.domain.fiscalProduct.gateway.CreateFiscalProductGateway;
import javax.inject.Named;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;


@Named
@RequiredArgsConstructor
public class CreateFiscalProductUseCase {

  private final CreateFiscalProductGateway itemCreateUseCase;

  public FiscalProduct execute(final FiscalProduct requestModel) {
    return itemCreateUseCase.execute(requestModel);
  }



  @Value
  @Builder
  @AllArgsConstructor
  public final static class FiscalProduct {

    public final Long id;
    public final String itemId;
    public final String sellerSku;
    public final Long sellerId;
    public final Long ean;
    public final Long ncm;
    public final Long cest;
    public final String originType;
    public final String originDetail;
    public final Long cost;
    public final Long taxRuleId;
    public final String description;

  }


}
