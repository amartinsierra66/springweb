package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import model.Cuenta;
import model.Movimiento;
import service.CajeroService;

@Controller
public class CajeroController {
	@Autowired
	CajeroService service;
	@PostMapping("doValidar")
	public String validar(@RequestParam("numeroCuenta") int numeroCuenta,HttpSession sesion) {
		Cuenta cuenta=service.validarCuenta(numeroCuenta);
		if(cuenta!=null) {
			sesion.setAttribute("numeroCuenta", cuenta.getNumeroCuenta());
			return "menu";
		}else {
			return "error";
		}
	}
	@PostMapping("doExtraer")
	public String extraer(@RequestParam("cantidad") double cantidad,@SessionAttribute("numeroCuenta") int numeroCuenta) {
		service.extraer(cantidad, numeroCuenta);
		return "menu";
	}
	@PostMapping("doIngresar")
	public String ingresar(@RequestParam("cantidad") double cantidad,@SessionAttribute("numeroCuenta") int numeroCuenta) {
		service.ingresar(cantidad, numeroCuenta);
		return "menu";
	}
	@PostMapping("doTransferencia")
	public String transferir(@RequestParam("cantidad") double cantidad,
			@SessionAttribute("numeroCuenta") int numeroCuentaOrigen,
			@RequestParam("numeroCuentaDestino") int numeroCuentaDestino) {
		service.transferencia(cantidad, numeroCuentaOrigen, numeroCuentaDestino);
		return "menu";
	}
	@GetMapping(value="doMovimientos",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Movimiento> recuperarMovientos(@SessionAttribute("numeroCuenta") int numeroCuenta, 
									@RequestParam("f1") String f1,
									@RequestParam("f2") String f2,
									HttpServletRequest request) {
		DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		request.setAttribute("saldo", service.saldo(numeroCuenta));
		return service.recuperarMovimientos(numeroCuenta,LocalDate.parse(f1, format),LocalDate.parse(f2, format));
		
	}
	
}
