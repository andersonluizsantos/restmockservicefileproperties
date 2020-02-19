package br.com.anderson.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.anderson.model.Employee;
import br.com.anderson.model.Employees;
import br.com.anderson.model.Staff;
import br.com.anderson.util.Configuration;

@Path("/api")
public class EmployeeService {
	
	// Lendo os dados do arquivo anderson.prpoperties
	private static final Configuration CONFIGURATION = Configuration.getInstance("anderson", "anderson.properties");
	
	// Lendo os dados de uma linha específica
	private static String URL_MOCK = CONFIGURATION.get("link.mock");
		
	@GET
	@Path("/mock")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Staff getAllEmployeesMock() 
	{
	    //Obtendo o endereço do Mock Service no arquivo anderson.properties
		String url = URL_MOCK;
		
		//Criando a chamada REST
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(url).path("resource");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		
		// atribuindo os dados do response do mock para uma classe
		Staff staf = response.readEntity(Staff.class);
		return staf;
	}
	
	@GET
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employees getAllEmployees() 
	{
	    
		/*String link = ACCOUNT_URL;
		System.out.println(link);*/
		
		Employees list = new Employees();
	    list.setEmployeeList(new ArrayList<Employee>());
	     
	    list.getEmployeeList().add(new Employee(1, "Lokesh Gupta"));
	    list.getEmployeeList().add(new Employee(2, "Alex Kolenchiskey"));
	    list.getEmployeeList().add(new Employee(3, "David Kameron"));
	     
	    return list;
	}

}
