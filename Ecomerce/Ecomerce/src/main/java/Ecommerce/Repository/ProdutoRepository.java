package Ecommerce.Repository;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Ecommerce.Model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
		
	public List<Produto> findAllByTituloprodutoContainingIgnoreCase (String tituloproduto);
			
	public List<Produto> findAllByValorLessThanEqual (float valor);
			
    public List<Produto> findAllByValorGreaterThanEqual (float valor);
			
    @Query(value = "SELECT * FROM tb_produto where valor = :valor", nativeQuery = true)
    public List<Produto> findAllByValor(@Param("valor") float valor);
				    


	}

