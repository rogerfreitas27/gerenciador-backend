package com.gerenciador.backend.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.dao.DataIntegrityViolationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.fasterxml.jackson.core.JsonParseException;
import java.io.FileNotFoundException;

@RestControllerAdvice
public class ErrorExceptionHandler {
	
	
	 private final Logger log = LoggerFactory.getLogger(ErrorExceptionHandler.class);
		
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
			Map<String, String> errors = new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach((error) -> {
				String fieldName = ((FieldError) error).getField();
				String errorMessage = error.getDefaultMessage();
				errors.put(fieldName, errorMessage);
			});
			log.warn("Erro: " + ex.getMessage());
			return errors;
		}
		
		
		
		
		
		@ExceptionHandler(FileNotFoundException.class)
		public ResponseEntity<?>FileNotFoundException(FileNotFoundException ex) {
			log.warn("Erro: " + ex.getMessage());
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
		
		
		
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(MessageExceptionHandler.class)
		public String MensagemCustomizada(MessageExceptionHandler ex) {
			//MessageException mensagemException =  new  MessageException(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(),ex.getMessage());
						
			log.warn("Erro: " + ex.getMessage());
			return   ex.getMessage() ;
			
		}
		
		
		
		
		
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(InvalidFormatException.class)
		public Map<String, String> handleValidationExceptions(InvalidFormatException ex) {
			Map<String, String> errors = new HashMap<>();
			errors.put("Erro:","Falha ao realizar conversão !" + ex.getMessage());
			log.warn("Erro: " + ex.getMessage());
			return errors;
			
		}
		
		
		
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(JsonMappingException.class)
		public Map<String, String> JsonMappingException(JsonMappingException ex) {
			Map<String, String> errors = new HashMap<>();
			errors.put("Erro:", ex.getMessage());
			log.warn("Erro: " + ex.getMessage());
			return errors;
			
		}
		
		
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(JsonParseException.class)
		public Map<String, String> JsonParseException(JsonParseException ex) {
			Map<String, String> errors = new HashMap<>();
			errors.put("Erro:", ex.getMessage());
			log.warn("Erro: " + ex.getMessage());
			return errors;
			
		}		
		
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(DataIntegrityViolationException.class)
		public Map<String, String> DataIntegrityViolationException(DataIntegrityViolationException ex) {
			Map<String, String> errors = new HashMap<>();
			errors.put("Falha", ex.getMessage());	
			log.warn("Erro: " + ex.getMessage());
			return errors;
		}
		
		
}
