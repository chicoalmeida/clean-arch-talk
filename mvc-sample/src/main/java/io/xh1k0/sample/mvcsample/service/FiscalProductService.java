package io.xh1k0.sample.mvcsample.service;

import io.xh1k0.sample.mvcsample.client.ItemClient;
import io.xh1k0.sample.mvcsample.domain.FiscalProduct;
import io.xh1k0.sample.mvcsample.repository.FiscalProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FiscalProductService {

  private final FiscalProductRepository fiscalProductRepository;
  private final ItemClient itemClient;

  public FiscalProduct createFiscalProduct(final FiscalProduct fiscalProduct) {
    itemClient.fetchItem(fiscalProduct.getItemId())
        .orElseThrow(() -> new RuntimeException("item not found"));

    return fiscalProductRepository.save(fiscalProduct);
  }
}
