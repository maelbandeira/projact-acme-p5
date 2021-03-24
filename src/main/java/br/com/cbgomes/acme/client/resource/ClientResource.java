/**
 * 
 */
package br.com.cbgomes.acme.client.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cbgomes.acme.client.domain.Client;
import br.com.cbgomes.acme.client.repository.ClientRepository;


@RestController
@RequestMapping("/api/clients")
public class ClientResource {
	
	@Autowired
	private ClientRepository repository;
	
	

	@PutMapping()
	public void updateClient(@RequestBody Client client) {
		this.repository.save(client);
		}	
	
	
	@GetMapping("/{id}")
	public Client getClientById(@PathVariable("id") Long id) {
		return this.repository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable("id")Long id) {
		this.repository.deleteById(id);
	}	
	
	@GetMapping
	public List<Client> getAllClients(){
		List<Client> clients = this.repository.findAll();
		return clients;
	}
	
	@PostMapping
	public void createClient(@RequestBody Client client) {
		this.repository.save(client);
	}
	
	
}











