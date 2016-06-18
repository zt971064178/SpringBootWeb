package cn.itcast.springbootweb.jeresy.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alibaba.fastjson.JSONObject;

import cn.itcast.springbootweb.http.domain.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/server")
@Api(value = "/server")
public class DemoServer {
	
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_HTML})
    @ApiOperation(value = "create product", notes = "More notes about this method", response = String.class, httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Product not found")
    })
	public Response createProduct(Product product) {
		System.out.println(JSONObject.toJSONString(product));
		return Response.status(Response.Status.CREATED).build() ;
	}

	@GET
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Find product by ID", notes = "More notes about this method", response = Product.class, httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public Response getProduct(@ApiParam(value = "Resource identifier", required = false) @QueryParam("id") Integer id) {
		System.out.println("进入Get:"+id);
		if(id ==null){
            return Response.status(Response.Status.NO_CONTENT).allow("OPTIONS").build();
        }else {
            return Response.status(Response.Status.NO_CONTENT).allow("OPTIONS").build();
        }
    }
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_HTML})
    @ApiOperation(value = "update product", notes = "More notes about this method", response = String.class, httpMethod = "PUT")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Product not found")
    })
    public Response updateProduct(Product product) {
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Produces({MediaType.TEXT_HTML})
    @ApiOperation(value = "remove product by ID", notes = "More notes about this method", response = String.class, httpMethod = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Product not found")
    })
    public Response removeProductById(@ApiParam(value = "ID values must", required = true)
                                      @QueryParam("id") Integer id) {
        return Response.status(Response.Status.OK).build();
    }
}
