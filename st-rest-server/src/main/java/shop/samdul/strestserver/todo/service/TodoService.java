package shop.samdul.strestserver.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.samdul.strestserver.todo.dto.TodoRequestDto;
import shop.samdul.strestserver.todo.dto.TodoResponseDto;
import shop.samdul.strestserver.todo.entity.TodoEntity;
import shop.samdul.strestserver.todo.repository.TodoRepository;

@Service
@RequiredArgsConstructor

public class TodoService {
    private final TodoRepository todoRepository;

//    할 일 저장
    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        TodoEntity newTodo = new TodoEntity(requestDto);
        TodoEntity save = todoRepository.save(newTodo);
        return new TodoResponseDto(save);
    }

}
