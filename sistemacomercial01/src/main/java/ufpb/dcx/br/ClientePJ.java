package ufpb.dcx.br;

public class ClientePJ extends Cliente{
    private String CNPJ;

    public ClientePJ(String endereco, String email, String CNPJ) {
        super(null, endereco, email);
        this.CNPJ = CNPJ;
    }
    @Override
    public String getId() {
        return this.CNPJ;
    }
}

