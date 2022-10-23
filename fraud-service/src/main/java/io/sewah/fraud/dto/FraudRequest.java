package io.sewah.fraud.dto;


public record FraudRequest (
    String firstName,
    String lastName,
    String email
){

}
