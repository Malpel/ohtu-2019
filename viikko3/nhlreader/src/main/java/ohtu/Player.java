
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String nationality;
    private String team;
    private int goals;
    private int assists;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNationality() { return nationality; }

    public int getGoals() { return goals; }

    public int getAssists() { return assists; }

    public int getPoints() { return goals + assists; }

    @Override
    public String toString() {
        return name + ", " + team + ", " + goals + " + " + assists + " = " + (goals + assists);
    }

    @Override
    public int compareTo(Player player) {
        return player.getPoints() - this.getPoints();
    }
}
