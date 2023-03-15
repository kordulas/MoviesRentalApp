package com.movielibrary.demo.client.internal;

import com.movielibrary.demo.client.api.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
