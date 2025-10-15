package lessons.lesson_5.quiz_system;

import java.util.ArrayList;
import java.util.List;

public class Team extends Participant{
    private List<Player> playersList = new ArrayList<>();

    public void addMember(Player player){
        playersList.add(player);
    }

    public String getMembers(){
        StringBuilder allTeamMembers = new StringBuilder();
        for(Player player : playersList){
            allTeamMembers.append(player.getName()).append("\n");
        }
        return allTeamMembers.toString();
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public int getTotalScore(){
        int total = 0;
        for(Player player : playersList){
            total += player.getScore();
        }
        return total;
    }

    @Override
    public void showInfo(){
        System.out.println(getName());
        System.out.println(getMembers());
    }
}
