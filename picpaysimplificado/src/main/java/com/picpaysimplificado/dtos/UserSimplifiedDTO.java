package com.picpaysimplificado.dtos;

import com.picpaysimplificado.domain.user.UserType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UserSimplifiedDTO(Long userID, String usersFirstName, String usersLastName, String userDocument, BigDecimal amount, BigDecimal finalBalance, UserType userType, LocalDateTime transactionTime, Long transactionID) {
}
