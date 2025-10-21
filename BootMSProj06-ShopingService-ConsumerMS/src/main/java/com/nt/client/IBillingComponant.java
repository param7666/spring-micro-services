package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="BootMSProj06-BillingService-ProviderMS")
public interface IBillingComponant {

	@GetMapping("/billing-api/bill")
	public ResponseEntity<String> invokeDoBilling();
}
