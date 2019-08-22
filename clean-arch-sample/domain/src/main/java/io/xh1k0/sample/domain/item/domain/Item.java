package io.xh1k0.sample.domain.item.domain;


import lombok.Value;

@Value
public final class Item {

  private final String itemId;
  private final String variationId;

  public Item(final String itemId, final String variationId) {
    this.itemId = itemId;
    this.variationId = variationId;
  }
}

