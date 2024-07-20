package com.prometheus.in.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class RequestEntity {
	
	@Size(min = 0,max = 20)
	@Schema(description = "This is the name",example = "ABC")
	String name;

	@NotBlank
	@Size(min = 0,max = 10)
	@Schema(description = "This is the ID",example = "123")
	String id;
}
