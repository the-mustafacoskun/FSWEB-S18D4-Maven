package com.workintech.s18d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BurgerErrorResponse {
    private int status;
    private String message;
    private long timestamp;

    public BurgerErrorResponse(String expectedMessage) {
        this.message = expectedMessage;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }


}
