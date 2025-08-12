package com.estudos_1.aula.service;

import com.estudos_1.aula.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        double basic = order.getBasic();
        return (basic < 100) ? 20.0
                : (basic <= 200) ? 12.0
                : 0.0;
    }
}
