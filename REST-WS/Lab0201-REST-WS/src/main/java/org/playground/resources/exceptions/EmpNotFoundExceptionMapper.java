package org.playground.resources.exceptions;


import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

import jakarta.ws.rs.ext.*;


@Provider
public class EmpNotFoundExceptionMapper implements ExceptionMapper<EmpNotFoundException>{

    @Override
    public Response toResponse(EmpNotFoundException e){
        ErrorMessage errorMessage  = new ErrorMessage();
        errorMessage.setErrorCode(15590);
        errorMessage.setErrorMsg(e.getMessage());
        errorMessage.setErrDescription("The Id is wrong , Check it!");

        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }

}