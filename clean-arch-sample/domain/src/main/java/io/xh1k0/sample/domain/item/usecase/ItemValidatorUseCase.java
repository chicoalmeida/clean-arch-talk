package io.xh1k0.sample.domain.item.usecase;

import io.xh1k0.sample.domain.item.gateway.ItemDataProvider;
import javax.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class ItemValidatorUseCase {

  private final ItemDataProvider itemGateway;

  public boolean execute(final String itemId) {
    return itemGateway.retrieveItem(itemId).isPresent();
  }
}
