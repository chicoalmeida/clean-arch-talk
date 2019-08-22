package io.xh1k0.sample.mvcsample.controller;

import io.xh1k0.sample.mvcsample.domain.FiscalProduct;
import io.xh1k0.sample.mvcsample.service.FiscalProductService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("fiscal-product")
@RequiredArgsConstructor
public class FiscalProductController {

  private final FiscalProductService fiscalProductService;


  @PostMapping
  public ResponseEntity<?> create(@RequestBody FiscalProduct fiscalProduct) {
    try {
      FiscalProduct result = fiscalProductService.createFiscalProduct(fiscalProduct);

      final URI location = ServletUriComponentsBuilder
          .fromCurrentRequest().path("/fiscal-product/{id}")
          .buildAndExpand(result.getId()).toUri();
      return ResponseEntity.created(location).build();
    } catch (final Exception exception) {
      return ResponseEntity.badRequest().body(exception.getMessage());
    }
  }

}
