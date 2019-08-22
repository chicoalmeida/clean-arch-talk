package io.xh1k0.sample.domain.fiscalProduct.gateway;

import io.xh1k0.sample.domain.fiscalProduct.usecase.CreateFiscalProductUseCase.FiscalProduct;

public interface CreateFiscalProductGateway {

  FiscalProduct execute(FiscalProduct requestModel);
}
