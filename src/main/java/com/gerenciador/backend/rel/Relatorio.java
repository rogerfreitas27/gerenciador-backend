package com.gerenciador.backend.rel;

import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class Relatorio  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Autowired
	private JdbcTemplate JdbTemplate;
	private static final String CAMINHOJASPER="src/main/java/com/gerenciador/backend/relatorio/";
	
public byte[] gerarRelatorio(String nomeRelatorio,ServletContext servletContext) throws Exception {
		
		/*  Obter conexão com o banco  */
		Connection connection  = JdbTemplate.getDataSource().getConnection();
		
		
		/* Carregar o caminho do arquivo jasper  */
		/*
		String caminhoJasper = servletContext.getRealPath("com.gerenciador.backend.relatorio")
				+ File.separator + nomeRelatorio + ".jasper"; 
		*/
	
				 
				
		/* Gerar relatório com os dados e conexao   */
		JasperPrint print = JasperFillManager.
				fillReport(CAMINHOJASPER+nomeRelatorio+".jasper", new HashMap(), connection);
				 
		/* Exporta para byte[] o PDF para download */
		byte[] retorno = JasperExportManager.exportReportToPdf(print);
		
		connection.close();
		return retorno;
	}

public byte[] relatorioEnderecoPessoa(String nomeRelatorio,HashMap parametrosRelatorio) throws Exception {

	/*  Obter conexão com o banco  */
	Connection connection  = JdbTemplate.getDataSource().getConnection();
	
	/* Gerar relatório com os dados e conexao   */
	JasperPrint print = JasperFillManager.
			fillReport(CAMINHOJASPER+nomeRelatorio+".jasper", parametrosRelatorio, connection);
	/* Exporta para byte[] o PDF para download */
	byte[] retorno = JasperExportManager.exportReportToPdf(print);
	
	connection.close();
	return retorno;
}
}
