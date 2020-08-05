package com.natthawitjan.demo.pojo;

import lombok.Data;
import lombok.NonNull;

@Data
public class UsersResponse {

   @NonNull private final int id;
    @NonNull private final String name;
}
