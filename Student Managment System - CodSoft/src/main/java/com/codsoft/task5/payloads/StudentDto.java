package com.codsoft.task5.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
	private int id;
	@NotBlank(message = "Name can not be empty or blank")
	@Size(min = 4, message="Name should be minmun of 4 character")
	private String name;
	@NotBlank(message = "Field can not be empty or blank")
	@Size(min = 4, message="Field should be minmun of 4 character")
	private String field;
	@NotBlank(message = "Grade can not be empty or blank")
	private String grade;
	

}
