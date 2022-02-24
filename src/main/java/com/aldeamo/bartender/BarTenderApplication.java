package com.aldeamo.bartender;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "BarTender API", version = "1.0", description = "Eres un bar ténder del bar más famoso de tu ciudad. Hay un arreglo de vasos numerados que está\n" +
		"representado por el arreglo A. Adicional se tiene un arreglo con números primos representado\n" +
		"por P.\n" +
		"\n" +
		"Valor del array P\n" +
		"P=2,3,5,7,11,13,17...\n" +
		"\n" +
		"En cada iteración Qi, retira cada vaso de la parte superior del arreglo A. Determina si el número\n" +
		"del plato es divisible uniformemente por el Pi número primo. Si lo es, agréguelo en un arreglo B.\n" +
		"En caso contrario, añádalo a un arreglo Ai. Guarda los valores de B en el arreglo Respuesta. En\n" +
		"la siguiente iteración, haz lo mismo con los valores del arreglo Ai. Una vez completado el\n" +
		"número necesario de iteraciones Q, almacene los valores restantes de Ai, al final de Respuesta.\n" +
		"\n" +
		"Se debe exponer un API que reciba un numero de iteraciones Q y un número del 1 al 5 que\n" +
		"representara el id de la pila de datos a trabajar (script de DB entregados) y entregue el array de\n" +
		"respuesta\n" +
		"\n" +
		"//Ejemplo\n" +
		"\n" +
		"INPUT\n" +
		"\n" +
		"www.aldeamo.com Cra 17aNo 106–30(+601) 6291066 –2148041\n" +
		"Bogotá, Colombia\n" +
		"A0=2,3,4,5,6,7\n" +
		"Q=3\n" +
		"\n" +
		"Q1:\n" +
		"B=6,4,2\n" +
		"A1=7,5,3\n" +
		"Respuesta=6,4,2\n" +
		"\n" +
		"Q2:\n" +
		"A1=7,5,3\n" +
		"B=3\n" +
		"A2=5,7\n" +
		"Respuesta=6,4,2,3\n" +
		"\n" +
		"Q3:\n" +
		"A2=5,7\n" +
		"B=5\n" +
		"A3=7\n" +
		"Respuesta=6,4,2,3,5\n" +
		"\n" +
		"Como Q ya se completó entonces:\n" +
		"\n" +
		"OUTPUT\n" +
		"Respuesta=6,4,2,3,5,7"))
public class BarTenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarTenderApplication.class, args);
	}

}
