package io.github.cristianpenteado.crud_produtos.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }


}
