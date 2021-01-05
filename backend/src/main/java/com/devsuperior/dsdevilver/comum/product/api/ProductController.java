package com.devsuperior.dsdevilver.comum.product.api;

import com.devsuperior.dsdevilver.comum.product.api.model.ProductResponse;
import com.devsuperior.dsdevilver.comum.product.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @PostMapping
//    @ApiOperation("Salvar um Produto")
//    public ResponseEntity<ProductResponse> cadastrar(@RequestBody @Valid InclusaoProdutoRequest request,
//                                                     UriComponentsBuilder uriBuilder) {
//
//        Product produto = request.toModel();
//
//        if(produtoRepository.existsByCodigo(produto.getCodigo())) {
//            throw new ProdutoDuplicadoException(request.getCodigo(), request.getDescricao());
//        }
//
//        Produto produtoCadastrado = produtoRepository.save(produto);
//
//        return ResponseEntity.created(ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/")
//                .path(produtoCadastrado.getId().toString()).build().toUri())
//                .body(produtoCadastrado);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> buscarTodos(){
        return  ResponseEntity
                .ok()
                .body(productService.findAll()
                );
    }

}
