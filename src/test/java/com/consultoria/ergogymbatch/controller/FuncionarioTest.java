package com.consultoria.ergogymbatch.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
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
import com.consultoria.ergogymbatch.model.Funcionario;
import com.consultoria.ergogymbatch.service.FuncionarioService;
import com.fasterxml.jackson.databind.ObjectMapper;



public class FuncionarioTest extends ErgogymbatchApplicationTests {

	
	private MockMvc mockMvc;
	private Funcionario funcionario = new Funcionario();
	private Integer id = 45;
	private Empresa empresa;

	@Autowired
	private FuncionarioController funcionarioController;
	

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private EmpresaController empresaController;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(funcionarioController).build();
		
	}
	
	@Test
	public void testFuncionarioServiceList() throws Exception{
		List<Funcionario> funcionarios = funcionarioService.findAll();
		Assert.assertNotNull(funcionarios);
		Assert.assertFalse(funcionarios.isEmpty());
	}
	
	@Test
	public void testFuncionarioServiceFindOne() throws Exception{
		Optional<Funcionario> funcionario = funcionarioService.findOne(id);
		Assert.assertNotNull(funcionario);
	}
	
	@Test
	public void testFuncionarioServiceSave() throws Exception{
		List<Empresa> empresas = empresaController.findAll();
		for(Empresa empresafisrt:empresas) {
			this.empresa = empresafisrt;
			break;
		}
		
		funcionario.setId(id);
		funcionario.setNome("Nome Teste JUnit - Alterado");
		funcionario.setCargo("Cargo Teste JUnit");
		funcionario.setSetor("Setor Teste JUnit");
		funcionario.setDataNascimento(new Date());
		funcionario.setCpf("99999999999999");
		funcionario.setCelular("(99) 99999-9999") ;
		funcionario.setTelefone("(99) 9999-9999");
		funcionario.setCep("99999-999") ;
		funcionario.setEndereco("Endereco Teste ");
		funcionario.setNumero("999999") ;
		funcionario.setComplemento("Complemento Teste JUnit");
		funcionario.setBairro("Bairro Teste JUnit") ;
		funcionario.setCidade("Cidade Teste JUnit");
		funcionario.setUf("TS") ;
		funcionario.setReferencia("Referencia Teste JUnit");
		funcionario.setObservacao("Observacao Teste JUnit") ;
		funcionario.setEmail("Email Teste JUnit");
		funcionario.setEmpresa(empresa);
		funcionario = funcionarioService.save(funcionario);
		System.out.println(funcionario.getId());
		Assert.assertTrue(id.equals(funcionario.getId()));
	}
	
	@Test
    public void testFuncionarioControllerCreated() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		
		List<Empresa> empresas = empresaController.findAll();
		for(Empresa empresafisrt:empresas) {
			this.empresa = empresafisrt;
			break;
		}

		funcionario.setNome("Nome Teste JUnit");
		funcionario.setCargo("Cargo Teste JUnit");
		funcionario.setSetor("Setor Teste JUnit");
		funcionario.setDataNascimento(new Date());
		funcionario.setCpf("99999999999999");
		funcionario.setCelular("(99) 99999-9999") ;
		funcionario.setTelefone("(99) 9999-9999");
		funcionario.setCep("99999-999") ;
		funcionario.setEndereco("Endereco Teste ");
		funcionario.setNumero("999999") ;
		funcionario.setComplemento("Complemento Teste JUnit");
		funcionario.setBairro("Bairro Teste JUnit") ;
		funcionario.setCidade("Cidade Teste JUnit");
		funcionario.setUf("TS") ;
		funcionario.setReferencia("Referencia Teste JUnit");
		funcionario.setObservacao("Observacao Teste JUnit") ;
		funcionario.setEmail("Email Teste JUnit");
		funcionario.setEmpresa(empresa);
		

		this.mockMvc.perform(MockMvcRequestBuilders.post("/funcionario")
				.content(asJsonString(funcionario))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				).andExpect(ok)
                 .andDo(MockMvcResultHandlers.print());
    }
	
	@Test
    public void testFuncionarioControllerList() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();

		this.mockMvc.perform(MockMvcRequestBuilders.get("/funcionario"))
		 .andExpect(ok);
    }
	
	@Test
    public void testFuncionarioControllerUpdate() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		funcionario.setId(id);
		funcionario.setNome("Nome Teste JUnit - ALTERADO");
		funcionario.setCargo("Cargo Teste JUnit - ALTERADO");
		funcionario.setSetor("Setor Teste JUnit - ALTERADO");
		funcionario.setDataNascimento(new Date());
		funcionario.setCpf("00000000000000");
		funcionario.setCelular("(00) 00000-0000") ;
		funcionario.setTelefone("(00) 0000-0000");
		funcionario.setCep("00000-000") ;
		funcionario.setEndereco("Endereco Teste - ALTERADO");
		funcionario.setNumero("00000") ;
		funcionario.setComplemento("Complemento Teste JUnit - ALTERADO");
		funcionario.setBairro("Bairro Teste JUnit - ALTERADO") ;
		funcionario.setCidade("Cidade Teste JUnit - ALTERADO");
		funcionario.setUf("AL") ;
		funcionario.setReferencia("Referencia Teste JUnit - ALTERADO");
		funcionario.setObservacao("Observacao Teste JUnit - ALTERADO") ;
		funcionario.setEmail("Email Teste JUnit - ALTERADO");
		
		this.mockMvc.perform(MockMvcRequestBuilders.put("/funcionario/" + funcionario.getId())
	              .content(asJsonString(funcionario))
	              .contentType(MediaType.APPLICATION_JSON)
	              .accept(MediaType.APPLICATION_JSON)
				).andExpect(ok)
        		 .andDo(MockMvcResultHandlers.print());
    }
	
	@Test
    public void testFuncionarioControllerDelete() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/funcionario/"+id)).andExpect(ok);
    }
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	
}