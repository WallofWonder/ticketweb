package com.dogeyes.zyf.util;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * 消息载体
 *
 * @author ZYF
 * @create 2021-3-28 13:33
 */
@Data
public class Message<T> {

    int status;

    String message;

    T data;

    public Message() {
    }

    public Message(HttpStatus status) {
        this.status = status.value();
        this.message = status.getReasonPhrase();
    }

    public Message(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message == null ? status.getReasonPhrase() : message;
    }

    public Message(HttpStatus status, String message, T data) {
        this(status, message);
        this.data = data;
    }

    public static <T> Message<T> custom(HttpStatus status, String message, T data) {
        return new Message(status, message, data);
    }

    public static <T> Message<T> custom(HttpStatus status, String message) {
        return new Message(status, message);
    }
}
