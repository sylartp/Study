package com.GrappleGame.Web.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by tppppp on 2016/12/13.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Not Found!")
public class TestException extends RuntimeException{
}
