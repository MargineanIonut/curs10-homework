package org.fasttrackit.curs10.homework.exception;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocationNotFoundException extends RuntimeException{
    public final String MESSAGE = "This location is not present in the database";

}
