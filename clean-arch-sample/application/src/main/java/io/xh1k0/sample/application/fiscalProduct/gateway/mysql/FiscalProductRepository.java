package io.xh1k0.sample.application.fiscalProduct.gateway.mysql;

import io.xh1k0.sample.application.fiscalProduct.gateway.mysql.domain.FiscalProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface FiscalProductRepository extends CrudRepository<FiscalProductEntity, Long> {

}
