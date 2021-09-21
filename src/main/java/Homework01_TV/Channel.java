package Homework01_TV;

public class Channel {
    private String title;
    private Program[] programs_List;

    public Program[] getPrograms_List() {
        return programs_List;
    }

    private int programsCount;

    public Channel(String title) {
        this.title = title;
        this.programs_List = new Program[3];
        this.programsCount = 0;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void addProgram(Program program) {
        this.programs_List[programsCount] = program;
        this.programsCount++;
    }
}
