package edu.sylymonka.theater.config;/*
  @author   silim
  @project   theater
  @class  SwaggerConfiguration
  @version  1.0.0 
  @since 28.05.2024 - 17.54
*/

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Theater API",
                description = "API for theater website",
                version = "1.0.0",
                contact = @Contact(
                        name = "Pavlo Sylymonka",
                        email = "sylymonka.p@gmail.com"

                )
        )
)
public class SwaggerConfiguration {
}
