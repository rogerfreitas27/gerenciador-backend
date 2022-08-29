package com.gerenciador.backend.exception;


import java.time.LocalDateTime;

public class MessageException {

	private LocalDateTime date;
	private Integer Status;
	private String Mensagem;
	
	public MessageException(LocalDateTime date, Integer status, String mensagem) {
		
		this.date = date;
		this.Status = status;
		this.Mensagem = mensagem;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	public String getMensagem() {
		return Mensagem;
	}

	public void setMensagem(String mensagem) {
		Mensagem = mensagem;
	}
	
	
	
}
