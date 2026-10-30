package net.wiam.transactionservice.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Account {
    private UUID id;
    private String customerReference;
    private String status;
    private String currency;
    private double balance;
}
