package com.playground;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.util.List;

public interface HelloService {

    //@Secured must first be enabled in Configuration
    @Secured(value ={"ROLE_USER"})
    String userAccess();

    @Secured(value ={"ROLE_ADMIN"})
    String adminAccess();

    //JSR-250 's Annotations Should be enabled as well
    //@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
    @PermitAll
    String allAccess();

    @DenyAll
    String denyAllAccess();

    //Spring's Pre and Post filter/authorize
    @PreAuthorize("hasAuthority('ROLE_ADMIN') and #s.length() >= 5")
    @PostAuthorize("hasAuthority('ROLE_USER')")
    String addStringAdminOnly(@P("s") String str);

    @PostAuthorize("returnObject.equals(authentication.name)")
    public String returnString();

    @PreAuthorize("permitAll()")
    @PostFilter("filterObject.equals(authentication.name)")
    public List<String> getAllStrings();
}
