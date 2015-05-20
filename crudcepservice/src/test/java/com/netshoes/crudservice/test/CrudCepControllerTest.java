package com.netshoes.crudservice.test;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.netshoes.hiring.crudcepservice.controller.CrudCepController;
import com.netshoes.hiring.crudcepservice.model.CustomCep;
import com.netshoes.hiring.crudcepservice.model.Address;
import com.netshoes.hiring.crudcepservice.service.CepService;
import com.netshoes.hiring.crudcepservice.service.AddressService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/WEB-INF/mvc-dispatcher-servlet.xml" })
public class CrudCepControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private CrudCepController crudCepController;

	@Mock
	private AddressService addressService;

	@Mock
	private CepService cepService;


	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(crudCepController).dispatchOptions(true).build();
	}

	/**
	 * Create address test
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateAddress() throws Exception {

		final String cep = "06807060";
		final String id = "123";

		Address enderecoIn = new Address();
		enderecoIn.setCep(cep);
		enderecoIn.setCity("Netshoes");
		enderecoIn.setState("SP");
		enderecoIn.setNumber("2015");
		enderecoIn.setStreet("Rua Netshoes");

		CustomCep customCep = new CustomCep();
		customCep.setId(cep);

		when(cepService.validateCep(cep)).thenReturn(customCep);
		when(addressService.insertAddress(enderecoIn)).thenReturn(id);
		when(crudCepController.createAddress(enderecoIn)).thenReturn(Mockito.any(Address.class));

		String body = "{\"street\":\"Rua Test Hiring\",\"number\":\"201505\",\"cep\":\"06807060\",\"city\":\"Netshoes\",\"state\":\"SP\"}";

		mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
																						.andExpect(status().isOk())
																						.andExpect(jsonPath("$.cep", is(cep)));
	}

	/**
	 * Update address test
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUpdateAddress() throws Exception {

		final String cep = "06753160";
		final String id = "1234";

		Address enderecoIn = new Address();
		enderecoIn.setCep(cep);
		enderecoIn.setCity("Netshoes");
		enderecoIn.setState("SP");
		enderecoIn.setNumber("1453");
		enderecoIn.setStreet("Rua Vergueiro");

		Address enderecoOut = new Address();
		enderecoOut.setId(id);
		enderecoOut.setCep(cep);
		enderecoOut.setCity("Netshoes");
		enderecoOut.setState("SP");
		enderecoOut.setNumber("1454");
		enderecoOut.setStreet("Rua Vergueiro");

		CustomCep customCep = new CustomCep();
		customCep.setId(cep);

		when(cepService.validateCep(cep)).thenReturn(customCep);
		when(addressService.updateAddress(enderecoIn)).thenReturn(id);

		String body = "{\"street\":\"Rua Vergueiro\",\"number\":\"1455\",\"cep\":\"06753160\",\"city\":\"Netshoes\",\"state\":\"SP\"}";

		mockMvc.perform(put("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
																					   .andExpect(status().is(HttpStatus.NO_CONTENT.value()));
	}

	/**
	 * Delete address test
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteAddress() throws Exception {

		final String id = "1234";

		when(addressService.deleteAddress(id)).thenReturn(true);
		
		mockMvc.perform(delete("/" + id).contentType(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
																				 .andExpect(status().isOk());
	}

	/**
	 * Get address test
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSelectAddress() throws Exception {

		final String cep = "06753160";
		final String id = "12345";

		Address enderecoOut = new Address();
		enderecoOut.setCep(cep);
		enderecoOut.setCity("Netshoes");
		enderecoOut.setState("SP");
		enderecoOut.setNumber("123");
		enderecoOut.setStreet("Rua Vergueiro");

		when(addressService.selectAddress(id)).thenReturn(enderecoOut);
		when(crudCepController.getAddress(id)).thenReturn(enderecoOut);

		mockMvc.perform(get("/" + id).contentType(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
																			  .andExpect(status().isOk()).andExpect(jsonPath("$.cep", is(cep)));
	}

}
