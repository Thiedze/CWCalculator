package de.cw.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculatorUser {

    private String username;

    private String password;

    private String role;

}
