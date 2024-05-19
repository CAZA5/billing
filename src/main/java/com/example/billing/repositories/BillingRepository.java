package com.example.billing.repositories;

import com.example.billing.models.BillingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<BillingModel, Long> {
}
