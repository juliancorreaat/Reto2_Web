package com.reto2.web.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "gadgets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gadget {

        @Id
        private Integer id;
        private String  brand;
        private String  category;
        private String  name;
        private String  description;
        private Double  price;
        private Boolean availability = true;
        private Integer     quantity;
        private String  photography;

}
