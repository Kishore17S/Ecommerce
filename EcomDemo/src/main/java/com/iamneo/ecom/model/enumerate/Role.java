package com.iamneo.ecom.model.enumerate;

import static com.iamneo.ecom.model.enumerate.Permission.ADMIN_CREATE;

import static com.iamneo.ecom.model.enumerate.Permission.ADMIN_DELETE;
import static com.iamneo.ecom.model.enumerate.Permission.ADMIN_READ;
import static com.iamneo.ecom.model.enumerate.Permission.ADMIN_UPDATE;
import static com.iamneo.ecom.model.enumerate.Permission.CUSTOMER_CREATE;
import static com.iamneo.ecom.model.enumerate.Permission.CUSTOMER_DELETE;
import static com.iamneo.ecom.model.enumerate.Permission.CUSTOMER_READ;
import static com.iamneo.ecom.model.enumerate.Permission.CUSTOMER_UPDATE;
import static com.iamneo.ecom.model.enumerate.Permission.PRODUCT_CREATE;
import static com.iamneo.ecom.model.enumerate.Permission.PRODUCT_DELETE;
import static com.iamneo.ecom.model.enumerate.Permission.PRODUCT_READ;
import static com.iamneo.ecom.model.enumerate.Permission.PRODUCT_UPDATE;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
public enum Role {
    ADMIN(Set.of(
            ADMIN_READ,
            ADMIN_CREATE,
            ADMIN_UPDATE,
            ADMIN_DELETE,
            CUSTOMER_READ,
            CUSTOMER_CREATE,
            CUSTOMER_UPDATE,
            CUSTOMER_DELETE)),
    CUSTOMER(Set.of(
            CUSTOMER_READ,
            CUSTOMER_CREATE,
            CUSTOMER_UPDATE,
            CUSTOMER_DELETE)),
    PRODUCT(Set.of(
            PRODUCT_READ,
            PRODUCT_CREATE,
            PRODUCT_UPDATE,
            PRODUCT_DELETE));

    @Getter
    private final Set<Permission> permissions;

    public Set<Permission> getPermissions() {
		return permissions;
	}

	private Role(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<SimpleGrantedAuthority> getAuthority() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Permission permission : getPermissions()) {
            authorities.add(new SimpleGrantedAuthority(permission.getPermission()));
        }

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}