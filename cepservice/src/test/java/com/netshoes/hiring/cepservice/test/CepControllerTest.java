package com.netshoes.hiring.cepservice.test;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.netshoes.hiring.cepservice.controller.CepServiceController;
import com.netshoes.hiring.cepservice.model.Cep;
import com.netshoes.hiring.cepservice.service.CepService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/WEB-INF/mvc-dispatcher-servlet.xml" })
/**
 * Class to test the application
 * 
 * @author raul.sousa
 *
 */
public class CepControllerTest {

	private MockMvc mockMvc;

	@Mock
	private CepService cepService;

	@InjectMocks
	private CepServiceController cepController;

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(cepController).dispatchOptions(true).build();
	}

	/**
	 * Tests the system behavior with a given valid cep
	 * 
	 * @throws Exception
	 */
	@Test
	public void getCepByIdTest() throws Exception {

		Cep cepIn = new Cep();
		cepIn.setId("06807060");

		Cep cepOut = new Cep();
		cepOut.setId("06807060");
		cepOut.setState("SP");

		when(cepController.getCep(cepIn)).thenReturn(cepOut);
		
		String body = "{ \"id\": \"06807060\" }";

		mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is("06807060"))).andExpect(jsonPath("$.state", is("SP")));
	}

	/**
	 * Tests the system behavior while a valid cep not found, including zeros at
	 * the end
	 * 
	 * @throws Exception
	 */
	@Test
	public void cepFoundWithZerosTest() throws Exception {

		Cep cepIn = new Cep();
		cepIn.setId("90000009");

		Cep cepOut = new Cep();
		cepOut.setId("90000000");
		cepOut.setDistrict("Bairro dos zeros");

		when(cepController.getCep(cepIn)).thenReturn(cepOut);

		String body = "{ \"id\": \"90000009\" }";

		mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is("90000000"))).andExpect(jsonPath("$.district", is("Bairro dos zeros")));
	}

	/**
	 * Tests the system behavior with a cep not found
	 * 
	 * @throws Exception
	 */
	@Test
	public void cepNotFoundTest() throws Exception {

		Cep cepIn = new Cep();
		cepIn.setId("99999999");

		Cep cepOut = new Cep();

		when(cepController.getCep(cepIn)).thenReturn(cepOut);

		String body = "{ \"id\": \"99999999\" }";

		mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", IsNull.nullValue()));
	}

}
