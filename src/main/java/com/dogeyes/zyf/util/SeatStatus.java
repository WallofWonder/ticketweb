package com.dogeyes.zyf.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZYF
 * @create 2021-5-5 14:33
 */
@Getter
@AllArgsConstructor
public enum SeatStatus {

    LOCKED(0),
    PAID(1),
    CANCELED(2);

    private final int value;
}
