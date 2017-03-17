package com.hzfh.rest_p2p.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzfh.rest_p2p.common.annotation.Validate;

@RestController
public class TT {

	@Validate
	@RequestMapping("test")
	public String test(@RequestParam(name = "name") String name, @RequestParam(name = "id") String id) {
		return "hello world";
	}
}
