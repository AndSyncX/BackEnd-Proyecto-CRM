package com.j_d_solutions.crm.client;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/clients")
@RequiredArgsConstructor
@RestController // -> Lo que se devuelve en los métodos se convierte en JSON (se usa para API REST)
public class ClientController {
    private final ClientService clientService;

    // Obtener todos los clientes
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getClients();
    }

    // Obtener cliente por ID
    @GetMapping("{id}")
    public Client getClientById(@PathVariable int id){ // PathVariable -> Captura el valor de la URL y lo asigna a la variable id
        return clientService.getClientById(id);
    }

    // Crear nuevo cliente
    @PostMapping
    public Client createClient(@RequestBody ClientDto clientDto) { // RequestBody -> Toma el contenido del cuerpo (body) de la petición HTTP, lo convierte desde JSON a un objeto JAVA
        return clientService.createClient(clientDto);
    }

    // Editar cliente
    @PutMapping("{id}")
    public ClientDto updateClient(@PathVariable int id, @RequestBody ClientDto clientDto) {
        return clientService.updateClient(clientDto, id);
    }
}
