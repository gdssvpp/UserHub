package gds.userhub.exceptions;

import gds.userhub.dao.dto.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UsersException extends Throwable {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("User already registered!", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(EntityNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
        public ResponseEntity threatUserNotFound(Exception exception){
            ExceptionDTO exceptionDTO = new ExceptionDTO("User not found!", "500");
            return ResponseEntity.internalServerError().body(exceptionDTO);
        }

    @ExceptionHandler(MissingFieldsException.class)
    public ResponseEntity<ExceptionDTO> handleCamposFaltantesException(MissingFieldsException exception) {
        ExceptionDTO erroDTO = new ExceptionDTO("Missing Fields.", "400");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroDTO);
    }
}
