package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@RestController
@RequestMapping("")
public class Forwarder {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{url}/**")
    public ResponseEntity<byte[]> forwardToUrl(@PathVariable String url, HttpServletRequest request) throws IOException {
        String forwardUrl = "http://" + url + request.getRequestURI().replaceFirst("/" + url, "");
        HttpMethod method = HttpMethod.valueOf(request.getMethod());

        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.set(headerName, request.getHeader(headerName));
        }

        HttpEntity<byte[]> entity = new HttpEntity<>(headers);

        ResponseEntity<byte[]> response = restTemplate.exchange(forwardUrl, method, entity, byte[].class);
        return response;
    }


}
