package com.j_d_solutions.crm.task;

import com.j_d_solutions.crm.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final ClientRepository clientRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    public TaskDto getTaskDtoById(int id) {
        Task task = getTaskById(id);
        TaskDto taskDto = new TaskDto();
        taskDto.setIdtask(task.getIdtask());
        taskDto.setTitle(task.getTitle());
        taskDto.setIdclient(task.getClient().getIdclient());
        taskDto.setType(task.getType());
        taskDto.setDue_date(task.getDue_date());
        taskDto.setNotes(task.getNotes());
        return taskDto;
    }

    public Task createTask(TaskDto dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setClient(clientRepository.findById(dto.getIdclient()).orElse(null));
        task.setType(dto.getType());
        task.setDue_date(dto.getDue_date());
        task.setNotes(dto.getNotes());
        return taskRepository.save(task);
    }

    public TaskDto updateTask(TaskDto dto, int id) {
        if (!taskRepository.existsById(id)){
            throw new RuntimeException("Tarea no encontrada");
        }
        taskRepository.updateParcialTask(
                dto.getTitle(),
                dto.getIdclient(),
                dto.getType(),
                dto.getDue_date(),
                dto.getNotes(),
                id
        );
        return dto;
    }
}
