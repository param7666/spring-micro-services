package com.nt.client;

import java.awt.image.RescaleOp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("BootMSProj07-BillingService-ProviderMS") // targer service id
public interface IBillingMsServiceClientCom {

	@GetMapping("/billing-api/bill")
	public ResponseEntity<String> invokeDoBilling();
}
