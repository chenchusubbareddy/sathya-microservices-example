package com.customer.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("FriendMicro")
public interface FriendFeign {

	@GetMapping("/FriendDetailsApi/{phoneNumber}")
	List<Long> getFriends(@PathVariable Long phoneNumber);
}
