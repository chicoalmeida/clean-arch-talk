package io.xh1k0.sample.application.fiscalProduct.gateway.mysql;

import io.xh1k0.sample.application.fiscalProduct.gateway.mysql.domain.FiscalProductEntity;
import io.xh1k0.sample.domain.fiscalProduct.gateway.CreateFiscalProductGateway;
import io.xh1k0.sample.domain.fiscalProduct.usecase.CreateFiscalProductUseCase.FiscalProduct;
import javax.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreateFiscalMySqlProvider implements CreateFiscalProductGateway {

  private final FiscalProductRepository fiscalProductRepository;

  @Override
  public FiscalProduct execute(final FiscalProduct requestModel) {
    final FiscalProductEntity saved = fiscalProductRepository
        .save(FiscalProductEntity.fromDomain(requestModel));
    return saved.toDomain();
  }
}
