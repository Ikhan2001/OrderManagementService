package com.ik.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OrderRequestDto {

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than 0")
    private Double amount;

    public OrderRequestDto() {
    }

    public OrderRequestDto(String customerName, Double amount) {
        this.customerName = customerName;
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderRequestDto{" +
                "customerName='" + customerName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
