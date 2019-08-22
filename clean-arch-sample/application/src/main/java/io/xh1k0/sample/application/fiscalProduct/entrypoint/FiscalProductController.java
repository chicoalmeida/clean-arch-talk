package io.xh1k0.sample.application.fiscalProduct.entrypoint;


import io.xh1k0.sample.domain.fiscalProduct.usecase.CreateFiscalProductUseCase;
import io.xh1k0.sample.domain.fiscalProduct.usecase.CreateFiscalProductUseCase.FiscalProduct;
import io.xh1k0.sample.domain.item.usecase.ItemValidatorUseCase;
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

  private final ItemValidatorUseCase itemValidatorUseCase;
  private final CreateFiscalProductUseCase createFiscalProduct;

  @PostMapping
  public ResponseEntity<?> create(@RequestBody FiscalProduct fiscalProduct) {
    try {
      if (!itemValidatorUseCase.execute(fiscalProduct.getItemId())) {
        return ResponseEntity.badRequest().body("Invalid ItemModel Id");
      }
      final FiscalProduct result = createFiscalProduct.execute(fiscalProduct);

      final URI location = ServletUriComponentsBuilder
          .fromCurrentRequest().path("/fiscal-product/{id}")
          .buildAndExpand(result.getId()).toUri();
      return ResponseEntity.created(location).build();
    } catch (final Exception exception) {
      return ResponseEntity.badRequest().body(exception.getMessage());
    }
  }

}

