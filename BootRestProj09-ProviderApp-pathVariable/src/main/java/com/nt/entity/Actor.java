package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

	private Integer aid;
	private String name;
	private String addrs;
	private double remunaretion;
}
