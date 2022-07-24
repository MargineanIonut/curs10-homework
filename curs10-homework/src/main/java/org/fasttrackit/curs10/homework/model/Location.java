package org.fasttrackit.curs10.homework.model;

import lombok.Builder;

public record Location (String city)
{
    @Builder public Location{}
}
