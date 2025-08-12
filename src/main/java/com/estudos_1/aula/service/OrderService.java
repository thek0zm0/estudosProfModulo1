package com.estudos_1.aula.service;

import com.estudos_1.aula.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        double discountedPrice = calculateDiscountedPrice(order);
        double shippingCost = shippingService.shipment(order);
        return discountedPrice + shippingCost;
    }

    private double calculateDiscountedPrice(Order order) {
        double discountPercent = order.getDiscount() / 100.0;
        double basic = order.getBasic();
        if (discountPercent > 0) {
            return basic * (1 - discountPercent);
        }
        return basic;
    }
}
