package com.bridgelabz.addressBookAppInSpring.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.addressBookAppInSpring.dto.ResponceDTO;

@ControllerAdvice
public class AddressBookExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponceDTO> handlerMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {

		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMesg = errorList.stream().map(objErr -> objErr.getDefaultMessage())
				.collect(Collectors.toList());

		ResponceDTO responseDTO = new ResponceDTO("Exception while processing REST requests", errMesg);
		ResponseEntity<ResponceDTO> responce = new ResponseEntity<ResponceDTO>(responseDTO, HttpStatus.BAD_REQUEST);
		return responce;
	}

}