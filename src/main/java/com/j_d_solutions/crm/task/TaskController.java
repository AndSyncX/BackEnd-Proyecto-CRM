package com.j_d_solutions.crm.task;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/task")
@RequiredArgsConstructor
@RestController //-> convierte la clase en un "controlador" y convierte su contenido en un JSON
public class TaskController {
    private final TaskService taskService;

    // Obtener todas las tareas
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getTasks();
    }

    // Obtener tarea por ID
    @GetMapping("{id}")
    public Task getTaskById(@PathVariable int id) { // -> PathVariable -> Captura el valor de la URL y lo asigna a la variable id
        return taskService.getTaskById(id);
    }

    // Crear nueva tarea
    @PostMapping
    public Task createTask(@RequestBody TaskDto taskDto) { // RequestBody -> Toma el contenido del cuerpo (body) de la petición HTTP, lo convierte desde JSON a un objeto JAVA
        return taskService.createTask(taskDto);
    }

    // Editar tarea
    @PutMapping("{id}")
    public TaskDto updateTask(@PathVariable int id, @RequestBody TaskDto taskDto) { // PathVariable -> Captura el valor de la URL y lo asigna a la variable id
        return taskService.updateTask(taskDto, id);
    }
}
