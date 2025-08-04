package com.udemy.hello.chunk;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("HelloWriter")
@StepScope
@Slf4j
public class HelloWriter implements ItemWriter<String>{
	@Override
	public void write(Chunk<? extends String> chunk) throws Exception {
		
		// ItemProcessorで受け取った処理結果を書き込みます。
		log.info("Writer chunk={}", chunk);;
		log.info("--------------------------------");
		
	}

}
