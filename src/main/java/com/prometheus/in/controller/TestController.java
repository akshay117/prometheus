package com.prometheus.in.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prometheus.in.entity.RequestEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class TestController {
	
	@PostMapping("/test")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Results are ok", content = { @Content(mediaType = "application/json",
	                        schema = @Schema(implementation = RequestEntity.class)) }),
	        @ApiResponse(responseCode = "400", description = "Invalid request",
	                content = @Content),
	        @ApiResponse(responseCode = "404", description = "resource not found",
	                content = @Content) })
	@Operation(summary = "Springdoc open api sample API")
	public ResponseEntity postApiCall(@RequestBody RequestEntity request){
	    System.out.println("Test----------------------------------------------Test ");
	    return new ResponseEntity(HttpStatus.OK);
	}
	


}
