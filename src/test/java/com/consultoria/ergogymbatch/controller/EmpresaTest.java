package com.consultoria.ergogymbatch.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.consultoria.ergogymbatch.ErgogymbatchApplicationTests;
import com.consultoria.ergogymbatch.model.Empresa;
import com.fasterxml.jackson.databind.ObjectMapper;


public class EmpresaTest extends ErgogymbatchApplicationTests {

	
	private MockMvc mockMvc;
	private Empresa empresa = new Empresa();
	private Integer id = 36;
	
	@Autowired
	private EmpresaController empresaController;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(empresaController).build();
	}
	
	@Test
    public void testEmpresaControllerCreated() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		empresa.setRazaoSocial("Razao Social Teste JUnit");
		empresa.setNomeFantasia("Nome Social Teste JUnit") ;
		empresa.setCnpj("99999999999999");
		empresa.setIndIEIsento(false) ;
		empresa.setInscricaoEstadual("9999999999");
		empresa.setCelular("(99) 99999-9999") ;
		empresa.setTelefone("(99) 9999-9999");
		empresa.setCep("99999-999") ;
		empresa.setEndereco("Endereco Teste ");
		empresa.setNumero("999999") ;
		empresa.setComplemento("Complemento Teste JUnit");
		empresa.setBairro("Bairro Teste JUnit") ;
		empresa.setCidade("Cidade Teste JUnit");
		empresa.setUf("TS") ;
		empresa.setReferencia("Referencia Teste JUnit");
		empresa.setObservacao("Observacao Teste JUnit") ;
		empresa.setEmail("Email Teste JUnit");
		

		this.mockMvc.perform(MockMvcRequestBuilders.post("/empresa")
				.content(asJsonString(empresa))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				).andExpect(ok)
                 .andDo(MockMvcResultHandlers.print());
    }
	
	@Test
    public void testEmpresaControllerList() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();

		this.mockMvc.perform(MockMvcRequestBuilders.get("/empresa")).andExpect(ok);
    }
	
	@Test
    public void testEmpresaControllerUpdate() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		empresa.setId(id);
		empresa.setRazaoSocial("Razao Social Teste JUnit - ALTERADO");
		empresa.setNomeFantasia("Nome Social Teste JUnit - ALTERADO") ;
		empresa.setCnpj("00000000000000");
		empresa.setIndIEIsento(true) ;
		empresa.setInscricaoEstadual("0000000000");
		empresa.setCelular("(00) 00000-0000") ;
		empresa.setTelefone("(00) 0000-0000");
		empresa.setCep("00000-000") ;
		empresa.setEndereco("Endereco Teste - ALTERADO");
		empresa.setNumero("00000") ;
		empresa.setComplemento("Complemento Teste JUnit - ALTERADO");
		empresa.setBairro("Bairro Teste JUnit - ALTERADO") ;
		empresa.setCidade("Cidade Teste JUnit - ALTERADO");
		empresa.setUf("AL") ;
		empresa.setReferencia("Referencia Teste JUnit - ALTERADO");
		empresa.setObservacao("Observacao Teste JUnit - ALTERADO") ;
		empresa.setEmail("Email Teste JUnit - ALTERADO");
		this.mockMvc.perform(MockMvcRequestBuilders.put("/empresa/" + empresa.getId())
	              .content(asJsonString(empresa))
	              .contentType(MediaType.APPLICATION_JSON)
	              .accept(MediaType.APPLICATION_JSON)
				).andExpect(ok)
        		 .andDo(MockMvcResultHandlers.print());
    }
	
	@Test
    public void testEmpresaControllerDelete() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/empresa/"+id)).andExpect(ok);
    }
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	
}