package com.udemy.hello.validator;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;

public class HelloJobParametersValidator implements JobParametersValidator{

	@Override
	public void validate(JobParameters parameters) throws JobParametersInvalidException {
		// parameter1の値チエック
		String param1 = parameters.getString("param1");
		if(!param1.equals("DEV") && !param1.equals("TEST") && !param1.equals("PROD")) {
			throw new JobParametersInvalidException("param1:" + param1 + "：指定の引数ではありません。");
		}
		
		// parameter2の値チエック
		String param2 = parameters.getString("param2");
		
		//数値であることをチェック
		try {
			Integer.parseInt(param2);
		} catch (Exception e) {
			throw new JobParametersInvalidException("param2:" + param2 + "：引数の型が数値ではありません。");
		}
	}

}
