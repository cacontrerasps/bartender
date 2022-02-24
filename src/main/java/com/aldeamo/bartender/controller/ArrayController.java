package com.aldeamo.bartender.controller;

import com.aldeamo.bartender.model.SendBarTender;
import com.aldeamo.bartender.service.ArrayService;
import com.aldeamo.bartender.workstack.WorkStack;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/arrays")
public class ArrayController {
    @Autowired
    ArrayService arrayService;

    @Value("${spring.datasource.primos}")
    String primos;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pasos",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SendBarTender.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id o iteracionQ supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No encontrados",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error",
                    content = @Content)})
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<String>> barTender(@RequestBody SendBarTender datos) {
        if (datos.getIteracionesQ() < 1 || datos.getId() < 1) {
            return new ResponseEntity<List<String>>(Collections.singletonList("Todos los campos son obligatorios"), null, HttpStatus.BAD_REQUEST);
        }
        String arraySend = (arrayService.getArray(datos.getId())!=null)?arrayService.getArray(datos.getId()).getInputArray():null;
        if(arraySend==null){
            WorkStack response = new WorkStack(datos.getIteracionesQ(), arraySend, primos);
            return new ResponseEntity<List<String>>(Collections.singletonList("No encontrado"), null, HttpStatus.NOT_FOUND);
        }
        if (arraySend.isEmpty()) {
            return new ResponseEntity<List<String>>(Collections.singletonList("No hay nada en BD"), null, HttpStatus.NOT_FOUND);
        }
        WorkStack response = new WorkStack(datos.getIteracionesQ(), arraySend, primos);
        return new ResponseEntity<List<String>>(response.responseStack(), null, HttpStatus.OK);
    }
}
