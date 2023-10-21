package com.iamneo.ecom.model.enumerate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    CUSTOMER_READ("customer:read"),
    CUSTOMER_UPDATE("customer:update"),
    CUSTOMER_CREATE("customer:create"),
    CUSTOMER_DELETE("customer:delete"),
    PRODUCT_READ("product:read"),
    PRODUCT_UPDATE("product:update"),
    PRODUCT_CREATE("product:create"),
    PRODUCT_DELETE("product:delete");

    @Getter
    private final String permission;

	public String getPermission() {
		return permission;
	}



	private Permission(String permission) {
		this.permission = permission;
	}
    
    
}