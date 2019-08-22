package io.xh1k0.sample.mvcsample.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

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
}
