package com.sviryd.chat.domain.resource;

import lombok.NonNull;
import lombok.Value;

@Value
public class UserResource {
    @NonNull
    String username;
    @NonNull
    String password;
}
