package Ecommerce.Model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  long idUsuario;

    @NotNull
    @Size(min = 12, max= 100)
    private String nome;
    @NotNull
    @Size(min = 5, max= 100)
    private String usario;
    @NotNull
    @Size(min = 5, max= 100)
    private String senha;
    
    @ManyToOne
    @JsonIgnoreProperties("usuario")
    private Loja loja;

    @ManyToOne
    @JsonIgnoreProperties("usuario")
    private Produto produto;
    
    

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUsario() {
        return usario;
    }
    public void setUsario(String usario) {
        this.usario = usario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
