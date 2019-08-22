package io.xh1k0.sample.mvcsample.controller;


import static io.xh1k0.sample.mvcsample.utils.ItemUtils.create_fake_mlb_item_id;
import static io.xh1k0.sample.mvcsample.utils.ItemUtils.create_fake_seller_id;
import static io.xh1k0.sample.mvcsample.utils.ItemUtils.create_fake_sku;
import static io.xh1k0.sample.mvcsample.utils.ItemUtils.randomNumber;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.xh1k0.sample.mvcsample.domain.FiscalProduct;
import io.xh1k0.sample.mvcsample.service.FiscalProductService;
import java.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@WebMvcTest(FiscalProductController.class)
public class FiscalProductControllerTest {

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private FiscalProductService fiscalProductService;

  @Autowired
  private MockMvc mvc;


  @Test
  public void given_valid_sku_create_and_return_create() throws Exception {

    //given
    final FiscalProduct fiscalProduct = gimmeValidFiscalProductFixture();
    Mockito.doReturn(fiscalProduct)
        .when(fiscalProductService)
        .createFiscalProduct(any());
    //when
    final ResultActions result = this.mvc
        .perform(
            post("/fiscal-product")
                .content(asJsonString(fiscalProduct))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

    //then
    result
        .andExpect(status().isCreated());
  }

  @Test
  public void given_valid_sku_with_invalid_item_id_create_and_return_create() throws Exception {

    //given
    final FiscalProduct fiscalProduct = gimmeValidFiscalProductFixture();
    Mockito.doThrow(new RuntimeException("item not found"))
        .when(fiscalProductService)
        .createFiscalProduct(any());
    //when
    final ResultActions result = this.mvc
        .perform(
            post("/fiscal-product")
                .content(asJsonString(fiscalProduct))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

    //then
    result
        .andExpect(status().isBadRequest())
        .andExpect(content().string("item not found"));

    ;
  }


  public String asJsonString(final Object obj) {
    try {
      final String jsonContent = this.objectMapper.writeValueAsString(obj);
      System.out.println(jsonContent);
      return jsonContent;
    } catch (Exception e) {
      Assert.fail("Unable to serialize object");
      throw new RuntimeException(e);
    }
  }

  private FiscalProduct gimmeValidFiscalProductFixture() {
    return FiscalProduct.builder()
        .itemId(create_fake_mlb_item_id())
        .sellerSku(create_fake_sku())
        .sellerId(create_fake_seller_id())
        .ean(randomNumber(10))
        .ncm(randomNumber(6))
        .cest(randomNumber(4))
        .originType("importado")
        .originDetail("Estrangeira - Importação direta, exceto a indicada no código 6")
        .cost(randomNumber(5))
        .taxRuleId(randomNumber(2))
        .description(
            "Product de test generico - ".concat(String.valueOf(LocalDateTime.now().getNano())))
        .build();
  }


}