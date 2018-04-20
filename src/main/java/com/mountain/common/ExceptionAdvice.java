package com.mountain.common;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description: TODO(描述类的作用)
 * @author xiewm
 * @date 2017年7月3日 下午3:37:41
 * 
 */

@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException e) {
		logger.error("参数解析失败", e);
		return new ResponseEntity<String>("could_not_read_json",
				HttpStatus.BAD_REQUEST);
	}

	/**
	 * 405 - Method Not Allowed
	 */
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> handleHttpRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException e) {
		logger.error("不支持当前请求方法", e);
		return new ResponseEntity<String>("request_method_not_supported",
				HttpStatus.METHOD_NOT_ALLOWED);
	}

	/**
	 * 415 - Unsupported Media Type
	 */
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<String> handleHttpMediaTypeNotSupportedException(
			Exception e) {
		logger.error("不支持当前媒体类型", e);
		return new ResponseEntity<String>("content_type_not_supported",
				HttpStatus.UNSUPPORTED_MEDIA_TYPE);
	}

	/**
	 * 500 - Internal Server Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		logger.error("服务运行异常", e);
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * 500 - Internal Server Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<String> handlePermissionException(Exception e) {
		logger.error("服务运行异常", e);
		return new ResponseEntity<String>(
				"You do not have permission to access the requested data or object!",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
