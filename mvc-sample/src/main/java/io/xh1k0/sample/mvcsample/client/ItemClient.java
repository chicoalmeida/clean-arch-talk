package io.xh1k0.sample.mvcsample.client;

import io.xh1k0.sample.mvcsample.domain.Item;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class ItemClient {

  private final RestTemplate restTemplate;

  public Optional<Item> fetchItem(final String itemId) {
    try {
      return Optional.ofNullable(restTemplate
          .getForEntity(this.createURI(itemId), Item.class).getBody());
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
