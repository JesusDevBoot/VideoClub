package gonzalez.jesus.videoclub.service;


import java.util.ArrayList;
import java.util.List;

import gonzalez.jesus.videoclub.model.Cliente;

public class ClienteService {
	
	private List<Cliente> clientes;
	
	public ClienteService() {
		this.clientes=new ArrayList<>();
	}
	
	// metodos: agregarCliente, buscarClientePorId, eliminarCliente, getClientes
	
	public List<Cliente> getClientes() {
	    return new ArrayList<>(clientes);
	}
	
	public void agregarCliente(Cliente cliente) {
		if(cliente == null) {
			throw new  IllegalArgumentException("El cliente es obligatoria");
		}
		
		if(buscaPorId(cliente.getId()) != null) {
		    throw new IllegalArgumentException(
		        "Ya existe un cliente con ese ID");
		}
		this.clientes.add(cliente);
	}

	public Cliente buscaPorId(int id) {
		
		for (Cliente cliente : clientes) {
			
			if (cliente.getId() == id) {
				return cliente;

			}
		}

		return null;
	}
	
public boolean eliminarCliente(int id) {
		
		Cliente cliente =  buscaPorId(id);
		if( clientes != null) {
			
			clientes.remove(cliente);
		
				return true;
			}
			return false;
	}


	
		
		
	}
	
	


