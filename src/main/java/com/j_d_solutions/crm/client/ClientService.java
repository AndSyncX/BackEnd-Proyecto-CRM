package com.j_d_solutions.crm.client;

import com.j_d_solutions.crm.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // -> Genera un constructor con campos obligatorios (finales) como parámetros.
public class ClientService {
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }


}
