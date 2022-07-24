package org.fasttrackit.curs10.homework.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrainNotFoundException extends RuntimeException {
    public final String MESSAGE = "This train is not present in the database";

}
