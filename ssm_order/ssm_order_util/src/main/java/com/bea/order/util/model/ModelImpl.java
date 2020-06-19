package com.bea.order.util.model;

import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

/**
 * Created by fandi on 2020/6/19 0019.
 */
public class ModelImpl implements Model {
	@Override
	public Model addAttribute(String s, Object o) {
		return null;
	}
	
	@Override
	public Model addAttribute(Object o) {
		return null;
	}
	
	@Override
	public Model addAllAttributes(Collection<?> collection) {
		return null;
	}
	
	@Override
	public Model addAllAttributes(Map<String, ?> map) {
		return null;
	}
	
	@Override
	public Model mergeAttributes(Map<String, ?> map) {
		return null;
	}
	
	@Override
	public boolean containsAttribute(String s) {
		return false;
	}
	
	@Override
	public Map<String, Object> asMap() {
		return null;
	}
}
