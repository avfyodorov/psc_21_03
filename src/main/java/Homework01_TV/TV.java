package Homework01_TV;

public class TV {
    private String model;
    private Channel[] channel_List;
    private int programsCount;

    public Channel[] getChannel_List() {
        return channel_List;
    }

    public TV(String model) {
        this.model = model;
        this.channel_List = new Channel[1];
        this.programsCount = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void addChannel(Channel channel) {
        this.channel_List[programsCount] = channel;
        this.programsCount++;
    }
}
