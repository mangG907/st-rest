package shop.samdul.strestserver.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import shop.samdul.strestserver.todo.dto.TodoRequestDto;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Getter
public class TodoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subject;
    private String body;
    private Boolean completed;
    private LocalDateTime createdAt;

    public TodoEntity(TodoRequestDto todoRequestDto) {
        this.subject= todoRequestDto.getSubject();
        this.body= todoRequestDto.getBody();
        this.completed= false;
        this.createdAt = LocalDateTime.now();

    }

    public TodoEntity() {

    }
}
