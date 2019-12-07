package statistics.matcher;

import statistics.Player;

import java.util.ArrayList;

public class And implements Matcher {

    private Matcher[] matchers;

    public And(Matcher... matchers) {
        this.matchers = matchers;
    }

    public And(ArrayList<Matcher> matchers) {
        this.matchers = matchers.toArray(new Matcher[0]);
    }

    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (!matcher.matches(p)) {
                return false;
            }
        }

        return true;
    }
}
