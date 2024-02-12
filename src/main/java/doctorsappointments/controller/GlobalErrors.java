package doctorsappointments.controller;

import doctorsappointments.dto.ErrorDTO;
import doctorsappointments.enums.ErrorEnum;
import doctorsappointments.exception.BadRequestException;
import doctorsappointments.exception.NotFoundException;
import doctorsappointments.exception.UnauthorizatedException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrors {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDTO> badRequestException(BadRequestException e){
        ErrorEnum error = e.getError();
        ErrorDTO errorDTO = new ErrorDTO(error.getCode(), error.getMessage());

        return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(errorDTO);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundException(NotFoundException e){
        ErrorEnum error = e.getError();
        ErrorDTO errorDTO = new ErrorDTO(error.getCode(), error.getMessage());

        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(errorDTO);
    }

    @ExceptionHandler(UnauthorizatedException.class)
    public ResponseEntity<ErrorDTO> unauthorizatedException(UnauthorizatedException e){
        ErrorEnum error = e.getError();
        ErrorDTO errorDTO = new ErrorDTO(error.getCode(), error.getMessage());

        return ResponseEntity.status(HttpStatusCode.valueOf(401)).body(errorDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> genericError(BadRequestException e){
        ErrorEnum error = ErrorEnum.GENERIC_ERROR;
        ErrorDTO errorDTO = new ErrorDTO(error.getCode(), error.getMessage());

        return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(errorDTO);
    }
}
