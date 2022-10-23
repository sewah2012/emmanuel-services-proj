package io.sewah.customer.dto;


public record CustomerRequest (
    String firstName,
    String lastName,
    String email
){

}
