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
        ClientDto clientDto = new ClientDto();
        clientDto.setIdclient(client.getIdclient());
        clientDto.setName(clientDto.getName());
        clientDto.setCompany(client.getCompany());
        clientDto.setEmail(client.getEmail());
        clientDto.setPhone(client.getPhone());
        clientDto.setNotes(client.getNotes());
        clientDto.setIduser(client.getUser().getId());
        return clientDto;
    }

    public void saveClient(ClientDto clientDto) {
        if (clientDto.getIdclient() != null ){
            //Es una actualización
            clientRepository.updateParcialClient(
                    clientDto.getName(),
                    clientDto.getCompany(),
                    clientDto.getPhone(),
                    clientDto.getNotes(),
                    clientDto.getIduser(),
                    clientDto.getIdclient()
            );
        } else {
            //Es un registro nuevo
            Client client = new Client();
            client.setName(clientDto.getName());
            client.setCompany(clientDto.getCompany());
            client.setEmail(clientDto.getEmail());
            client.setPhone(clientDto.getPhone());
            client.setNotes(clientDto.getNotes());
            client.setUser(userRepository.findById(clientDto.getIduser()).orElse(null));
            clientRepository.save(client);
        }
    }
}
