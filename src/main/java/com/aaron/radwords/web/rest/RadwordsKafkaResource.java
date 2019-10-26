package com.aaron.radwords.web.rest;

import com.aaron.radwords.service.RadwordsKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
@CrossOrigin("*")
public class RadwordsKafkaResource {

    private final Logger log = LoggerFactory.getLogger(RadwordsKafkaResource.class);

    private RadwordsKafkaProducer kafkaProducer;

    public RadwordsKafkaResource(RadwordsKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }

    @PostMapping("/text")
    public String addText(@RequestBody String text) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (String word : removePunctuationAndCase(text).split("\\s+")) {
                    sendMessageToKafkaTopic(word);
                }
            }
        });
        t1.start();
        return "Submitted";
    }

    private String removePunctuationAndCase(String text){
        return text.replaceAll("[^a-zA-Z ]", "").toLowerCase(); // .split("\\s+")[0];
    }
}
