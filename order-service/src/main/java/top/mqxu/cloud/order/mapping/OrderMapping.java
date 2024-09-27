package top.mqxu.cloud.order.mapping;

import org.mapstruct.Mapper;
import top.mqxu.cloud.api.pojo.dto.OrderDTO;
import top.mqxu.cloud.common.constants.DateConsts;
import top.mqxu.cloud.common.handler.BaseMapping;
import top.mqxu.cloud.order.entity.OrderDO;

import java.time.format.DateTimeFormatter;

/**
 * @author mqxu
 * @date 2024/9/20
 * @description OrderMapping
 **/
@Mapper(componentModel = "spring")
public interface OrderMapping extends BaseMapping<OrderDO, OrderDTO> {

    @Override
    default void afterConvertTo(OrderDO src, OrderDTO dest) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DateConsts.YYYY_MM_DD_HH_MM_SS);
        dest.setCreateTime(src.getCreateTime().format(dateTimeFormatter));
        dest.setUpdateTime(src.getUpdateTime().format(dateTimeFormatter));
    }

}