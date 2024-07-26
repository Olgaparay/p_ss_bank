package com.bank.account.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigInteger;
@Data
@Entity
@Table(schema = "account",
        name = "account_details",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"bank_details_id"},
                        name = "account_details_bank_details_id_key"),
                @UniqueConstraint(columnNames = {"account_number"},
                        name = "account_details_account_number_key"),
        })
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Positive
    @Column(name = "passport_id")
    private Long passportId;

    @NotNull
    @Min(value = 0)
    @Column(name = "account_number", nullable = false)
    private Long accountNumber;

    @NotNull
    @Min(value = 0)
    @Column(name = "bank_details_id", nullable = false)
    private Long bankDetailsId;


    @Column(name = "money", precision = 20, scale = 2)
    private BigInteger money;


    @Column(name = "negative_balance")
    private Boolean negativeBalance;


    @Min(value = 0)
    @Column(name = "profile_id")
    private Long profileId;
}
