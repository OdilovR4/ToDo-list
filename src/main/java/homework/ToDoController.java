package homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;


    @PostMapping("/creating")
    public boolean create(@RequestBody ToDoDTO dto){
        return toDoService.create(dto);
    }

    @GetMapping("/allTasks")
    public List<ToDoDTO> allTodo(){
        return toDoService.getAll();
    }

    @PutMapping("/ticking/{id}")
    public String tickTask(@PathVariable("id") String id){
        return toDoService.ticking(id);
    }

    @GetMapping("/doneTasks")
    public List<ToDoDTO> doneToDoList(){
        return toDoService.doneToDo();
    }

    @GetMapping("/undoneTasks")
    public List<ToDoDTO> UnDoneToDoList(){
        return toDoService.UnDoneToDo();
    }


    @DeleteMapping("/deleting/{id}")
    public String delete(@PathVariable String id){
        return toDoService.delete(id);
    }


}
