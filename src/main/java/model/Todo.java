package model;
public class Todo {
    private String title;
    private String description;
    private boolean completed=false;
    private int id;
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public boolean isCompleted(){
        return completed;
    }
    public void setTitle(String title){
        if(title==null||title.isBlank()){
            throw new IllegalArgumentException("Title can not be empty or null");
        }
        this.title=title;
    }
    public void setDescription(String description){
        if(description==null||description.isBlank()){
            throw new IllegalArgumentException("Description can not be empty or null");
        }
        this.description=description;
    }
    public void setCompleted(boolean completed){
        this.completed=completed;
    }
    public Todo(String title,String description,boolean completed){
        setDescription(description);
        setTitle(title);
        setCompleted(completed);      
    }
    public Todo(String title,String description){
        setTitle(title);
        setDescription(description);
    }
}