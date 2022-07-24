package org.fasttrackit.curs10.homework.model;

import lombok.Builder;

import java.util.List;

public record Location (String city)
{
    @Builder public Location{}
}
