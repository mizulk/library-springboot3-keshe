package pers.mizulk.library.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Result<T> {
	private Integer code;
	private String msg;
	private T data;

	public static <T> Result<T> success() {
		return new Result<>(200, "成功", null);
	}

	public static <T> Result<T> success(T data) {
		return new Result<>(200, "成功", data);
	}

	public static <T> Result<T> error(Integer code, String msg) {
		return new Result<>(code, msg, null);
	}

	public static <T> Result<T> error(Integer code) {
		return new Result<>(code, "error", null);
	}
}
