package com.hazelcast.spring.caching.interceptor.springcachinginterceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.map.MapInterceptor;

import com.hazelcast.config.Config;
import com.hazelcast.core.EntryEvent;
import com.hazelcast.map.listener.EntryAddedListener;
import com.hazelcast.map.listener.EntryRemovedListener;
import com.hazelcast.map.listener.EntryUpdatedListener;
import com.hazelcast.core.*;
import com.hazelcast.map.IMap;

@SpringBootApplication
public class SpringCachingInterceptorApplication {

    public static void main(String[] args) {
        Config config = new Config();
        config.setProperty("hazelcast.map.entry.filtering.natural.event.types", "true");
        HazelcastInstance cache = Hazelcast.newHazelcastInstance(config);
        IMap<String, String> map = cache.getMap("cachedMessages");
        map.addEntryListener(new MyEntryListener(), true);
        System.out.println("Entry Listener registered");
    }

    static class MyEntryListener implements EntryAddedListener<String, String> {

        @Override
        public void entryAdded(EntryEvent<String, String> event) {
            System.out.println("****new message Added :" + event.getValue());
        }
    }
}
