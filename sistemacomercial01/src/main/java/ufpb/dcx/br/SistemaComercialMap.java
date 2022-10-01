package ufpb.dcx.br;


import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SistemaComercialMap implements SistemaComercial {
    private Map<String, Cliente> clientes = new HashMap<String, Cliente>();
    private Map<String, Produto> produtos  = new HashMap<String, Produto>();

    public void SistemaComercioEletronicoList () {
    }
    @Override
    public boolean existeProduto(Produto produto) {
        if (this.produtos.containsKey(produto.getCodigo())){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Produto pesquisaProduto(String codigoProduto)
            throws ProdutoNaoExisteException {
        if (this.produtos.containsKey(codigoProduto)) {
            return this.produtos.get(codigoProduto);
        }
        throw new ProdutoNaoExisteException("Não foi encontrado produto com o código "+codigoProduto);

    }
    public boolean cadastraCliente(Cliente cliente){
        if (clientes.containsValue(cliente)){
            return false;
        } else {
            this.clientes.put(cliente.getId(), cliente);
            return true;
        }
    }
    @Override
    public boolean cadastraProduto(Produto produto) {
        if (existeProduto(produto)) {
            return false;
        } else {
            this.produtos.put(produto.getCodigo(),produto);
            return true;
        }
    }

    public boolean existeCliente(Cliente cliente){
        if(this.clientes.containsKey(cliente.getId())){
            return true;
        }else{
            return false;
        }
    }

    public Cliente pesquisaCliente(String id) throws ClienteNaoExisteException{
        if(this.clientes.containsKey(id)){
            return this.clientes.get(id);
        }
        throw new ClienteNaoExisteException("Cliente de id:"+id+" não encontrado.");
    }

    public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria){
        Collection<Produto> listaDeProdutos = new ArrayList<>();
        for (Produto p: produtos.values()) {
            if (p.getCategoria().equals(categoria)){
                listaDeProdutos.add(p);
            }
        }

        return listaDeProdutos;
    }

}
