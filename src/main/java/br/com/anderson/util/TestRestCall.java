package br.com.anderson.util;

import java.util.Arrays;
import java.util.List;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.anderson.model.Employee;
import br.com.anderson.model.Employees;



public class TestRestCall {
	
	

	private static final Configuration CONFIGURATION = Configuration.getInstance("resourceActivationPSA", "resourceActivationPSA.properties");
	private static String ACCOUNT_URL = CONFIGURATION.get("ra.psa.retrieve.account.url");
	    
	
	public static void main(String[] args) {
		
		String link = ACCOUNT_URL;
		
		/*Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		WebTarget webTarget = client.target("http://localhost:8083/projetorest/rest").path("employees");
		 
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_XML);
		Response response = invocationBuilder.get();
		 
		Employees employees = response.readEntity(Employees.class);
		List<Employee> listOfEmployees = employees.getEmployeeList();*/
		     
		/*System.out.println(response.getStatus());
		System.out.println(Arrays.toString( listOfEmployees.toArray(new Employee[listOfEmployees.size()]) ));*/
		
	}
	
	

}
