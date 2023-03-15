package com.movielibrary.demo.client.internal;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ClientServiceImpl {

    private final ClientRepository clientRepository;
}
