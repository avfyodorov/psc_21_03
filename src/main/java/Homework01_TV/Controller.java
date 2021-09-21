package Homework01_TV;

public class Controller {
    private TV tv;

    public Controller(TV tv) {
        this.tv = tv;
    }

    public TV getTv() {
        return tv;
    }

    public void on(int i) {
        Channel[] channel_list = tv.getChannel_List();
        Channel channel = channel_list[i - 1];
        Program[] programs_list = channel.getPrograms_List();
        int index = (int) Math.floor(Math.random() * programs_list.length);
        System.out.println(programs_list[index].getName());
    }
}
