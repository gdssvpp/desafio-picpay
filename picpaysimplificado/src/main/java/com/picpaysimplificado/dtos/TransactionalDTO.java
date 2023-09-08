package com.picpaysimplificado.dtos;

import com.picpaysimplificado.domain.user.User;

import java.math.BigDecimal;

public record TransactionalDTO(BigDecimal value, Long senderId, Long receiverId) {
}
