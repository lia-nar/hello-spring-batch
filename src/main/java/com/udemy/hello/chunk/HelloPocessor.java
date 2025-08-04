package com.udemy.hello.chunk;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("HelloPocessor")
@StepScope
@Slf4j
public class HelloPocessor implements ItemProcessor<String,String>  {
	@Override
	public String process(String item) throws Exception {
		// 読み込んだデータに対する処理を記述
		// 文字列を大文字に変更する
		item = item.toUpperCase();
		
		log.info("Processor item={}", item);
		
		return item;
	}
	

}
