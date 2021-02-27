package com.metier.conducteurservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorDetail
{
    private Date timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
