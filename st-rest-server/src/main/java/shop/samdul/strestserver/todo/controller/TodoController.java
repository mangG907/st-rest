package shop.samdul.strestserver.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.samdul.strestserver.todo.dto.TodoRequestDto;
import shop.samdul.strestserver.todo.dto.TodoResponseDto;
import shop.samdul.strestserver.todo.entity.TodoEntity;
import shop.samdul.strestserver.todo.service.TodoService;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
@Slf4j
public class TodoController {

    private final TodoService todoService;

    /* C - Create */
    @PostMapping("/create")
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody TodoRequestDto requestDto) {

        log.info("requestDto: {}", requestDto.toString());

        TodoResponseDto todo = todoService.createTodo(requestDto);
        return ResponseEntity.ok().body(todo);
    }

    /* R - Read */
    /* http://localhost:8080/api/v1/todo/get/all */
    @GetMapping("/get/all")
    public ResponseEntity<List<TodoEntity>> findByAll() {
        List<TodoEntity> all = todoService.findAll();
        return ResponseEntity.ok().body(all);
    }

    /* U - Update */
    /* http://localhost:8080/update/complete/{id}/{completed} */
    @PutMapping("/update/complete/{id}/{completed}")
    public ResponseEntity<TodoEntity> updateComplete(
            @PathVariable("id") Integer id,
            @PathVariable("completed") Boolean completed
    ) {
        TodoEntity todoEntity = todoService.updateComplete(id, completed);
        return ResponseEntity.ok().body(todoEntity);
    }

    /* D - Delete */
    /* http://localhost:8080/delete*/
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTodo(
            @RequestParam Integer id
    ) {
        todoService.deleteTodo(id);

        return ResponseEntity.ok().body("성공적으로 Todo를 삭제 하였습니다.");
    }
}