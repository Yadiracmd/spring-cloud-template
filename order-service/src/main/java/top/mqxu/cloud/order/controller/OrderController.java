package top.mqxu.cloud.order.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.mqxu.cloud.api.facade.OrderFacade;
import top.mqxu.cloud.api.pojo.dto.OrderDTO;
import top.mqxu.cloud.api.pojo.query.OrderCreateQuery;
import top.mqxu.cloud.order.entity.OrderDO;
import top.mqxu.cloud.order.mapping.OrderMapping;
import top.mqxu.cloud.order.service.OrderService;

import java.util.List;

/**
 * @author mqxu
 * @date 2024/9/11
 * @description OrderController
 **/
@RequiredArgsConstructor
@RestController
@Slf4j
public class OrderController implements OrderFacade {
    private final OrderService orderService;

    private final OrderMapping orderMapping;

    private final HttpServletRequest request;

    @Override
    public OrderDTO order(@RequestBody OrderCreateQuery orderCreateQuery) throws Exception {
        String uid = request.getHeader("uid");
        String username = request.getHeader("username");
        log.info("用户 [{}, {}] 正在下单：{}", uid, username, orderCreateQuery);
        return orderService.createOrder(orderCreateQuery);
    }

    @Override
    public List<OrderDTO> orders(@PathVariable("uid") Integer uid) {
        LambdaQueryWrapper<OrderDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDO::getUid, uid);
        IPage<OrderDO> page = orderService.page(new Page<>(2, 3), queryWrapper);
        return orderMapping.convertTo(page.getRecords());
    }

}