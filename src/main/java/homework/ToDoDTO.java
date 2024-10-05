package homework;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ToDoDTO {
    private String id;
    private String title;
    private String content;
    private StatusToDo status = StatusToDo.UNDONE;
    private LocalDateTime created_time = LocalDateTime.now();
}
