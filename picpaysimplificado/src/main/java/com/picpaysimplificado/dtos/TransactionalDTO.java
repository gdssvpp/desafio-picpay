package com.picpaysimplificado.dtos;

import java.math.BigDecimal;

public record TransactionalDTO(BigDecimal value, Long senderId, Long receiverId) {
}
