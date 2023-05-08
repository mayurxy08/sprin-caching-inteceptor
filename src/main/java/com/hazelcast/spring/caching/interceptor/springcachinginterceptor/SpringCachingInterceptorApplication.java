package com.hazelcast.spring.caching.interceptor.springcachinginterceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.Hazelcast;

@SpringBootApplication
public class SpringCachingInterceptorApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringCachingInterceptorApplication.class, args);
		
		HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        var cache =  hazelcastInstance.getMap("cachedMessages");
        cache.addInterceptor(new MessageInterceptor());
	}

}
