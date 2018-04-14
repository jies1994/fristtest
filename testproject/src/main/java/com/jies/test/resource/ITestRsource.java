package com.jies.test.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
* Created by peijie on 17/6/1.
*/

public interface ITestRsource {

    @GET
    @Path("/test")
    public Integer test();
}
