package org.sda.RentCar.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.sda.RentCar.exception.BadRequestException;
import org.sda.RentCar.exception.NotAllowedException;
import org.sda.RentCar.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdvice {

    private static Logger logger= LoggerFactory.getLogger(ControllerAdvice.class);
    @ExceptionHandler(NotAllowedException.class)
    public ResponseEntity<ErrorFormat> handleNotAllowedException(NotAllowedException notAllowedException, HttpServletRequest httpServletRequest) {
        ErrorFormat errorFormat = new ErrorFormat(
                notAllowedException.getMessage(),
                LocalDateTime.now(),httpServletRequest.getServletPath()
        );
        logger.error(notAllowedException.getMessage());
        return new ResponseEntity<>(errorFormat, HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(BadRequestException.class)

    public ResponseEntity<ErrorFormat> handleBadRequestException(BadRequestException badRequestException,HttpServletRequest httpServletRequest) {
        ErrorFormat errorFormat = new ErrorFormat(
                badRequestException.getMessage(),
                LocalDateTime.now(),
                httpServletRequest.getServletPath()
        );
        return new ResponseEntity<>(errorFormat, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorFormat> handleNotFoundException(NotFoundException notFoundException,HttpServletRequest httpServletRequest){
        ErrorFormat errorFormat=new ErrorFormat(
                notFoundException.getMessage(),
                LocalDateTime.now(),
                httpServletRequest.getServletPath()

        );
        return new ResponseEntity<>(errorFormat,HttpStatus.NOT_FOUND);
    }





}
