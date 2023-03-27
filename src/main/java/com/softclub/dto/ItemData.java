package com.softclub.dto;

import java.io.Serial;
import java.io.Serializable;

public record ItemData(long inventoryNumber) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
