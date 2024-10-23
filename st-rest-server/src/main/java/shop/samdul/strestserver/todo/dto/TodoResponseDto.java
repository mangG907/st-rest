package shop.samdul.strestserver.todo.dto;

import lombok.Data;
import shop.samdul.strestserver.todo.entity.TodoEntity;

import java.time.LocalDateTime;

@Data
public class TodoResponseDto {

    private Integer id;
    private String subject;
    private String body;
    private Boolean completed;
    private LocalDateTime createdAt;

    public TodoResponseDto(TodoEntity todo) {
        this.id = todo.getId();
        this.subject = todo.getSubject();
        this.body = todo.getBody();
        this.completed = todo.getCompleted();
        this.createdAt = todo.getCreatedAt();
    }
}