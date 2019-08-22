package io.xh1k0.sample.mvcsample.utils;

import java.util.Random;

public class ItemUtils {

  public static Long create_fake_seller_id() {
    return (long) (new Random().nextInt(9
        * (int) Math.pow(10, 9 - 1) - 1)
        + (int) Math.pow(10, 9 - 1));
  }

  public static String create_fake_mlb_item_id() {
    return "MLB".concat(String.valueOf(
        new Random().nextInt(9
            * (int) Math.pow(10, 9 - 1) - 1)
            + (int) Math.pow(10, 9 - 1)));
  }

  public static String create_fake_sku() {
    return randomString(3)
        .concat(String.valueOf(randomNumber(3)))
        .concat(randomString(3))
        .concat(String.valueOf(randomNumber(2)));

  }

  public static long randomNumber(int bound) {
    return (long) new Random().nextInt(bound
        * (int) Math.pow(10, bound - 1) - 1)
        + (int) Math.pow(10, bound - 1);
  }

  private static String randomString(int n) {
    final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder sb = new StringBuilder(n);

    for (int i = 0; i < n; i++) {
      int index
          = (int) (alphabet.length()
          * Math.random());

      sb.append(alphabet
          .charAt(index));
    }

    return sb.toString();
  }

}
