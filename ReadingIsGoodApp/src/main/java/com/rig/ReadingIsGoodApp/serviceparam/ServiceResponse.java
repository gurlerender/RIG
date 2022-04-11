package com.rig.ReadingIsGoodApp.serviceparam;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse<T> {
	private boolean isSuccessful;
	private String message;
	private T object;
}
