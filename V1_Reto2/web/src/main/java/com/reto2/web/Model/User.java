package com.reto2.web.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "usuarios")
@Data
@NoArgsConstructor                              //  CONSTRUCTOR PARA LA ENTIDAD
@AllArgsConstructor                             //  CONSTRUCTOR CON TODOS LOS ARGUMENTOS
    public class User {

        @Id
        private Integer id;                     //  CONJUNTO DE ATRIBUTOS
        private String  identification;
        private String  name;
        private String  address;
        private String  cellPhone;
        private String  email;
        private String  password;
        private String  zone;
        private String  type;
}
