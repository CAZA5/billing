package com.example.billing.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class BillingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billingId;
    private Integer numeroCliente;
    private String detalle;
    private Float monto;
}
