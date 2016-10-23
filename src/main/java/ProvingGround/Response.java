package ProvingGround;

import java.util.List;

/**
 * @author: rudy
 * @date: 2016/10/22
 */
public class Response {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(int takeTime) {
        this.takeTime = takeTime;
    }

    private int code;
    private List data;
    private String message;
    private int takeTime;
}
