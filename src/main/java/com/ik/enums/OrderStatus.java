package com.ik.enums;

import lombok.Builder;
import lombok.Data;

public enum OrderStatus {
    NEW, PROCESSING, COMPLETED;

    public boolean isTransitionValid(OrderStatus newStatus) {
        return switch (this) {
            case NEW-> newStatus == PROCESSING;
            case PROCESSING -> newStatus == COMPLETED;
            case COMPLETED -> false;
        };
    }
}
