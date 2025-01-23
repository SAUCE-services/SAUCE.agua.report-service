/**
 * 
 */
package com.sauce.agua.report.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.sauce.agua.report.service.LiquidacionService;
import jakarta.mail.MessagingException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daniel
 *
 */
@RestController
@RequestMapping({"/liquidacion", "/api/report/liquidacion"})
public class LiquidacionController {

	private final LiquidacionService service;

	public LiquidacionController(LiquidacionService service) {
		this.service = service;
	}

	@GetMapping("/sendLiquidacion/{prefijoId}/{facturaId}")
	public String sendLiquidacion(@PathVariable Integer prefijoId, @PathVariable Long facturaId)
			throws MessagingException {
		return service.sendLiquidacion(prefijoId, facturaId);
	}

	@GetMapping("/one/pdf/{prefijoId}/{facturaId}")
	public ResponseEntity<Resource> generateOnePdf(@PathVariable Integer prefijoId, @PathVariable Long facturaId)
			throws FileNotFoundException {
		String filename = service.generateOnePdf(prefijoId, facturaId);
		File file = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=liquidacion.pdf");
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
	}

	@GetMapping("/zona/pdf/{periodoId}/{zona}")
	public ResponseEntity<Resource> generateZonaPdf(@PathVariable Integer periodoId, @PathVariable Integer zona)
			throws FileNotFoundException {
		String filename = service.generateZonaPdf(periodoId, zona);
		File file = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=zona.pdf");
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
	}

}
