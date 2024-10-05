package homework;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class ToDoService {

    List<ToDoDTO> toDoList = new LinkedList<>();

    public boolean create(ToDoDTO dto) {
        dto.setId(UUID.randomUUID().toString());
        return toDoList.add(dto);
    }

    public List<ToDoDTO> getAll() {
        return toDoList;
    }

    public List<ToDoDTO> doneToDo() {
        List<ToDoDTO> doneList = new LinkedList<>();
        for(ToDoDTO dto : toDoList){
            if(dto.getStatus()==StatusToDo.DONE){
                doneList.add(dto);
            }
        }
        return doneList;
    }

    public List<ToDoDTO> UnDoneToDo() {
        List<ToDoDTO> UnDoneList = new LinkedList<>();
        for(ToDoDTO dto : toDoList){
            if(dto.getStatus()==StatusToDo.UNDONE){
                UnDoneList.add(dto);
            }
        }
        return UnDoneList;
    }

    public String ticking(String id) {
        for(ToDoDTO dto : toDoList){
            if(dto.getId().equals(id)){
                dto.setStatus(StatusToDo.DONE);
               return dto.getTitle()+" is done";
            }
        }
       return "Task belonging to this id does not exist";
    }

    public String delete(String id) {
        for(ToDoDTO dto : toDoList){
            if(dto.getId().equals(id)){
                toDoList.remove(dto);
                return dto.getTitle()+" is deleted";
            }
        }
        return "Task belonging to this id may already been deleted";
    }
}
