package io.xh1k0.sample.domain.item.gateway;

import io.xh1k0.sample.domain.item.domain.Item;
import java.util.Optional;

public interface ItemDataProvider {

  Optional<Item> retrieveItem(String itemId);
}
