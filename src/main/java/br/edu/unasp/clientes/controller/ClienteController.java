package br.edu.unasp.clientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unasp.clientes.model.Cliente;
import br.edu.unasp.clientes.services.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/cliente")
	@CrossOrigin(origins="*")
	public ResponseEntity<Iterable<Cliente>> getCliente(){
		return ResponseEntity.ok().body(clienteService.getCliente());
	}
	@GetMapping("/cliente/{id}")
	@CrossOrigin(origins="*")
	public ResponseEntity<Cliente> getCliente(@PathVariable Long id){
		return ResponseEntity.ok().body(clienteService.getCliente(id));
	}
	
	@PostMapping("/cliente")
	@CrossOrigin(origins="*")
	public ResponseEntity<Void> adicionarCliente(@RequestBody Cliente cliente){
		clienteService.createCliente(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/cliente")
	@CrossOrigin(origins="*")
	public ResponseEntity<Void> updateCliente(@RequestBody Cliente cliente){
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@DeleteMapping("/cliente/{id}")
	@CrossOrigin(origins="*")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
		var cli = clienteService.getCliente(id);
		clienteService.deleteCliente(cli);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
