package EcommerceController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import Ecommerce.Model.Usuario;
import Ecommerce.Repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>>getAll(){
		return  ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idusuario}")
	public ResponseEntity<Usuario>getByid(@PathVariable long idusuario){
		return repository.findById(idusuario)
				.map(resp -> ResponseEntity.ok(resp))
		        .orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
    public ResponseEntity<Usuario> post (@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> put (@RequestBody Usuario usuario){
        return ResponseEntity.ok(repository.save(usuario));
    }

    @DeleteMapping
    public void delete (@PathVariable long idusuario) {
        repository.deleteById(idusuario);
    }


}
