package ge.evgo.shop.controller.ws.rest.config;

import ge.evgo.shop.controller.ws.rest.service.RestService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by root_pc on 4/26/2016.
 */

@ApplicationPath("/rest/*")
public class RestConfiguration extends Application{
    private Set<Class<?>> resources = new HashSet<Class<?>>();

    public RestConfiguration () {
        resources.add(RestService.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return resources;
    }
}
