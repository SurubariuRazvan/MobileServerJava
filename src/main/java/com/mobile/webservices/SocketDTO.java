package com.mobile.webservices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SocketDTO<T> {
    private String event;
    private T      payload;
}
