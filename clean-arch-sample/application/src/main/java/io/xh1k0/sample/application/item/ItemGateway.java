package io.xh1k0.sample.application.item;

import io.xh1k0.sample.application.item.model.ItemModel;
import io.xh1k0.sample.domain.item.domain.Item;
import io.xh1k0.sample.domain.item.gateway.ItemDataProvider;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.inject.Named;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Named
@RequiredArgsConstructor
public class ItemGateway implements ItemDataProvider {

  private final RestTemplate restTemplate;

  public Optional<Item> retrieveItem(final String itemId) {
    try {
      return Optional.ofNullable(restTemplate
          .getForEntity(this.createURI(itemId), ItemModel.class).getBody().toDomain());
    } catch (RestClientException e) {
      return Optional.empty();
    }
  }

  private URI createURI(final String itemId) {
    Map<String, String> params = new HashMap<>();
    params.put("itemId", itemId);

    return UriComponentsBuilder
        .fromUriString("{appURL}") //FIX
        .path("/items/{itemId}")
        .buildAndExpand(params)
        .toUri();
  }
}
