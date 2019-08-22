package io.xh1k0.sample.application.item.model;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {

  private String item;
  private String title;
  private List<Variation> variations;

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Variation {

    private String id;
    private List<String> pictureIds;
  }

  public io.xh1k0.sample.domain.item.domain.Item toDomain() {
    return new io.xh1k0.sample.domain.item.domain.Item(this.item, null);
  }
}
