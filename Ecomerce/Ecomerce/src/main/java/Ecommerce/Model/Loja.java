package Ecommerce.Model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_loja")

public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idloja;
    
    @NotNull
    @Size (min = 5, max = 50 )
    private String nomeLoja;
    
    @NotNull
    @Size (min = 5, max = 250 )
    private String descricao;
    
    @ManyToOne
    @JsonIgnoreProperties("loja")
    private Produto produto;

    @OneToMany(mappedBy = "loja", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("loja")
    private List<Usuario>usuario;
    
    public long getIdloja() {
        return idloja;
    }
    public void setIdloja(long idloja) {
        this.idloja = idloja;
    }
 
    public String getNomeLoja() {
		return nomeLoja;
	}
	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
	public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    }


