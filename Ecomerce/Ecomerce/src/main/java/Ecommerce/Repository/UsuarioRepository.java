package Ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Ecommerce.Model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

}