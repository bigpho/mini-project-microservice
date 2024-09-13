package id.bca.co.intra.mini_project.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "auth", url = "http://localhost:8888")
public interface JwtUtil {
    
	@RequestMapping(method=RequestMethod.POST, value="/api/validate")
	String validateToken(@RequestHeader("Authorization") String token);
	
}