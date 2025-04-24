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

    public Client getClientById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    public ClientDto getClientDtoById(int id) {
        Client client = getClientById(id);
        ClientDto dto = new ClientDto();
        dto.setIdclient(client.getIdclient());
        dto.setName(client.getName());
        dto.setCompany(client.getCompany());
        dto.setEmail(client.getEmail());
        dto.setPhone(client.getPhone());
        dto.setNotes(client.getNotes());
        dto.setIduser(client.getUser().getId());
        return dto;
    }

    public Client createClient(ClientDto dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setCompany(dto.getCompany());
        client.setEmail(dto.getEmail());
        client.setPhone(dto.getPhone());
        client.setNotes(dto.getNotes());
        client.setUser(userRepository.findById(dto.getIduser()).orElse(null));
        return clientRepository.save(client);
    }

    public ClientDto updateClient(ClientDto dto, int id) {
        if (!clientRepository.existsById(id)){
            throw new RuntimeException("Cliente no encontrado");
        }
        clientRepository.updateParcialClient(
                dto.getName(),
                dto.getCompany(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getNotes(),
                dto.getIduser(),
                id
        );
        return dto;
    }
}
