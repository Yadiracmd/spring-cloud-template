package top.mqxu.cloud.product.mapping;

import org.mapstruct.Mapper;
import top.mqxu.cloud.api.pojo.dto.ProductDTO;
import top.mqxu.cloud.common.handler.BaseMapping;
import top.mqxu.cloud.product.entity.ProductDO;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description ProductMapping
 **/
@Mapper(componentModel = "spring")
public interface ProductMapping extends BaseMapping<ProductDO, ProductDTO> {

}