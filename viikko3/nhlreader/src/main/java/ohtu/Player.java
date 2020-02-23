
package ohtu;

public class Player {
    private int goals;
    private int assists;
    private String name;
    private int penalties;
    private String team;
    private String nationality;
    private String birthdate;

    public Player(int goals, int assists, String name, int penalties, String team, String nationality,
            String birthdate) {
        this.goals = goals;
        this.assists = assists;
        this.name = name;
        this.penalties = penalties;
        this.team = team;
        this.nationality = nationality;
        this.birthdate = birthdate;
    }

    public int getTotal() {
        return this.goals + this.assists;
    }

    public String getNationality() {
        return this.nationality;
    }

    @Override
    public String toString() {
        return formattedPlayerString() + "\n" + "--------------------------------------------------";
    }

    private String formattedPlayerString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        for (int i = this.name.length(); i < 25; i++) {
            sb.append(" ");
        }
        sb.append(this.team);
        for (int i = this.team.length(); i < 10; i++) {
            sb.append(" ");
        }
        sb.append(this.goals);
        if (this.goals < 10) {
            sb.append("  + ");
        } else {
            sb.append(" + ");
        }
        sb.append(this.assists);
        if (this.assists < 10) {
            sb.append("  = ");
        } else {
            sb.append(" = ");
        }
        sb.append((this.assists + this.goals));
        if (this.assists + this.goals < 10) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
