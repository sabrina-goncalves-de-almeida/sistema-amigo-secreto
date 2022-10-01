package org.example.ufpb.dcx.br;

import org.junit.jupiter.api.Test;
import ufpb.dcx.br.*;

import java.util.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class SistemaComercialMapTest {

    @Test
    public void testaCadastroProdutos() throws ProdutoNaoExisteException {
        SistemaComercialMap sistema = new SistemaComercialMap();
        Collection<Produto> alimentos = sistema.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);
        System.out.println(alimentos);

        Cliente cliente = new ClientePF("Ana", "rua 0","ana@gmail.com","112.223.223-34");

        assertTrue(alimentos.size()==0);

        assertTrue(sistema.cadastraCliente(cliente));
        assertTrue(sistema.existeCliente(cliente));

        try{
            sistema.pesquisaCliente("112.223.223-34");
        }catch (ClienteNaoExisteException e){
            e.getMessage();
        }

        Produto produto = new Produto("000-ff","água sem gás",2.00,1,CategoriaProduto.ALIMENTO);

        sistema.cadastraProduto(produto);

        alimentos = sistema.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);

        try{
            sistema.pesquisaProduto("000-ff");
        }catch (ProdutoNaoExisteException e){
            e.getMessage();
        }

        System.out.println(produto.getCategoria());
        assertEquals(1, alimentos.size());

        assertEquals("000-ff", produto.getCodigo());

    }
}
