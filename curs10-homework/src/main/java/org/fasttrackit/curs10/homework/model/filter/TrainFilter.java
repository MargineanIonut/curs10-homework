package org.fasttrackit.curs10.homework.model.filter;

public record TrainFilter(String id,String model, Integer carts, Short minCartsNumber, Short maxCartsNumber, String location) {
}
