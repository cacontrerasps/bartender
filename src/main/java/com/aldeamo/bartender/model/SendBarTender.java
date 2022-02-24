package com.aldeamo.bartender.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class SendBarTender {
    @NotBlank
    @Min(value = 1, message = "id no puede ser menor a 1")
    @Max(value = 6, message = "id no puede ser mayor a 6")
    private Integer id;
    @NotBlank
    @Min(value = 1, message = "iteracionesQ no puede ser menor a 1")
    private Integer iteracionesQ;

    public SendBarTender(Integer id, Integer iteracionesQ) {
        this.id = id;
        this.iteracionesQ = iteracionesQ;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIteracionesQ() {
        return iteracionesQ;
    }


}
