package net.wiam.accountservice.domain;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;
import net.wiam.accountservice.enums.AccountStatus;


@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Account {
    @Id @GeneratedValue
    private UUID id;
    private String customerReference;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private String currency;
    private double balance;

}
